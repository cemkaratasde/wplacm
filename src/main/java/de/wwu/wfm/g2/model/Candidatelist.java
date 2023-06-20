package de.wwu.wfm.g2.model;

import java.util.Arrays;

public class Candidatelist {

    private Candidate[] candidates;

    public Candidate[] getCandidates() {
        return candidates;
    }

    public void setCandidates(Candidate[] candidates) {
        this.candidates = candidates;
    }

    @Override
    public String toString() {
        return "Candidatelist [candidates=" + Arrays.toString(candidates) + "]";
    }    

}
