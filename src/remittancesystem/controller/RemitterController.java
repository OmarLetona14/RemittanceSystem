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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import remittancesystem.model.Remitter;
import remittancesystem.model.RemitterTableModel;
import remittancesystem.model.SaleTableModel;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class RemitterController implements ActionListener {
    public static JFrame remitterWindow = new JFrame();
    static int selected = 0;
    public static boolean notSelected = true;
    RemitterTableModel model = new RemitterTableModel();
    JTable remitterTable = new JTable(model);
    JButton newRemitterButton = new JButton("Nuevo remitente");
    JButton selectButton = new JButton("Seleccionar");
    JButton backButton = new JButton("Atrás");
    NewRemitterController newRemitterController = new NewRemitterController();
    @Override
    public void actionPerformed(ActionEvent e) {
        RemitterController r = new RemitterController(true);
    }
    public RemitterController(){}
    
    public RemitterController(boolean b){
    MainModule.mainWindow.setVisible(false);
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new FlowLayout());
        contentpane.setSize(750, 300);
        remitterWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        remitterWindow.setResizable(false);
        remitterWindow.setSize(750, 400);
        remitterWindow.setLocationRelativeTo(null);
        remitterWindow.setLayout(null);
        remitterWindow.setVisible(true);
        remitterWindow.setContentPane(contentpane);
        remitterTable.setPreferredScrollableViewportSize(new Dimension(750, 300));
        JScrollPane scrollPane = new JScrollPane(remitterTable); 
        contentpane.add( scrollPane,BorderLayout.CENTER );
        
        remitterTable.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
           notSelected = false;
           int fila = remitterTable.rowAtPoint(e.getPoint());
           selected = fila;
            }
         });
         
        backButton.setSize(150, 25);
        backButton.setLocation(300, 500);
        backButton.addActionListener((ActionEvent e) -> {
            remitterWindow.dispose();
            MainModule.mainWindow.setVisible(true);
        });
        newRemitterButton.setSize(150, 25);
        newRemitterButton.setLocation(100, 500);
        
        selectButton.setSize(150, 25);
        selectButton.setLocation(300, 500);
        selectButton.addActionListener((ActionEvent e) -> {
            if(!notSelected){
                JOptionPane.showMessageDialog(remitterWindow, "Por favor seleccione un beneficiario o cree uno nuevo", "Venta",
                    JOptionPane.INFORMATION_MESSAGE);
            remitterWindow.dispose();
            BeneficiaryController ben = new BeneficiaryController(false);
            }else{
                JOptionPane.showMessageDialog(remitterWindow, "Por favor seleccione un remitario", "Venta",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        newRemitterButton.addActionListener(newRemitterController);
        if(!b){
            remitterWindow.add(newRemitterButton);
            remitterWindow.add(selectButton);
        }else{
            remitterWindow.add(backButton);
        }
    }
    public static Remitter getCurrentRemitter(){
        for(Remitter r: RemitterTableModel.remitterList){
            if((r.getIdRemitter()-1)==selected){
                return r;
            }
        }
        return null;
    }
    
}
