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
import remittancesystem.model.ExchangeRate;
import remittancesystem.model.ExchangeRateTableModel;

/**
 *
 * @author Omar
 */
public class NewExchangeRateController implements ActionListener {
    
    boolean wrongOperation = false;
    double ex = 0.0;
    ExchangeRate exRate = null;
    JButton acceptButton = new JButton("Aceptar");
    public static JFrame newExchangeRateWindow = new JFrame();
    JLabel countryNameLbl = new JLabel("Nombre del país");
    public static JTextField countryNameTxt = new JTextField();
    JLabel countryCurrencyLbl = new JLabel("Moneda");
    public static JTextField countryCurrencyTxt = new JTextField();
    JLabel exchangeRateLbl = new JLabel("Tipo de cambio");
    public static JTextField exchangeRateTxt = new JTextField();
    
    @Override
    public void actionPerformed(ActionEvent e) {
        NewExchangeRateController ex = new NewExchangeRateController(true);
    }
    public NewExchangeRateController(){}
    public NewExchangeRateController(boolean b){
        newExchangeRateWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newExchangeRateWindow.setResizable(false);
        newExchangeRateWindow.setSize(400, 400);
        newExchangeRateWindow.setLayout(null);
        newExchangeRateWindow.setLocationRelativeTo(null);
        newExchangeRateWindow.setVisible(true);
        
        countryNameLbl.setLocation(100, 25);
        countryNameLbl.setSize(200, 25);
        newExchangeRateWindow.add(countryNameLbl);   
        countryNameTxt.setSize(200, 25);
        countryNameTxt.setLocation(100, 55);
        newExchangeRateWindow.add(countryNameTxt);
        
        countryCurrencyLbl.setLocation(100, 100);
        countryCurrencyLbl.setSize(200, 25);
        newExchangeRateWindow.add(countryCurrencyLbl);
        countryCurrencyTxt.setLocation(100, 130);
        countryCurrencyTxt.setSize(200, 25);
        newExchangeRateWindow.add(countryCurrencyTxt);
        
        exchangeRateLbl.setLocation(100, 175);
        exchangeRateLbl.setSize(200, 25);
        newExchangeRateWindow.add(exchangeRateLbl);
        exchangeRateTxt.setLocation(100, 205);
        exchangeRateTxt.setSize(200, 25);
        newExchangeRateWindow.add(exchangeRateTxt);
        
        acceptButton.setLocation(150, 250);
        acceptButton.setSize(100, 25);
        acceptButton.addActionListener((ActionEvent e) -> {
            try{ex = Double.valueOf(exchangeRateTxt.getText());}catch(Exception exc){
            JOptionPane.showMessageDialog(newExchangeRateWindow, "No introdujo un tipo de cambio valido", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            wrongOperation = true;
            NewExchangeRateController ex1 = new NewExchangeRateController(true);}
            if(!wrongOperation){
                double gain = calculateGain(ex);
                try{exRate = new ExchangeRate(pointer() + 1, countryNameTxt.getText(), countryCurrencyTxt.getText(),
                ex, gain);}catch(Exception ex){
                JOptionPane.showMessageDialog(newExchangeRateWindow, "Hubo un error al agregar el pais", "Error",
                    JOptionPane.ERROR_MESSAGE);
                NewExchangeRateController ex1 = new NewExchangeRateController(true);
                wrongOperation = true;}
                if(!wrongOperation){
                    try{ExchangeRateTableModel.exchangeRateList[pointer()]=exRate;}catch(Exception ex){
                    JOptionPane.showMessageDialog(newExchangeRateWindow, "Hubo un error al agregar el pais", "Error",
                    JOptionPane.ERROR_MESSAGE);
                    wrongOperation = true;
                    NewExchangeRateController ex1 = new NewExchangeRateController(true);}
                    if(!wrongOperation){
                          JOptionPane.showMessageDialog(newExchangeRateWindow, "Pais agregado correctamente", "Agregado",
                    JOptionPane.INFORMATION_MESSAGE);  
                          newExchangeRateWindow.dispose();
                          ExchangeRateController.exchangeRateWindow.dispose();
                          ExchangeRateController ex1 = new ExchangeRateController(false);
                    }
                }
            }
        });       
        newExchangeRateWindow.add(acceptButton);
    }
    
    public int pointer(){
        int count = 0;
        for(ExchangeRate eR: ExchangeRateTableModel.exchangeRateList){
            if(!(eR == null)){
                count += 1;
            }
        }
        return count;    
    }
    
    public double calculateGain(double exchange){
        double gain = (0.1*exchange);
        return gain;
    }
    
}
