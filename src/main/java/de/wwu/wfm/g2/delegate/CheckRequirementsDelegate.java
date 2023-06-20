package de.wwu.wfm.g2.delegate;

import de.wwu.wfm.g2.model.JobInformation;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class CheckRequirementsDelegate implements JavaDelegate {
    private static final Logger logger = LoggerFactory.getLogger(CheckRequirementsDelegate.class);

    // include services if needed
    // private final TwitterService twitterService
    // if so, add constructor.
    @Autowired
    private Validator validator;

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        final JobInformation jobInformation = (JobInformation) execution.getVariable("job_information");

        boolean requirementsMet = false;

        Set<ConstraintViolation<JobInformation>> violations = validator.validate(jobInformation);

        List<String> violationStrings = new ArrayList<>();

        if (!violations.isEmpty()) {
            for (var info : violations) {
                String missingInfo = "Variable " + info.getPropertyPath() + " " + info.getMessage();
                violationStrings.add(missingInfo);
                logger.warn(missingInfo);
            }
            execution.setVariable("jobInfoViolations", violationStrings);
            throw new BpmnError("MissingWrongInformation");
        } else {
            requirementsMet = true;
        }


        execution.setVariable("jobInfo", jobInformation.toString());
        execution.setVariable("roleTitle", jobInformation.getRoleTitle());

        // Create salary range
        String salaryRange = jobInformation.getMinSalary() + " - " + jobInformation.getMaxSalary();
        execution.setVariable("salaryRange", salaryRange);

        execution.setVariable("requiredQualifications", jobInformation.getRequiredQualification());


        final String message = "This is ProcessInstanceId " + execution.getProcessInstanceId() + " requirements are met?: " + requirementsMet;

        logger.info(message);
    }
}
