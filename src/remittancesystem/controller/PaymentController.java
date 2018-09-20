/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.controller;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import remittancesystem.model.PaymentTableModel;
import remittancesystem.model.RemittanceTableModel;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class PaymentController implements ActionListener{
    
    PaymentTableModel model = new PaymentTableModel();
    JTable paymentTable = new JTable(model);
    JButton newPaymentButton = new JButton("Nuevo pago");
    JButton backButton = new JButton("Atrás");
    JFrame paymentWindow = new JFrame();
    
    @Override
    public void actionPerformed(ActionEvent e) {
       PaymentController p = new PaymentController(true);
    }
    public PaymentController(){}
    
    public PaymentController(boolean e){
        MainModule.mainWindow.setVisible(false);
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new FlowLayout());
        contentpane.setSize(750, 300);
        paymentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        paymentWindow.setResizable(false);
        paymentWindow.setSize(750, 400);
        paymentWindow.setLocationRelativeTo(null);
        paymentWindow.setLayout(null);
        paymentWindow.setVisible(true);
        paymentWindow.setContentPane(contentpane);
        paymentTable.setPreferredScrollableViewportSize(new Dimension(750, 300));
        JScrollPane scrollPane = new JScrollPane(paymentTable); 
        contentpane.add( scrollPane,BorderLayout.CENTER );
        
        backButton.setSize(150, 25);
        backButton.setLocation(300, 500);
        backButton.addActionListener((ActionEvent ec) -> {
            paymentWindow.dispose();
            MainModule.mainWindow.setVisible(true);
        });
        newPaymentButton.setSize(150, 25);
        newPaymentButton.setLocation(100, 500); 
        newPaymentButton.addActionListener((ActionEvent ec) -> {
            
            JOptionPane.showMessageDialog(paymentWindow, "Por favor seleccione la remesa que desea pagar", "Pago",
                    JOptionPane.INFORMATION_MESSAGE);
            paymentWindow.setVisible(false);
            NewPaymentController r = new NewPaymentController(true);

        });
        paymentWindow.add(newPaymentButton);
        paymentWindow.add(backButton);
    
    
    }
    
}
