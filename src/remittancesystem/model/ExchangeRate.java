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
public class ExchangeRate {
    
    private int idCountry;
    private String countryName;
    private String countryCurrency;
    private double exchangeRate;
    private double gain;

    public ExchangeRate(int idCountry, String countryName, String countryCurrency, double exchangeRate, double gain) {
        this.idCountry = idCountry;
        this.countryName = countryName;
        this.countryCurrency = countryCurrency;
        this.exchangeRate = exchangeRate;
        this.gain = gain;
    }
    public ExchangeRate(){}

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCurrency() {
        return countryCurrency;
    }

    public void setCountryCurrency(String countryCurrency) {
        this.countryCurrency = countryCurrency;
    }

    public double getExchangeRate() {
        return exchangeRate;
    }

    public void setExchangeRate(double exchangeRate) {
        this.exchangeRate = exchangeRate;
    }

    public double getGain() {
        return gain;
    }

    public void setGain(double gain) {
        this.gain = gain;
    } 
}
