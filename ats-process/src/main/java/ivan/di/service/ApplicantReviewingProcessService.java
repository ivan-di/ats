package ivan.di.service;

import ivan.di.dto.ApplicantDto;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
@Slf4j
public class ApplicantReviewingProcessService {

    private final RuntimeService runtimeService;

    private final ApplicantService applicantService;

    public ApplicantReviewingProcessService(ApplicantService applicantService) {
        this.applicantService = applicantService;

        // Create a new instance of the Camunda process engine
        ProcessEngine processEngine = SpringProcessEngineConfiguration
            .createStandaloneProcessEngineConfiguration()
            .setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_TRUE)
            .setJdbcUrl("jdbc:h2:mem:camunda-h2-database;DB_CLOSE_DELAY=1000")
            .setJobExecutorActivate(true)
            .buildProcessEngine();

        // Get the runtime service to start and manage process instances
        runtimeService = processEngine.getRuntimeService();
    }

    public String startApplicantReviewingProcess(ApplicantDto applicantDto) {
        String uuid = UUID.randomUUID().toString();
        applicantDto.setUuid(uuid);

        applicantService.saveApplicant(applicantDto);

        // Define the process instance variables
        Map<String, Object> variables = new HashMap<>();
        variables.put("applicantId", uuid);

        // Start the applicant reviewing process with the defined variables
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("applicant-tracking", variables);
        String processInstanceId = processInstance.getId();
        log.info("Started applicant reviewing process for applicant with UUID: {}, and process instance ID: {}", uuid, processInstanceId);

        // Return the process instance ID as a string
        return processInstanceId;
    }
//
//    public void evaluateApplicant(String processInstanceId, boolean isQualified) {
//        // Define the process instance variables
//        Map<String, Object> variables = new HashMap<>();
//        variables.put("isQualified", isQualified);
//
//        // Signal the "evaluateApplicant" task in the applicant reviewing process with the defined variables
//        runtimeService.createSignalEvent("evaluateApplicant")
//                .processInstanceId(processInstanceId)
//                .setVariables(variables)
//                .send();
//        logger.info("Signaled evaluateApplicant task for process instance ID: {}", processInstanceId);
//    }
//
//    // Other methods for interacting with the Camunda engine could be added here
//
//    public void close() {
//        // Shutdown the Camunda process engine when no longer needed
//        processEngine.close();
//        logger.info("Closed the Camunda process engine.");
//    }
}

