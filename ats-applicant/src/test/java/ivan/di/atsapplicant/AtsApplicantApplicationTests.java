package ivan.di.atsapplicant;

import com.fasterxml.jackson.databind.ObjectMapper;
import ivan.di.atsapplicant.model.dto.ApplicantDto;
import ivan.di.atsapplicant.repository.ApplicantRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class AtsApplicantApplicationTests extends AbstractApplicantTest {
    @Container
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2");

    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();;

    @DynamicPropertySource
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    public void success_createApplicant() throws Exception {
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(APPLICANT_URI)
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(getApplicantDto())))
            .andExpect(status().isCreated())
            .andReturn();

        // convert response body to DTO
        ApplicantDto createdApplicantDto = objectMapper.readValue(result.getResponse().getContentAsString(), ApplicantDto.class);
        Assertions.assertNotNull(createdApplicantDto.getId());
    }

    @Test
    public void success_findApplicant() throws Exception {
        ApplicantDto applicantDto = getApplicantDto();
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(APPLICANT_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(applicantDto)))
            .andExpect(status().isCreated())
            .andReturn();

        // convert response body to DTO
        ApplicantDto createdApplicantDto = objectMapper.readValue(result.getResponse().getContentAsString(), ApplicantDto.class);
        String createdId = createdApplicantDto.getId();
        Assertions.assertNotNull(createdId);

        MvcResult getResult = mockMvc.perform(MockMvcRequestBuilders.get(APPLICANT_URI + "/" + createdId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(getApplicantDto())))
            .andExpect(status().isOk())
            .andReturn();

        // convert response body to DTO
        ApplicantDto foundApplicantDto = objectMapper.readValue(getResult.getResponse().getContentAsString(), ApplicantDto.class);
        Assertions.assertEquals(applicantDto.getFirstName(), foundApplicantDto.getFirstName());
    }
}
