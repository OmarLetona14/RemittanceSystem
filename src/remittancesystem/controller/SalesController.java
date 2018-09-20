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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import remittancesystem.model.SaleTableModel;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class SalesController implements ActionListener {
    
    SaleTableModel model = new SaleTableModel();
    JTable salesTable = new JTable(model);
    JButton newSaleButton = new JButton("Nueva venta");
    JButton backButton = new JButton("Atrás");
    
    @Override
    public void actionPerformed(ActionEvent e) {
        SalesController s = new SalesController(true);
    }
    
    public SalesController(){}
    public SalesController(Boolean b){
        MainModule.mainWindow.setVisible(false);
        JFrame salesWindow = new JFrame();
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new FlowLayout());
        contentpane.setSize(750, 300);
        salesWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        salesWindow.setResizable(false);
        salesWindow.setSize(750, 400);
        salesWindow.setLocationRelativeTo(null);
        salesWindow.setLayout(null);
        salesWindow.setVisible(true);
        salesWindow.setContentPane(contentpane);
        salesTable.setPreferredScrollableViewportSize(new Dimension(750, 300));
        JScrollPane scrollPane = new JScrollPane(salesTable); 
        contentpane.add( scrollPane,BorderLayout.CENTER );
        
        backButton.setSize(150, 25);
        backButton.setLocation(300, 500);
        backButton.addActionListener((ActionEvent e) -> {
            salesWindow.dispose();
            MainModule.mainWindow.setVisible(true);
        });
        newSaleButton.setSize(150, 25);
        newSaleButton.setLocation(100, 500); 
        newSaleButton.addActionListener((ActionEvent e) -> {
            
            JOptionPane.showMessageDialog(salesWindow, "Por favor seleccione un remitario o cree uno nuevo", "Venta",
                    JOptionPane.INFORMATION_MESSAGE);
            salesWindow.setVisible(false);
            RemitterController r = new RemitterController(false);

        });
        salesWindow.add(newSaleButton);
        salesWindow.add(backButton);
    }
    
}
