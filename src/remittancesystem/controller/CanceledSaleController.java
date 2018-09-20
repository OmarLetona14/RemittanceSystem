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
import javax.swing.JTextArea;

/**
 *
 * @author Omar
 */
public class CanceledSaleController implements ActionListener {
    
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
        canceledSaleWindow.add(newCanceledSaleButton);
        
        
    }
    
}
