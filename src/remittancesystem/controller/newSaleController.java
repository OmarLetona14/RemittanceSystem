/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import remittancesystem.model.Beneficiary;
import remittancesystem.model.BeneficiaryTableModel;
import remittancesystem.model.ExchangeRate;
import remittancesystem.model.Remittance;
import remittancesystem.model.RemittanceTableModel;
import remittancesystem.model.Remitter;
import remittancesystem.model.RemitterTableModel;
import remittancesystem.model.Sale;
import remittancesystem.model.SaleTableModel;
import remittancesystem.model.SystemUser;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class newSaleController {
    
    boolean wrongOperation = false;
    Sale sale = null;
    double newAmount = 0.0;
    Remitter remitter = new Remitter();
    public static JFrame newSaleFrame = new JFrame();
    Beneficiary beneficiary = new Beneficiary();
    Remittance remittance = null;
    ExchangeRate exchangeRate = new ExchangeRate();
    JLabel amountLbl = new JLabel("Monto");
    public static JTextField amountTxt = new JTextField();
    MainModule main = new MainModule();
    
    public newSaleController(){      
        MainModule.mainWindow.setVisible(false);
        JButton createSaleButton = new JButton("Aceptar");
        newSaleFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newSaleFrame.setResizable(false);
        newSaleFrame.setSize(400, 300);
        newSaleFrame.setLocationRelativeTo(null);
        newSaleFrame.setLayout(null);
        newSaleFrame.setVisible(true);
        
        amountLbl.setSize(200, 25);
        amountLbl.setLocation(100, 25);
        amountTxt.setSize(200, 25);
        amountTxt.setLocation(100,75 );
        newSaleFrame.add(amountLbl);
        newSaleFrame.add(amountTxt);
        createSaleButton.setSize(100, 25);
        createSaleButton.setLocation(150, 200);
        createSaleButton.addActionListener((ActionEvent e) -> {
            newAmount = Double.valueOf(amountTxt.getText());
            if(newAmount<= LimitController.REMITTER_LIMIT){
                beneficiary = BeneficiaryController.getCurrentBeneficiary();
                remitter = RemitterController.getCurrentRemitter();
                exchangeRate = ExchangeRateController.getCurrentExchangeRate();

                if((remitter.getAccumulated()+newAmount)<= LimitController.REMITTER_LIMIT){
                    try{sale = new Sale(salePointer()+1, remitter.getIdRemitter(), beneficiary.getIdBeneficiary(), exchangeRate,
                    getCurrentDate(), getCurrentTime(),newAmount);}catch(Exception ex){
                    JOptionPane.showMessageDialog(newSaleController.newSaleFrame, "Error al agregar los datos a la remesa", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    newSaleController.newSaleFrame.dispose();
                    ExchangeRateController r = new ExchangeRateController(false);
                    wrongOperation = true;
                    }
                    if(!wrongOperation){
                        try{SaleTableModel.saleList[salePointer()] = sale;}catch(Exception ex){
                            JOptionPane.showMessageDialog(newSaleController.newSaleFrame, "Error al agregar la remesa", "Error",
                            JOptionPane.ERROR_MESSAGE);
                            wrongOperation = true;
                        }
                        if(!wrongOperation){
                            updateAccumulated(remitter);
                            updateAccumulated(beneficiary);
                            remittance = new Remittance(remittancePointer()+1, randomNumber(), sale, "No pagada");
                            RemittanceTableModel.remittanceList[remittancePointer()] = remittance;
                            amountTxt.setText("");
                            JOptionPane.showMessageDialog(newSaleController.newSaleFrame, "Remesa agregada correctamente", "Correcto",
                            JOptionPane.INFORMATION_MESSAGE);
                            newSaleController.newSaleFrame.dispose();                           
                            RemittanceController c = new RemittanceController(false);
                        }
                    }
                }else{
                    JOptionPane.showMessageDialog(newSaleController.newSaleFrame, "El usuario remitente " + remitter.getName() + " alcanzó"
                            + " el límite establecido por el sistema para el envío de remesas", "Error",
                            JOptionPane.ERROR_MESSAGE);
                    wrongOperation = true;
                    amountTxt.setText("");
                    newSaleController.newSaleFrame.dispose();
                    MainModule.mainWindow.setVisible(true);
                }
            }else{
            JOptionPane.showMessageDialog(newSaleFrame, "No se puede enviar un monto mayor al limite establecido ", "Error",
                            JOptionPane.ERROR_MESSAGE);}
            wrongOperation = false;
            amountTxt.setText("");
            newSaleController.newSaleFrame.dispose();
            
        });
        newSaleFrame.add(createSaleButton);     
    }
    public String getCurrentTime(){
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return hourFormat.format(date);
    }
    
    public String getCurrentDate(){
        Date time = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(time);
    }
    
    int salePointer(){
        int count = 0;
        for(Sale s: SaleTableModel.saleList){
            if(!(s==null)){
                count += 1;
            }
        }
        return count;
    }
    int remittancePointer(){
        int count = 0;
        for(Remittance re: RemittanceTableModel.remittanceList){
            if(!(re==null)){
                count += 1;
            }
        }
        return count;        
    }
    
    public int randomNumber(){
        Random r = new Random();
        int valorEntero = r.nextInt(1000)+10;
        return valorEntero;
                
    }
    
    public void updateAccumulated(SystemUser user){
        if(user instanceof Remitter){
            double accumulated = 0.0;
            Remitter n = (Remitter) user;
            accumulated = n.getAccumulated();
            n.setAccumulated(accumulated + newAmount);
            for(Remitter r: RemitterTableModel.remitterList){
                if(!(r==null)){
                    if(r.getIdRemitter()== n.getIdRemitter()){
                      RemitterTableModel.remitterList[n.getIdRemitter()-1] = n;
                    }
                }
            }
        }
    }
}
