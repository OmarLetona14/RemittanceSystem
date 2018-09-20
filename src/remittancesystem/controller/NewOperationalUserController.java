/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import javax.swing.JOptionPane;
import remittancesystem.model.OperationalUser;
import remittancesystem.model.OperationalUserTableModel;

/**
 *
 * @author Omar
 */
public class NewOperationalUserController implements ActionListener {
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        OperationalUser newUser = new OperationalUser(pointer(),OperationalUserController.nickTextField.getText(),
                String.valueOf(OperationalUserController.passwordField), String.valueOf(OperationalUserController.role.getSelectedItem()));
        try{OperationalUserTableModel.operationalUserList[pointer()] = newUser;}catch(Exception ex){
            JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, "Error al agregar el nuevo usuario", "Error",
                    JOptionPane.ERROR_MESSAGE);
            
            OperationalUserController.newUserFrame.dispose();
        }
        JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, "Usuario agregado correctamente", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
        OperationalUserController.newUserFrame.dispose();
        OperationalUserController.userWindow.dispose();
        OperationalUserController o = new OperationalUserController(true);
           
    }
    int pointer(){
        int count = 0;
        for(OperationalUser ou: OperationalUserTableModel.operationalUserList){
            if(!(ou==null)){
                count += 1;
            }
        }return count;
    }
}
