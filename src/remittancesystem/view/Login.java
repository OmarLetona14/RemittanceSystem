/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.view;

import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import remittancesystem.controller.LoginController;
import remittancesystem.model.OperationalUser;
import remittancesystem.model.OperationalUserTableModel;

/**
 *
 * @author Omar
 */
public class Login {
    
    LoginController controller = new LoginController();
    public static JFrame login = new JFrame();
    JLabel user = new JLabel("Usuario");
    JLabel pass = new JLabel("Contraseña");
    public static TextField nickname = new TextField();
    public static JPasswordField password = new JPasswordField();
    JButton lg = new JButton();
    
    public Login(){}
    public Login(boolean b){
        OperationalUser u = new OperationalUser(1, "admin", "admin", "Administrador");
        OperationalUserTableModel.operationalUserList[0] = u;
        login.setResizable(false);
        login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        login.setTitle("Login");
        login.setSize(400, 300);
        login.setLayout(null);
        login.setLocationRelativeTo(null);
        login.setVisible(true);
        nickname.setSize(200, 25);
        password.setLocation(75, 150);
        password.setSize(200, 25);
        nickname.setLocation(75, 75);
        user.setSize(100, 25);
        user.setLocation(75, 40);
        pass.setSize(100, 25);
        pass.setLocation(75, 115);
        lg.setText("Entrar");
        lg.addActionListener(controller);
        lg.setSize(75, 30);
        lg.setLocation(250, 200);
        lg.setEnabled(true);
        login.add(lg);
        login.add(nickname);
        login.add(password);
        login.add(user);
        login.add(pass);
    }
    
    
    
}
