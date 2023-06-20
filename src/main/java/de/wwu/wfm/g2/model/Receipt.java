package de.wwu.wfm.g2.model;

public class Receipt {
    private String referenceNumber;
    private String confirmation;
    
    public String getReferenceNumber() {
        return referenceNumber;
    }
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
    public String getConfirmation() {
        return confirmation;
    }
    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public String toString() {
        return "Receipt [referenceNumber=" + referenceNumber + ", confirmation=" + confirmation + "]";
    }
}
