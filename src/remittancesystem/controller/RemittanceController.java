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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import remittancesystem.model.RemittanceTableModel;
import remittancesystem.model.RemitterTableModel;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class RemittanceController implements ActionListener {
    public static JFrame remittanceWindow = new JFrame();
    static int selected = 0;
    public static boolean notSelected = true;
    RemittanceTableModel model = new RemittanceTableModel();
    JTable remittanceTable = new JTable(model);
    JButton mainModuleButton = new JButton("Menu Principal");
    JButton backButton = new JButton("Atrás");
    @Override
    public void actionPerformed(ActionEvent e) {
      RemittanceController reC = new RemittanceController(true);
    }
    public RemittanceController(){}
    
    public RemittanceController(boolean b){
        MainModule.mainWindow.setVisible(false);
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new FlowLayout());
        contentpane.setSize(750, 300);
        remittanceWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        remittanceWindow.setResizable(false);
        remittanceWindow.setSize(750, 400);
        remittanceWindow.setLocationRelativeTo(null);
        remittanceWindow.setLayout(null);
        remittanceWindow.setVisible(true);
        remittanceWindow.setContentPane(contentpane);
        remittanceTable.setPreferredScrollableViewportSize(new Dimension(750, 300));
        JScrollPane scrollPane = new JScrollPane(remittanceTable); 
        contentpane.add( scrollPane,BorderLayout.CENTER );
       
        mainModuleButton.setSize(150, 25);
        mainModuleButton.setLocation(100, 500);
        mainModuleButton.addActionListener((ActionEvent e) -> {
           remittanceWindow.dispose();
           MainModule.mainWindow.setVisible(true);
        });
        backButton.setSize(150, 25);
        backButton.setLocation(300, 500);
        backButton.addActionListener((ActionEvent e) -> {
           remittanceWindow.dispose();
           MainModule.mainWindow.setVisible(true);
        });
        if(!b){
            remittanceWindow.add(mainModuleButton);

        }else{
            remittanceWindow.add(backButton);
        }
    
    }
    
    
    
}
