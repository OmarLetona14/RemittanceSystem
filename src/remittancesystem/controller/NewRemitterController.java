/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import remittancesystem.model.Remitter;
import remittancesystem.model.RemitterTableModel;
import static remittancesystem.model.RemitterTableModel.remitterList;

/**
 *
 * @author Omar
 */
public class NewRemitterController implements ActionListener {
    
    boolean correct = true;
    public static JFrame newRemitterWindow = new JFrame();
    JButton acceptButton = new JButton("Aceptar");
    public static JTextField nameTxt = new JTextField();
    JLabel nameLbl = new JLabel("Nombres y apellidos");
    public static JTextField birthdateTxt = new JTextField();
    JLabel birthdateLbl = new JLabel("Fecha de nacimiento(DD/MM/AAAA)");
    public static JTextField nationalityTxt = new JTextField();
    JLabel nationalityLbl = new JLabel("Nacionalidad");
    public static JTextField addressTxt = new JTextField();
    JLabel addressLbl = new JLabel("Dirección");
    public static JTextField phoneNumberTxt = new JTextField();
    JLabel phoneNumberLbl = new JLabel("Numero de telefono");
    public static JTextField emailTxt = new JTextField();
    JLabel emailLbl = new JLabel("Correo electronico");
    
    @Override
    public void actionPerformed(ActionEvent e) {
        NewRemitterController nR = new NewRemitterController(true);
    }
    public NewRemitterController(){}
    public NewRemitterController(Boolean b){
        newRemitterWindow.setSize(400, 550);
        newRemitterWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newRemitterWindow.setResizable(false);
        newRemitterWindow.setLayout(null);
        newRemitterWindow.setLocationRelativeTo(null);
        newRemitterWindow.setVisible(true);
        
        nameLbl.setLocation(100, 25);
        nameLbl.setSize(200, 25);
        newRemitterWindow.add(nameLbl);   
        nameTxt.setSize(200, 25);
        nameTxt.setLocation(100, 55);
        newRemitterWindow.add(nameTxt);
        
        birthdateLbl.setLocation(100, 100);
        birthdateLbl.setSize(200, 25);
        newRemitterWindow.add(birthdateLbl);
        birthdateTxt.setLocation(100, 130);
        birthdateTxt.setSize(200, 25);
        newRemitterWindow.add(birthdateTxt);
        
        nationalityLbl.setLocation(100, 175);
        nationalityLbl.setSize(200, 25);
        newRemitterWindow.add(nationalityLbl);
        nationalityTxt.setLocation(100, 205);
        nationalityTxt.setSize(200, 25);
        newRemitterWindow.add(nationalityTxt);
        
        addressLbl.setLocation(100, 250);
        addressLbl.setSize(200, 25);
        newRemitterWindow.add(addressLbl);
        addressTxt.setLocation(100, 280);
        addressTxt.setSize(200, 25);
        newRemitterWindow.add(addressTxt);
        
        phoneNumberLbl.setLocation(100, 325);
        phoneNumberLbl.setSize(200, 25);
        newRemitterWindow.add(phoneNumberLbl);
        phoneNumberTxt.setLocation(100, 355);
        phoneNumberTxt.setSize(200,25);
        newRemitterWindow.add(phoneNumberTxt);
        
        emailLbl.setLocation(100, 400);
        emailLbl.setSize(200, 25);
        newRemitterWindow.add(emailLbl);
        emailTxt.setLocation(100, 430);
        emailTxt.setSize(200, 25);
        newRemitterWindow.add(emailTxt);
        
        acceptButton.setSize(100, 25);
        acceptButton.setLocation(150, 475);
        acceptButton.addActionListener((ActionEvent e) -> {
            double acc = 0.0;
            Remitter newRemitter = null;
            try{newRemitter = new Remitter(pointer() + 1, NewRemitterController.nameTxt.getText()
                    , NewRemitterController.birthdateTxt.getText(), NewRemitterController.nationalityTxt.getText(),
            NewRemitterController.addressTxt.getText(), Integer.valueOf(NewRemitterController.phoneNumberTxt.getText()),
            NewRemitterController.emailTxt.getText(), acc);}catch(Exception ex){
            JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, "Ingrese datos correctos", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    correct = false;
                    NewRemitterController.newRemitterWindow.dispose();
            }
            try{RemitterTableModel.remitterList[pointer()] = newRemitter;}catch(Exception exc){
            JOptionPane.showMessageDialog(NewRemitterController.newRemitterWindow, "Error al ingresar el remitente", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    correct = false;
                    NewRemitterController.newRemitterWindow.dispose();
                    
            }
            if(correct){JOptionPane.showMessageDialog(NewRemitterController.newRemitterWindow, "Remitente agregado correctamente", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            RemitterController.notSelected = false;
            }
            NewRemitterController.nameTxt.setText("");
            NewRemitterController.birthdateTxt.setText("");
            NewRemitterController.nationalityTxt.setText("");
            NewRemitterController.addressTxt.setText("");
            NewRemitterController.phoneNumberTxt.setText("");
            NewRemitterController.emailTxt.setText("");
            NewRemitterController.newRemitterWindow.dispose();
            RemitterController.remitterWindow.dispose();
            RemitterController r = new RemitterController(false);
        });
        newRemitterWindow.add(acceptButton);
    }
    int pointer(){
        int count = 0;
        for(Remitter r: RemitterTableModel.remitterList){
            if(!(r==null)){
                count += 1;
            }
        }return count;
    }
}
