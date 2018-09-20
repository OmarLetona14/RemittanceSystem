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
public class Beneficiary extends SystemUser {
    
    private int idBeneficiary;

    public Beneficiary(int idBeneficiary, String name, String birthdate, String nationality, String address, int phoneNumber, String email, double accumulated) {
        super(name, birthdate, nationality, address, phoneNumber, email, accumulated);
        this.idBeneficiary = idBeneficiary;
    }
    public Beneficiary(){}

    public int getIdBeneficiary() {
        return idBeneficiary;
    }

    public void setIdBeneficiary(int idBeneficiary) {
        this.idBeneficiary = idBeneficiary;
    }
    
}
