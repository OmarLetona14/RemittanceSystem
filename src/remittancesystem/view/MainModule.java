/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import remittancesystem.controller.BeneficiaryController;
import remittancesystem.controller.LoginController;
import remittancesystem.controller.OperationalUserController;
import remittancesystem.controller.PaymentController;
import remittancesystem.controller.RemittanceController;
import remittancesystem.controller.RemitterController;
import remittancesystem.controller.SalesController;

/**
 *
 * @author Omar
 */
public class MainModule {
    
    public static JFrame mainWindow = null; 
    JLabel titleLabel = new JLabel();
    JButton OperationalUserButton = new JButton("Usuarios de Operaciones");
    JButton salesButton = new JButton("Ventas");
    JButton paymentButton = new JButton("Pagos");
    JButton remitterButton = new JButton("Remitentes");
    JButton beneficiaryButton = new JButton("Beneficiarios");
    JButton remittanceStatusButton = new JButton("Estado de Remesas");
    JButton configurationButton = new JButton("Configuraciones");
    JButton accountingButton = new JButton("Contabilidad");
    JButton closeSesionButton = new JButton("Cerrar sesión");
    
    public MainModule(){
        mainWindow = new JFrame();
        OperationalUserController operationalUserController = new OperationalUserController();
        SalesController saleController = new SalesController();
        PaymentController paymentController = new PaymentController();
        BeneficiaryController beneficiaryController = new BeneficiaryController();
        RemitterController remitterController = new RemitterController();
        RemittanceController remittanceController = new RemittanceController();
        
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setResizable(false);
        mainWindow.setSize(300, 550);
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setLayout(null);
        mainWindow.setVisible(true);
        
        titleLabel.setSize(150, 15);
        titleLabel.setLocation(75, 25);
        mainWindow.add(titleLabel);
        if(LoginController.currentUser.getRole().equals("Administrador")){
            titleLabel.setText("Panel de Administración");
        }else if(LoginController.currentUser.getRole().equals("Vendedor")){
            titleLabel.setText("Panel de Ventas");
        }else if(LoginController.currentUser.getRole().equals("Pagador")){
            titleLabel.setText("Panel de Pagos");
        }
        
        OperationalUserButton.setSize(200, 25);
        if(LoginController.currentUser.getRole().equals("Administrador")){
            OperationalUserButton.addActionListener(operationalUserController);
            OperationalUserButton.setLocation(50, 50);
            mainWindow.add(OperationalUserButton);
        }

        salesButton.setSize(100,25);
        salesButton.addActionListener(saleController);
        if(LoginController.currentUser.getRole().equals("Administrador")){ 
            salesButton.setLocation(100, 100);
            mainWindow.add(salesButton);
        }else if(LoginController.currentUser.getRole().equals("Vendedor")){
            salesButton.setLocation(100, 50);
            mainWindow.add(salesButton);
        }

        paymentButton.setSize(100, 25);
        paymentButton.addActionListener(paymentController);
        if(LoginController.currentUser.getRole().equals("Administrador")){
            paymentButton.setLocation(100, 150);
            mainWindow.add(paymentButton);
        }else if(LoginController.currentUser.getRole().equals("Pagador")){
            paymentButton.setLocation(100, 50);
            mainWindow.add(paymentButton);
        }

        remitterButton.setSize(100, 25);
        remitterButton.addActionListener(remitterController);
        if(LoginController.currentUser.getRole().equals("Administrador")){
            remitterButton.setLocation(100, 200);        
            mainWindow.add(remitterButton);
        }else if(LoginController.currentUser.getRole().equals("Vendedor")){
            remitterButton.setLocation(100, 100);        
            mainWindow.add(remitterButton);
        }

        beneficiaryButton.setSize(150, 25);
        beneficiaryButton.addActionListener(beneficiaryController);
        if(LoginController.currentUser.getRole().equals("Administrador")){
            beneficiaryButton.setLocation(75, 250);
            mainWindow.add(beneficiaryButton);
        }else if(LoginController.currentUser.getRole().equals("Pagador")){
            beneficiaryButton.setLocation(75, 100);
            mainWindow.add(beneficiaryButton);
        }

        remittanceStatusButton.setSize(150, 25);
        remittanceStatusButton.addActionListener(remittanceController);
        if(LoginController.currentUser.getRole().equals("Administrador")){
            remittanceStatusButton.setLocation(75, 300);
            mainWindow.add(remittanceStatusButton);
        }else if(LoginController.currentUser.getRole().equals("Vendedor")){
            remittanceStatusButton.setLocation(75, 150);
            mainWindow.add(remittanceStatusButton);
        }
        
        accountingButton.setSize(150, 25);
        if(LoginController.currentUser.getRole().equals("Administrador")){
            accountingButton.setLocation(75, 350);
            mainWindow.add(accountingButton);
        }
        
        configurationButton.setSize(150, 25);
        if(LoginController.currentUser.getRole().equals("Administrador")){
            configurationButton.setLocation(75, 400);
            mainWindow.add(configurationButton);
        }
        
        closeSesionButton.setSize(150, 25);
        closeSesionButton.setLocation(75, 450);
        closeSesionButton.addActionListener((ActionEvent e) -> {
           mainWindow.dispose();
       
            Login l = new Login(true);
            });
            mainWindow.add(closeSesionButton);
        
    }  
}
