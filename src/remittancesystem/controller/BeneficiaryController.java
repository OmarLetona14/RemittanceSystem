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
import static remittancesystem.controller.RemitterController.remitterWindow;
import remittancesystem.model.Beneficiary;
import remittancesystem.model.BeneficiaryTableModel;
import remittancesystem.model.RemitterTableModel;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class BeneficiaryController implements ActionListener{
    public static JFrame beneficiaryWindow = new JFrame();
    static int selected = 0;
    boolean notSelected = true;
    BeneficiaryTableModel model = new BeneficiaryTableModel();
    JTable beneficiaryTable = new JTable(model);
    JButton newBeneficiaryButton = new JButton("Nuevo beneficiario");
    JButton selectButton = new JButton("Seleccionar");
    JButton backButton = new JButton("Atrás");
    NewBeneficiaryController newBeneficiaryController = new NewBeneficiaryController();

    @Override
    public void actionPerformed(ActionEvent e) {
        BeneficiaryController b = new BeneficiaryController(true);
    }
    public BeneficiaryController(){}
    public BeneficiaryController(boolean b){
    MainModule.mainWindow.setVisible(false);
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new FlowLayout());
        contentpane.setSize(750, 300);
        beneficiaryWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        beneficiaryWindow.setResizable(false);
        beneficiaryWindow.setSize(750, 400);
        beneficiaryWindow.setLocationRelativeTo(null);
        beneficiaryWindow.setLayout(null);
        beneficiaryWindow.setVisible(true);
        beneficiaryWindow.setContentPane(contentpane);
        beneficiaryTable.setPreferredScrollableViewportSize(new Dimension(750, 300));
        JScrollPane scrollPane = new JScrollPane(beneficiaryTable); 
        contentpane.add( scrollPane,BorderLayout.CENTER );
        
        beneficiaryTable.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
           notSelected = false;
           int fila = beneficiaryTable.rowAtPoint(e.getPoint());
           selected = fila;
            }
         });
        backButton.setSize(150, 25);
        backButton.setLocation(300, 500);
        backButton.addActionListener((ActionEvent e) -> {
            beneficiaryWindow.dispose();
            MainModule.mainWindow.setVisible(true);
        });
         
        newBeneficiaryButton.setSize(150, 25);
        newBeneficiaryButton.setLocation(100, 500);
        selectButton.setSize(150, 25);
        selectButton.setLocation(300, 500);
        selectButton.addActionListener((ActionEvent e) -> {
            if(!notSelected){
                BeneficiaryController.beneficiaryWindow.dispose();
                JOptionPane.showMessageDialog(beneficiaryWindow, "Por favor seleccione un pais de destino o cree uno nuevo", "Venta",
                    JOptionPane.INFORMATION_MESSAGE);
                ExchangeRateController ex = new ExchangeRateController(false);
            }else{
                JOptionPane.showMessageDialog(beneficiaryWindow, "Por favor seleccione un beneficiario", "Venta",
                    JOptionPane.INFORMATION_MESSAGE);
            }
        });
        newBeneficiaryButton.addActionListener(newBeneficiaryController);
        if(!b){
            beneficiaryWindow.add(newBeneficiaryButton);
            beneficiaryWindow.add(selectButton);
        }else{
             beneficiaryWindow.add(backButton);
        }       
    }
    public static Beneficiary getCurrentBeneficiary(){
        for(Beneficiary b: BeneficiaryTableModel.beneficiaryList){
            if((b.getIdBeneficiary()-1)==selected){
                return b;
            }
        }
        return null;
    }    
}
