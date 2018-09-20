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
import remittancesystem.model.ExchangeRate;
import remittancesystem.model.ExchangeRateTableModel;
import remittancesystem.model.RemitterTableModel;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class ExchangeRateController implements ActionListener {
    public static JFrame exchangeRateWindow = new JFrame();
    static int selected = 0;
    public static boolean notSelected = true;
    ExchangeRateTableModel model = new ExchangeRateTableModel();
    JTable exchangeRateTable = new JTable(model);
    JButton newExchangeRateButton = new JButton("Nuevo pais");
    JButton selectButton = new JButton("Seleccionar");
    JButton backButton = new JButton("Atrás");
    NewExchangeRateController newExchangeRateController = new NewExchangeRateController();
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    public ExchangeRateController(){}
     public ExchangeRateController(boolean b){
        MainModule.mainWindow.setVisible(false);
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new FlowLayout());
        contentpane.setSize(750, 300);
        exchangeRateWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exchangeRateWindow.setResizable(false);
        exchangeRateWindow.setSize(750, 400);
        exchangeRateWindow.setLocationRelativeTo(null);
        exchangeRateWindow.setLayout(null);
        exchangeRateWindow.setVisible(true);
        exchangeRateWindow.setContentPane(contentpane);
        exchangeRateTable.setPreferredScrollableViewportSize(new Dimension(750, 300));
        JScrollPane scrollPane = new JScrollPane(exchangeRateTable); 
        contentpane.add( scrollPane,BorderLayout.CENTER );
        
        exchangeRateTable.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
           notSelected = false;
           int fila = exchangeRateTable.rowAtPoint(e.getPoint());
           selected = fila;
            }
         });
         
        newExchangeRateButton.setSize(150, 25);
        newExchangeRateButton.setLocation(100, 500);
        selectButton.setSize(150, 25);
        selectButton.setLocation(300, 500);
        selectButton.addActionListener((ActionEvent e) -> {
            if(!notSelected){
            JOptionPane.showMessageDialog(exchangeRateWindow, "Por favor ingrese el monto de la remesa", "Venta",
                    JOptionPane.INFORMATION_MESSAGE);  
            exchangeRateWindow.dispose();
            newSaleController sale = new newSaleController();
            }else{
                JOptionPane.showMessageDialog(exchangeRateWindow, "Por favor seleccione un pais", "Venta",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });

        newExchangeRateButton.addActionListener(newExchangeRateController);
        if(!b){
            exchangeRateWindow.add(newExchangeRateButton);
            exchangeRateWindow.add(selectButton);
        }
     
     }
     public static ExchangeRate getCurrentExchangeRate(){
        for(ExchangeRate eR: ExchangeRateTableModel.exchangeRateList){
            if((eR.getIdCountry()-1)==selected){
                return eR;
            }
        }
        return null;
    }
    
}
