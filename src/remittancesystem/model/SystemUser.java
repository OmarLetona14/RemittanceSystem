package remittancesystem.model;

import java.util.Date;

/**
 *
 * @author Omar
 */
public class SystemUser {
    
    private String name;
    private String birthdate;
    private String nationality;
    private String address;
    private int phoneNumber;
    private String email;
    private double accumulated;

    public SystemUser(String name, String birthdate, String nationality, String address, int phoneNumber, String email, double accumulated) {
        this.name = name;
        this.birthdate = birthdate;
        this.nationality = nationality;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.accumulated = accumulated;
    }
    public SystemUser(){}
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getAccumulated() {
        return accumulated;
    }

    public void setAccumulated(double accumulated) {
        this.accumulated = accumulated;
    }  
}
