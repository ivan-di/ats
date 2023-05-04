package ivan.di;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import ivan.di.dto.ApplicantDto;
import ivan.di.feignclients.ApplicantFeignClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import static com.github.tomakehurst.wiremock.client.WireMock.ok;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;

@SpringBootTest
@ActiveProfiles("test")
@WireMockTest(httpPort = 8090)
class ProcessIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private ApplicantFeignClient applicantClient;

    @Test
    void process_shouldReturnStatusOk() throws Exception {
//        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post(PROCESS_URI)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(objectMapper.writeValueAsString(getApplicantDto())))
//            .andExpect(status().isCreated())
//            .andReturn();
    }

    @Test
    public void whenPostApplicant_statusIsOk() {
        stubFor(WireMock.get("/api/applicant").willReturn(ok()));

        ResponseEntity<ApplicantDto> responseEntity = applicantClient.createApplicant(getApplicantDto());

        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
    }

//    private static void setupMockApplicantResponse(WireMockServer mockService) throws IOException {
//        mockService.stubFor(WireMock.get(WireMock.urlEqualTo("/api/applicant"))
//            .willReturn(WireMock.aResponse()
//                .withStatus(HttpStatus.CREATED.value())
//                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
//                .withBody(
//                    copyToString(
//                        ApplicantMocks.class.getClassLoader().getResourceAsStream("payload/post-applicant-response.json"),
//                        defaultCharset()))));
//    }
}