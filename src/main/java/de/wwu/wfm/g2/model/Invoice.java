package de.wwu.wfm.g2.model;

import java.time.LocalDate;

public class Invoice {
    private String referenceNumber;
    private String IBAN;
    private LocalDate dueDate;
    private double totalAmount;
    private String taxID;
    
    public String getReferenceNumber() {
        return referenceNumber;
    }
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }
    public String getIBAN() {
        return IBAN;
    }
    public void setIBAN(String iBAN) {
        IBAN = iBAN;
    }
    public LocalDate getDueDate() {
        return dueDate;
    }
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
    public String getTaxID() {
        return taxID;
    }
    public void setTaxID(String taxID) {
        this.taxID = taxID;
    }
    
    @Override
    public String toString() {
        return "Invoice [referenceNumber=" + referenceNumber + ", IBAN=" + IBAN + ", dueDate=" + dueDate
                + ", totalAmount=" + totalAmount + ", taxID=" + taxID + "]";
    }

    
}
