package de.wwu.wfm.g2.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UpdateCandidateSelectionDelegate implements JavaDelegate {
    private static final Logger logger = LoggerFactory.getLogger(UpdateCandidateSelectionDelegate.class);

    // include services if needed
    // private final TwitterService twitterService
    // if so, add constructor.

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        var list = execution.getVariables();

        final String message = "This is ProcessInstanceId " + execution.getProcessInstanceId();

        logger.info(message);
    }
}
