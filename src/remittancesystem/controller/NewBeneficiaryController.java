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
import javax.swing.JTextField;
import remittancesystem.model.Beneficiary;
import remittancesystem.model.BeneficiaryTableModel;
import remittancesystem.model.Remitter;
import remittancesystem.model.RemitterTableModel;
import static remittancesystem.model.RemitterTableModel.remitterList;

/**
 *
 * @author Omar
 */
public class NewBeneficiaryController implements ActionListener {
    public static JFrame newBeneficiaryFrame = new JFrame();
    boolean correct = true;
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
    public static Beneficiary newBeneficiary = null;
    @Override
    public void actionPerformed(ActionEvent e) { NewBeneficiaryController c = new NewBeneficiaryController(true);
    } 
    public NewBeneficiaryController(){}
    public NewBeneficiaryController(Boolean b){
        newBeneficiaryFrame.setSize(400, 550);
        newBeneficiaryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newBeneficiaryFrame.setResizable(false);
        newBeneficiaryFrame.setLayout(null);
        newBeneficiaryFrame.setLocationRelativeTo(null);
        newBeneficiaryFrame.setVisible(true);
        
        nameLbl.setLocation(100, 25);
        nameLbl.setSize(200, 25);
        newBeneficiaryFrame.add(nameLbl);   
        nameTxt.setSize(200, 25);
        nameTxt.setLocation(100, 55);
        newBeneficiaryFrame.add(nameTxt);
        
        birthdateLbl.setLocation(100, 100);
        birthdateLbl.setSize(200, 25);
        newBeneficiaryFrame.add(birthdateLbl);
        birthdateTxt.setLocation(100, 130);
        birthdateTxt.setSize(200, 25);
        newBeneficiaryFrame.add(birthdateTxt);
        
        nationalityLbl.setLocation(100, 175);
        nationalityLbl.setSize(200, 25);
        newBeneficiaryFrame.add(nationalityLbl);
        nationalityTxt.setLocation(100, 205);
        nationalityTxt.setSize(200, 25);
        newBeneficiaryFrame.add(nationalityTxt);
        
        addressLbl.setLocation(100, 250);
        addressLbl.setSize(200, 25);
        newBeneficiaryFrame.add(addressLbl);
        addressTxt.setLocation(100, 280);
        addressTxt.setSize(200, 25);
        newBeneficiaryFrame.add(addressTxt);
        
        phoneNumberLbl.setLocation(100, 325);
        phoneNumberLbl.setSize(200, 25);
        newBeneficiaryFrame.add(phoneNumberLbl);
        phoneNumberTxt.setLocation(100, 355);
        phoneNumberTxt.setSize(200,25);
        newBeneficiaryFrame.add(phoneNumberTxt);
        
        emailLbl.setLocation(100, 400);
        emailLbl.setSize(200, 25);
        newBeneficiaryFrame.add(emailLbl);
        emailTxt.setLocation(100, 430);
        emailTxt.setSize(200, 25);
        newBeneficiaryFrame.add(emailTxt);
        
        acceptButton.setSize(100, 25);
        acceptButton.setLocation(150, 475);
        acceptButton.addActionListener((ActionEvent e) -> {
            double acc = 0.0;
            
            try{newBeneficiary = new Beneficiary(pointer() + 1, NewBeneficiaryController.nameTxt.getText()
                    , NewBeneficiaryController.birthdateTxt.getText(), NewBeneficiaryController.nationalityTxt.getText(),
            NewBeneficiaryController.addressTxt.getText(), Integer.valueOf(NewBeneficiaryController.phoneNumberTxt.getText()),
            NewBeneficiaryController.emailTxt.getText(), acc);}catch(Exception ex){
            JOptionPane.showMessageDialog(NewBeneficiaryController.newBeneficiaryFrame, "Ingrese datos correctos", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    correct = false;
                    NewBeneficiaryController.newBeneficiaryFrame.dispose();
            }
            try{BeneficiaryTableModel.beneficiaryList[pointer()] = newBeneficiary;}catch(Exception exc){
            JOptionPane.showMessageDialog(NewBeneficiaryController.newBeneficiaryFrame, "Error al ingresar el beneficiario", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    correct = false;
                    NewBeneficiaryController.newBeneficiaryFrame.dispose();
                    
            }
            if(correct){JOptionPane.showMessageDialog(NewBeneficiaryController.newBeneficiaryFrame, "Beneficiario agregado correctamente", "Nuevo Beneficiario",
                    JOptionPane.INFORMATION_MESSAGE);}
            NewBeneficiaryController.nameTxt.setText("");
            NewBeneficiaryController.birthdateTxt.setText("");
            NewBeneficiaryController.nationalityTxt.setText("");
            NewBeneficiaryController.addressTxt.setText("");
            NewBeneficiaryController.phoneNumberTxt.setText("");
            NewBeneficiaryController.emailTxt.setText("");
            BeneficiaryController.beneficiaryWindow.dispose();
            NewBeneficiaryController.newBeneficiaryFrame.dispose();
            BeneficiaryController bn = new BeneficiaryController(false);
        });
        newBeneficiaryFrame.add(acceptButton);
    
    }
    int pointer(){
        int count = 0;
        for(Beneficiary b: BeneficiaryTableModel.beneficiaryList){
            if(!(b==null)){
                count += 1;
            }
        }return count;
    }
    public static Beneficiary getCurrentBeneficiary(){
        return newBeneficiary;
    }
    
}
