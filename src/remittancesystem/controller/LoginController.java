/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import remittancesystem.model.OperationalUser;
import remittancesystem.model.OperationalUserTableModel;
import remittancesystem.view.Login;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class LoginController implements ActionListener {
    
    public static OperationalUser currentUser = null;
    @Override
    public void actionPerformed(ActionEvent e) {
        if(validateUser()){
            Login.nickname.setText("");
            Login.password.setText("");
            Login.login.dispose();
            MainModule m = new MainModule();
        }else{
            JOptionPane.showMessageDialog(Login.login, "Usuario o contraseña incorrectos", "Error",
                            JOptionPane.ERROR_MESSAGE);
            Login.nickname.setText("");
            Login.password.setText("");
            Login l = new Login();
        }  
    }
    public boolean validateUser(){
        for(OperationalUser ou: OperationalUserTableModel.operationalUserList){
            if(!(ou==null)){
                if(Login.nickname.getText().equals(ou.getNickname())){
                    if(String.valueOf(Login.password.getPassword()).equals(ou.getPassword())){
                        currentUser = ou;
                        return true;
                    }
                }
            }
        }return false;
    }
    
    public static OperationalUser getUser(){
        for(OperationalUser u: OperationalUserTableModel.operationalUserList){
            if(!(u==null)){
                if(currentUser.getIdOperationalUser() == u.getIdOperationalUser()){
                    return u;
                }
            }
        }
        return null;
    }
}
