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
public class Sale {
    
    private int idSale;
    private int idRemitter;
    private int idBeneficiario;
    private ExchangeRate destinationCountry;
    private String currentDate;
    private String currentTime;
    private double amount;

    public Sale(int idSale, int idRemitter, int idBeneficiario, ExchangeRate destinationCountry, String currentDate, String currentTime, double amount) {
        this.idSale = idSale;
        this.idRemitter = idRemitter;
        this.idBeneficiario = idBeneficiario;
        this.destinationCountry = destinationCountry;
        this.currentDate = currentDate;
        this.currentTime = currentTime;
        this.amount = amount;
    }

    public int getIdSale() {
        return idSale;
    }

    public void setIdSale(int idSale) {
        this.idSale = idSale;
    }

    public int getIdRemitter() {
        return idRemitter;
    }

    public void setIdRemitter(int idRemitter) {
        this.idRemitter = idRemitter;
    }

    public int getIdBeneficiario() {
        return idBeneficiario;
    }

    public void setIdBeneficiario(int idBeneficiario) {
        this.idBeneficiario = idBeneficiario;
    }

    public ExchangeRate getDestinationCountry() {
        return destinationCountry;
    }

    public void setDestinationCountry(ExchangeRate destinationCountry) {
        this.destinationCountry = destinationCountry;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
