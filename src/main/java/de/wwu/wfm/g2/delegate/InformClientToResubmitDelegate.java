package de.wwu.wfm.g2.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class InformClientToResubmitDelegate implements JavaDelegate {
    private static final Logger logger = LoggerFactory.getLogger(InformClientToResubmitDelegate.class);

    private final RestTemplate restTemplate = new RestTemplate();

    private String baseUrl = "http://wfm-group1.uni-muenster.de/cancel/";

    // TEST //
//    private String baseUrl = "http://localhost:8080/cancel/";

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        final var correlationId = execution.getProcessInstanceId();

        String applicationsReceived = execution.getVariable("applicationsReceived").toString();

        StringBuilder rejectReasons = new StringBuilder();

        if (applicationsReceived == null) {
            // Build reject reason string
            List<String> violations = (List<String>) execution.getVariable("jobInfoViolations");
            for (var str : violations) {
                rejectReasons.append(str).append("\n");
            }
        }
        else if (applicationsReceived.equals("false")) {
            rejectReasons.append("No applications received.");
        }

        rejectReasons.append("The job placement was rejected. Please adapt your job information according to the above " +
                "stated issues and send a new placement.");

        var response = restTemplate.postForEntity(baseUrl + correlationId, rejectReasons.toString(), String.class);
        final String message = "Mail to resubmit with id: " + correlationId + " has been send.";
        logger.info(message);
    }
}
