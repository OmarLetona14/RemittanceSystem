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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import remittancesystem.model.OperationalUser;
import remittancesystem.model.OperationalUserTableModel;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class OperationalUserController implements ActionListener {
    
    int deleteRow = 0;
    boolean deleted = false; 
    static boolean created = false;
    public static JFrame newUserFrame = new JFrame();
    public static JFrame userWindow = new JFrame();
    public static JComboBox role = new JComboBox();
    public static JTextField nickTextField = new JTextField();
    public static JPasswordField passwordField = new JPasswordField();
    NewOperationalUserController ouController = new NewOperationalUserController();
    
    OperationalUserTableModel model = new OperationalUserTableModel();
    JTable operationaluserTable = new JTable(model);
    
    @Override
    public void actionPerformed(ActionEvent e) {
        OperationalUserController i = new OperationalUserController(true);
    }
    public OperationalUserController(){}
    
    public OperationalUserController(Boolean i){
    
        MainModule.mainWindow.setVisible(false);
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new FlowLayout());
        contentpane.setSize(750, 300);
        JButton newOperationalUserButton = new JButton("Agregar Usuario");
        JButton deleteOperationalUserButton = new JButton("Eliminar Usuario");
        JButton backButton = new JButton("Atras");
        userWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        userWindow.setResizable(false);
        userWindow.setSize(750, 400);
        userWindow.setLocationRelativeTo(null);
        userWindow.setLayout(null);
        userWindow.setVisible(true);
        userWindow.setContentPane(contentpane);
               
        operationaluserTable.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
           int fila = operationaluserTable.rowAtPoint(e.getPoint());
           deleteRow = fila;
            }
         });

        operationaluserTable.setPreferredScrollableViewportSize(new Dimension(750, 300));
        JScrollPane scrollPane = new JScrollPane(operationaluserTable); 
        contentpane.add( scrollPane,BorderLayout.CENTER );
        newOperationalUserButton.setSize(150, 25);
        newOperationalUserButton.setLocation(100, 500);
        newOperationalUserButton.addActionListener((ActionEvent e1) -> {
            
            JButton acceptButton = new JButton("Aceptar");
            
            JLabel nickLabel = new JLabel("Nombre de Usuario");
            JLabel passwordLabel = new JLabel("Contraseña");
            
            newUserFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            newUserFrame.setResizable(false);
            newUserFrame.setSize(300, 450);
            newUserFrame.setLocationRelativeTo(null);
            newUserFrame.setLayout(null);
            newUserFrame.setVisible(true);
            
            acceptButton.setSize(100, 25);
            acceptButton.setLocation(100, 350);
            acceptButton.addActionListener((ActionEvent e1e) ->{
                String newPassword = String.valueOf(OperationalUserController.passwordField.getPassword());
                OperationalUser newUser = new OperationalUser(pointer()+1,OperationalUserController.nickTextField.getText(),
                newPassword, String.valueOf(OperationalUserController.role.getSelectedItem()));
                try{OperationalUserTableModel.operationalUserList[pointer()] = newUser;}catch(Exception ex){
                    JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, "Error al agregar el nuevo usuario", "Error",
                            JOptionPane.ERROR_MESSAGE);

                    OperationalUserController.newUserFrame.dispose();
                }
                JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, "Usuario agregado correctamente", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                model.setValueAt(newUser, pointer()-1, 0);
                created = true;
                OperationalUserController.passwordField.setText("");
                OperationalUserController.nickTextField.setText("");
                OperationalUserController.newUserFrame.dispose();
                OperationalUserController.userWindow.dispose();
                OperationalUserController o = new OperationalUserController(true);
        
            });
            newUserFrame.add(acceptButton);
            if(!created){
            role.addItem("Vendedor");
            role.addItem("Pagador");}   
            role.setSize(150, 25);
            role.setLocation(75, 50);
            newUserFrame.add(role);
            
            nickLabel.setSize(200, 25);
            nickLabel.setLocation(50, 100);
            newUserFrame.add(nickLabel);
            
            nickTextField.setSize(200, 25);
            nickTextField.setLocation(50, 150);
            newUserFrame.add(nickTextField);
            
            passwordLabel.setSize(200, 25);
            passwordLabel.setLocation(50, 200);
            newUserFrame.add(passwordLabel);
            
            passwordField.setSize(200, 25);
            passwordField.setLocation(50, 250);
            newUserFrame.add(passwordField);
            
            
        });
        userWindow.add(newOperationalUserButton);
        
        deleteOperationalUserButton.setSize(150, 25);
        deleteOperationalUserButton.setLocation(300, 500);
        deleteOperationalUserButton.addActionListener((ActionEvent e1) -> {
            if(!(deleteRow==0)){
                            try{OperationalUserTableModel.operationalUserList[deleteRow] = null;
            deleted = true;}catch(Exception ex){
                JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, "Error al eliminar el usuario", "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
            if(deleted){JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, "Usuario eliminado correctamente", "Error",
                    JOptionPane.INFORMATION_MESSAGE);
            OperationalUserController.userWindow.dispose();
            OperationalUserController o = new OperationalUserController(true);
            }        
            else{
                JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, "Error al eliminar el usuario", "Error",
                    JOptionPane.ERROR_MESSAGE);
                }
            }else{JOptionPane.showMessageDialog(OperationalUserController.newUserFrame, ""
                    + "Este usuario no se puede eliminar", "Error",
                    JOptionPane.INFORMATION_MESSAGE);}
        });
        userWindow.add(deleteOperationalUserButton);
        
        backButton.setSize(150, 25);
        backButton.setLocation(500, 500);
        backButton.addActionListener((ActionEvent e1) -> {
            OperationalUserController.userWindow.dispose();
            MainModule.mainWindow.setVisible(true);
        });
        userWindow.add(backButton);
    }
    int pointer(){
        int count = 0;
        for(OperationalUser ou: OperationalUserTableModel.operationalUserList){
            if(!(ou==null)){
                count += 1;
            }
        }return count;
    }
}
