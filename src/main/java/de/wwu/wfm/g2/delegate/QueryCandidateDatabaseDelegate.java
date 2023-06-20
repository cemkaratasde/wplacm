package de.wwu.wfm.g2.delegate;

import de.wwu.wfm.g2.model.Candidate;
import de.wwu.wfm.g2.model.Candidatelist;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.spin.Spin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import spinjar.com.minidev.json.JSONArray;
import spinjar.com.minidev.json.JSONObject;

@Component
public class QueryCandidateDatabaseDelegate implements JavaDelegate {
    private static final Logger logger = LoggerFactory.getLogger(QueryCandidateDatabaseDelegate.class);

    // include services if needed
    // private final TwitterService twitterService
    // if so, add constructor.

    @Override
    public void execute(DelegateExecution execution) throws Exception {

        Candidate cand01 = new Candidate();
        cand01.setId(1);
        cand01.setName("Candidate Number1");
        cand01.setEmail("number1@candidate.com");

        Candidate cand02 = new Candidate();
        cand02.setId(2);
        cand02.setName("Candidate Number2");
        cand02.setEmail("number2@candidate.com");

        Candidatelist candList = new Candidatelist();
        candList.setCandidates(new Candidate[]{cand01, cand02});

        // Insert candidates to possible Candidate Form
        JSONArray possibleCandidates = new JSONArray();

        // Build candidate list for form
        for (var cand : candList.getCandidates()) {
            JSONObject tmp = new JSONObject();
            String label = "(" + cand.getId() + ") - " + cand.getName();

            tmp.put("label", label);
            tmp.put("value", cand.getId());

            possibleCandidates.add(tmp);
        }

        var possibleCandidateList = Spin.JSON(possibleCandidates);

        execution.setVariable("possible_candidate_list", possibleCandidateList);

        final String message = "This is ProcessInstanceId " + execution.getProcessInstanceId() +
                "Possible candidates: " + possibleCandidateList;

        logger.info(message);
    }
}
