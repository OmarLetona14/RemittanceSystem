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
public class CanceledSale {
    
    private int idCanceledSale;
    private Remittance remittance;
    private String currentDate;
    private String currentTime;
    private Remitter remitter;
    private String reason;

    public CanceledSale(int idCanceledSale, Remittance remittance, String currentDate, String currentTime, Remitter remitter, String reason) {
        this.idCanceledSale = idCanceledSale;
        this.remittance = remittance;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.remitter = remitter;
        this.reason = reason;
    }

    public CanceledSale() {
    }

    public int getIdCanceledSale() {
        return idCanceledSale;
    }

    public void setIdCanceledSale(int idCanceledSale) {
        this.idCanceledSale = idCanceledSale;
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

    public Remitter getRemitter() {
        return remitter;
    }

    public void setRemitter(Remitter remitter) {
        this.remitter = remitter;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    
}
