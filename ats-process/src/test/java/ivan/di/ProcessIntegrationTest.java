package ivan.di;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit5.WireMockTest;
import ivan.di.dto.ApplicantDto;
import ivan.di.feignclients.ApplicantFeignClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;

@SpringBootTest
@ActiveProfiles("test")
@WireMockTest(httpPort = 8090)
@EnableConfigurationProperties
//@ExtendWith({SpringExtension.class, ProcessEngineExtension.class}) FAILS
class ProcessIntegrationTest extends AbstractIntegrationTest {

    @Autowired
    private ApplicantFeignClient applicantClient;

    @Test
    void contextLoads() {}

    @Test
    public void whenPostApplicant_statusIsOk() throws IOException {
        stubFor(WireMock.post("/api/applicant").willReturn(WireMock.aResponse()
            .withStatus(HttpStatus.CREATED.value())
            .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .withBody(
                copyToString(
                    ProcessIntegrationTest.class.getClassLoader().getResourceAsStream("payload/post-applicant-response.json"),
                    defaultCharset()))));

        ResponseEntity<ApplicantDto> responseEntity = applicantClient.createApplicant(getApplicantDto());

        Assertions.assertTrue(responseEntity.getStatusCode().is2xxSuccessful());
    }
}