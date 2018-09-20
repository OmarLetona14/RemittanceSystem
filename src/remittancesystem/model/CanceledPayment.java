/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.model;

/**
 *
 * @author Omar
 */
public class CanceledPayment {
    
    private int idCanceledPayment;
    private Remittance remittance;
    private String currentDate;
    private String currentTime;
    private Beneficiary beneficiary;
    private String reason;

    public CanceledPayment(int idCanceledPayment, Remittance remittance, String currentDate, String currentTime, Beneficiary beneficiary, String reason) {
        this.idCanceledPayment = idCanceledPayment;
        this.remittance = remittance;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.beneficiary = beneficiary;
        this.reason = reason;
    }

    public CanceledPayment() {
    }

    public int getIdCanceledPayment() {
        return idCanceledPayment;
    }

    public void setIdCanceledPayment(int idCanceledPayment) {
        this.idCanceledPayment = idCanceledPayment;
    }

    public Remittance getRemittance() {
        return remittance;
    }

    public void setRemittance(Remittance remittance) {
        this.remittance = remittance;
    }

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public Beneficiary getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(Beneficiary beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
    
    
    

   

    
}
