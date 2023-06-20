package de.wwu.wfm.g2.controller;


import de.wwu.wfm.g2.model.JobInformation;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.runtime.ProcessInstance;
import org.camunda.bpm.engine.variable.VariableMap;
import org.camunda.bpm.engine.variable.Variables;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GlobalController {
    private static final Logger logger = LoggerFactory.getLogger(GlobalController.class);

    private static final String MESSAGE_NAME = "job_placement";

    private final RuntimeService runtimeService;

    public GlobalController(final RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping("/jobs")
    public String startJobProcess(@RequestBody final JobInformation job) {

//        Field[] fields = job.getClass().getDeclaredFields();
//        VariableMap vars = Variables.createVariables();
//
//        for(var f : fields) {
//            f.setAccessible(true);
//            try {
//                vars.putValue(f.getName(), f.get(job));
//            } catch (IllegalAccessException e) {
//                vars.putValue(f.getName(), null);
//            }
//        }
        VariableMap vars = Variables.createVariables()
                                    .putValue("job_information", job);


        final ProcessInstance instance = runtimeService.startProcessInstanceByMessage(MESSAGE_NAME, vars);

        final String processInstanceId = instance.getId(); //

        logger.info("Recived job '{}' with id{}.", job.getRoleTitle(), processInstanceId);

        return processInstanceId;
    }

    // For local development
     @PostMapping("/cancel/{correlationId}")
     public String improvementReceived(@PathVariable final String correlationId,
                                       @RequestBody final String rejectReasons) {

         logger.info("Cancel for correlationId: {} with message: {}", correlationId, rejectReasons);

         return "ok";
     }


    // @PostMapping("/improvement/{correlationId}")
    // public String improvementReceived(@PathVariable final String correlationId,
    //                                   @RequestBody final TweetMessage tweetMessage) {

    //     logger.info("Improvement received for correlationId: {}", correlationId);

    //     runtimeService.createMessageCorrelation("improvement_received_message")
    //             .processInstanceVariableEquals("correlation_id", correlationId)
    //             .setVariable("text", tweetMessage.getText())
    //             .correlate();

    //     return "ok";
    // }
}
