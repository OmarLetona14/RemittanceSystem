/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.model;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Omar
 */
public class OperationalUser{
    private int idOperationalUser;
    private String nickname;
    private String password;
    private String role;

    public OperationalUser(int idOperationalUser, String nickname, String password, String role) {
        this.idOperationalUser = idOperationalUser;
        this.nickname = nickname;
        this.password = password;
        this.role = role;
    }

    public OperationalUser() {
         
    }
    public int getIdOperationalUser() {
        return idOperationalUser;
    }

    public void setIdOperationalUser(int idOperationalUser) {
        this.idOperationalUser = idOperationalUser;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }  
}
