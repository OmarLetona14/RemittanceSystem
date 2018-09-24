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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import remittancesystem.model.CanceledSale;
import remittancesystem.model.CanceledSaleTableModel;
import remittancesystem.model.Remittance;
import remittancesystem.model.RemittanceTableModel;
import remittancesystem.model.Remitter;
import remittancesystem.model.RemitterTableModel;

/**
 *
 * @author Omar
 */
public class CanceledSaleController implements ActionListener {
    Remittance currentRemittance = null;
    public static JFrame canceledSaleWindow = new JFrame();
    JLabel reasonLbl = new JLabel("Motivo de cancelación");
    public static JTextArea reasonTxt = new JTextArea();
    JButton newCanceledSaleButton = new JButton("Aceptar");

    @Override
    public void actionPerformed(ActionEvent e) {
        CanceledSaleController cs = new CanceledSaleController(true);
    }
    public CanceledSaleController(){}
    
    public CanceledSaleController(boolean b){
        canceledSaleWindow.setSize(400, 300);
        canceledSaleWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        canceledSaleWindow.setResizable(false);
        canceledSaleWindow.setLayout(null);
        canceledSaleWindow.setLocationRelativeTo(null);
        canceledSaleWindow.setVisible(true);

        reasonLbl.setSize(250, 25);
        reasonLbl.setLocation(75, 25);
        canceledSaleWindow.add(reasonLbl);
        
        reasonTxt.setSize(250, 75);
        reasonTxt.setLocation(75, 75);
        canceledSaleWindow.add(reasonTxt);
        
        newCanceledSaleButton.setSize(150, 25);
        newCanceledSaleButton.setLocation(125, 175);
        newCanceledSaleButton.addActionListener((ActionEvent e) -> {
           canceledSaleWindow.dispose();
           currentRemittance = SalesController.getCurrentRemittance();
           CanceledSale canceled = new CanceledSale(pointer() +1 ,currentRemittance, getCurrentDate(), getCurrentTime(), 
                   getCurrentRemitter(), reasonTxt.getText());
           CanceledSaleTableModel.canceledSaleList[pointer()] = canceled;
           JOptionPane.showMessageDialog(canceledSaleWindow, "Cancelación realizada correctamente", "Correcto",
                            JOptionPane.INFORMATION_MESSAGE);
           updateRemittance();
           reasonTxt.setText("");
           
        });
        canceledSaleWindow.add(newCanceledSaleButton);
    }
    
    public Remitter getCurrentRemitter(){
        for(Remitter r: RemitterTableModel.remitterList){
            if(!(r==null)){
                if(r.getIdRemitter() == currentRemittance.getSale().getIdRemitter()){
                    return r;
                }
            }
        }
        return null;
    }
    
    int pointer(){
        int count = 0;
        for(CanceledSale cs: CanceledSaleTableModel.canceledSaleList){
            if(!(cs == null)){
                count += 1;
            }
        }
        return count;
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
    
    public void updateRemittance(){
        for(Remittance r: RemittanceTableModel.remittanceList){
            if(!(r==null)){
                if(r.equals(currentRemittance)){
                    r = null;
                }
            }
        }
    }
    
}
