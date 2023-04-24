package ivan.di.service;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public class ApplicantReviewingProcessService {

    private final ProcessEngine processEngine;
    private final RuntimeService runtimeService;
    private final Logger logger = LoggerFactory.getLogger(ApplicantReviewingProcessService.class);

    public ApplicantReviewingProcessService() {
        // Create a new instance of the Camunda process engine
        processEngine = ProcessEngineConfiguration.createStandaloneProcessEngineConfiguration()
                .buildProcessEngine();

        // Get the runtime service to start and manage process instances
        runtimeService = processEngine.getRuntimeService();
    }

//    public String startApplicantReviewingProcess(Applicant) {
//        // Define the process instance variables
//        Map<String, Object> variables = new HashMap<>();
//        variables.put("applicantName", applicantName);
//        variables.put("applicantEmail", applicantEmail);
//        variables.put("jobTitle", jobTitle);
//
//        // Start the applicant reviewing process with the defined variables
//        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("applicantReviewingProcess", variables);
//        String processInstanceId = processInstance.getId();
//        logger.info("Started applicant reviewing process with process instance ID: {}", processInstanceId);
//
//        // Return the process instance ID as a string
//        return processInstanceId;
//    }
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

