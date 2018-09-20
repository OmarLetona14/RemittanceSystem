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
public class Remittance {
    
    private int idRemittance;
    private int identifier;
    private Sale sale;
    private String status;

    public Remittance(int idRemittance, int identifier, Sale sale, String status) {
        this.idRemittance = idRemittance;
        this.identifier = identifier;
        this.sale = sale;
        this.status = status;
    }

    public Remittance() {
    }

    public int getIdRemittance() {
        return idRemittance;
    }

    public void setIdRemittance(int idRemittance) {
        this.idRemittance = idRemittance;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

}
