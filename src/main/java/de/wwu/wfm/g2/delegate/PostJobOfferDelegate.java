package de.wwu.wfm.g2.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import de.wwu.wfm.g2.model.JobInformation;

@Component
public class PostJobOfferDelegate implements JavaDelegate {
    private static final Logger logger = LoggerFactory.getLogger(PostJobOfferDelegate.class);

    // include services if needed
    // private final TwitterService twitterService
    // if so, add constructor.
    // current time, job title and platforms returned in 

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        //var list = execution.getVariables();
        
        final JobInformation jobInformation = (JobInformation) execution.getVariable("job_information");

        String title = jobInformation.getRoleTitle();
        
        final String message = "This is ProcessInstanceId " + execution.getProcessInstanceId() + "; Job with title '" + title + "' was posted on www.linkedIn.com, www.xing.com, www.stepstone.de and www.indeed.de.";

        logger.info(message);
    }
}
