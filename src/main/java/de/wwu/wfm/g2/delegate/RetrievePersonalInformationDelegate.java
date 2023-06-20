package de.wwu.wfm.g2.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class RetrievePersonalInformationDelegate implements JavaDelegate {
    private static final Logger logger = LoggerFactory.getLogger(RetrievePersonalInformationDelegate.class);

    // include services if needed
    // private final TwitterService twitterService
    // if so, add constructor.

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        var userId = execution.getVariable("possibleCandidateLocal");

        // Query username for userId
        final String candidateName = "User " + userId;
        execution.setVariable("candidate_name_local", candidateName);

        final String message = "This is for userid " + execution.getVariable("possibleCandidateLocal");

        logger.info(message);
    }
}
