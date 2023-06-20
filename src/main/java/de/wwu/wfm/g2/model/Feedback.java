package de.wwu.wfm.g2.model;

public class Feedback {

    private boolean positionFilled;
    private int numberofOpenJobs;

    public boolean isPositionFilled() {
        return positionFilled;
    }
    public void setPositionFilled(boolean positionFilled) {
        this.positionFilled = positionFilled;
    }
    public int getNumberofOpenJobs() {
        return numberofOpenJobs;
    }
    public void setNumberofOpenJobs(int numberofOpenJobs) {
        this.numberofOpenJobs = numberofOpenJobs;
    }

    @Override
    public String toString() {
        return "Feedback [positionFilled=" + positionFilled + ", numberofOpenJobs=" + numberofOpenJobs + "]";
    }
    
}
