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
public class Payment {
    
    private int idPayment;
    private String currentDate;
    private String currentTime;
    private int idBeneficiary;
    private double exchange;
    private double amount;

    public Payment(int idPayment, String currentDate, String currentTime, int idBeneficiary, double exchange, double amount) {
        this.idPayment = idPayment;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.idBeneficiary = idBeneficiary;
        this.exchange = exchange;
        this.amount = amount;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
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

    public int getIdBeneficiary() {
        return idBeneficiary;
    }

    public void setIdBeneficiary(int idBeneficiary) {
        this.idBeneficiary = idBeneficiary;
    }

    public double getExchange() {
        return exchange;
    }

    public void setExchange(double exchange) {
        this.exchange = exchange;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
