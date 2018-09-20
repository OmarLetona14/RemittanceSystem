/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.model;

import java.util.Date;

/**
 *
 * @author Omar
 */
public class Remitter extends SystemUser {
    
    private int idRemitter;
    
    public Remitter(int idRemitter, String name, String birthdate, String nationality, String address, int phoneNumber, String email, double accumulated) {
        super(name, birthdate, nationality, address, phoneNumber, email, accumulated);
        this.idRemitter = idRemitter;
    }
    public Remitter(){}

    public int getIdRemitter() {
        return idRemitter;
    }

    public void setIdRemitter(int idRemitter) {
        this.idRemitter = idRemitter;
    }
}
