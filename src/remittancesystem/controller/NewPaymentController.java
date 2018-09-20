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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import remittancesystem.model.Beneficiary;
import remittancesystem.model.BeneficiaryTableModel;
import remittancesystem.model.Payment;
import remittancesystem.model.PaymentTableModel;
import remittancesystem.model.Remittance;
import remittancesystem.model.RemittanceTableModel;
import remittancesystem.view.MainModule;

/**
 *
 * @author Omar
 */
public class NewPaymentController implements ActionListener{
    public static JFrame newPaymentWindow = new JFrame();
    static int pSelected = 0;
    int idBeneficiary = 0;
    Beneficiary beneficiary = null;
    public static boolean pnotSelected = true;
    Remittance remittance = null;
    RemittanceTableModel model = new RemittanceTableModel();
    JTable remittanceTable = new JTable(model);
    JButton selectButton = new JButton("Seleccionar");
    JButton backButton = new JButton("Atrás");
    
    @Override
    public void actionPerformed(ActionEvent e) {
        NewPaymentController n = new NewPaymentController(true);
    }
    
    public NewPaymentController(){}
    
     public NewPaymentController(boolean b){
     MainModule.mainWindow.setVisible(false);
        JPanel contentpane = new JPanel();
        contentpane.setLayout(new FlowLayout());
        contentpane.setSize(750, 300);
        newPaymentWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newPaymentWindow.setResizable(false);
        newPaymentWindow.setSize(750, 400);
        newPaymentWindow.setLocationRelativeTo(null);
        newPaymentWindow.setLayout(null);
        newPaymentWindow.setVisible(true);
        newPaymentWindow.setContentPane(contentpane);
        remittanceTable.setPreferredScrollableViewportSize(new Dimension(750, 300));
        JScrollPane scrollPane = new JScrollPane(remittanceTable); 
        contentpane.add( scrollPane,BorderLayout.CENTER );
        
        remittanceTable.addMouseListener(new MouseAdapter(){
        @Override
        public void mouseClicked(MouseEvent e) {
           pnotSelected = false;
           int fila = remittanceTable.rowAtPoint(e.getPoint());
           pSelected = fila;
            }
         });
       
        selectButton.setSize(150, 25);
        selectButton.setLocation(100, 500);
        selectButton.addActionListener((ActionEvent e) -> {
           if(!pnotSelected){
            remittance = getCurrentRemittance();
            if(remittance.getStatus().equals("No pagada")){
                idBeneficiary = remittance.getSale().getIdBeneficiario();
                beneficiary = getCurrentBeneficiary();
                if((beneficiary.getAccumulated()+ remittance.getSale().getAmount())< LimitController.BENEFICIARY_LIMIT){   
                    Payment payment = new Payment(pointer() + 1, getCurrentDate(), getCurrentTime(),idBeneficiary ,
                    remittance.getSale().getDestinationCountry().getExchangeRate(), remittance.getSale().getAmount());
                    PaymentTableModel.paymentList[pointer()] = payment;
                    updateRemittance();    
                    updateBeneficiary();
                        JOptionPane.showMessageDialog(newPaymentWindow, "Pago realizado correctamente", "Pago",
                            JOptionPane.INFORMATION_MESSAGE);
                    newPaymentWindow.dispose();
                    PaymentController p = new PaymentController(true);
                }else{
                    JOptionPane.showMessageDialog(newPaymentWindow, "El usuario beneficiario " + beneficiary.getName() + " alcanzó"
                                + " el límite establecido por el sistema para recibir remesas", "Error",
                                JOptionPane.ERROR_MESSAGE);
                }   

                }else{
                    JOptionPane.showMessageDialog(newPaymentWindow, "Esta remesa ya fue pagada, seleccione una remesa que no haya sido"
                            + " pagada", "Venta",
                        JOptionPane.INFORMATION_MESSAGE);
                }
            
            }else{
                    JOptionPane.showMessageDialog(newPaymentWindow, "Por favor seleccione una remesa", "Venta",
                        JOptionPane.INFORMATION_MESSAGE);
                }   
        });
        backButton.setSize(150, 25);
        backButton.setLocation(300, 500);
        backButton.addActionListener((ActionEvent e) -> {
           newPaymentWindow.dispose();
           PaymentController p = new PaymentController(true);
        });
         newPaymentWindow.add(selectButton);

        newPaymentWindow.add(backButton);
        
     
     }
     public String getCurrentTime(){
        Date date = new Date();
        DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
        return hourFormat.format(date);
    }
    
    public String getCurrentDate(){
        Date time = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        return dateFormat.format(time);
    }
     public int pointer(){
         int count = 0;
         for(Payment p: PaymentTableModel.paymentList){
             if(!(p==null)){
                count += 1;
             }
         }
         return count;
     }
     public Beneficiary getCurrentBeneficiary(){
         for(Beneficiary be: BeneficiaryTableModel.beneficiaryList){
             if(!(be==null)){
                 if(be.getIdBeneficiary()==idBeneficiary){
                     return be;
                 }
             }
         }
         return null;
     }
     public Remittance getCurrentRemittance(){
         for(Remittance re: RemittanceTableModel.remittanceList){
             if(!(re==null)){
                 if((re.getIdRemittance()-1)==pSelected){
                     return re;
                 }
             }
         }
         return null;
     }
     
     public void updateBeneficiary(){
         for(Beneficiary b: BeneficiaryTableModel.beneficiaryList){
             if(!(b==null)){
                 if(b.getIdBeneficiary()== beneficiary.getIdBeneficiary()){
                     b.setAccumulated(remittance.getSale().getAmount());
                     BeneficiaryTableModel.beneficiaryList[b.getIdBeneficiary()-1] = b;
                 }
             }
         }
     }
     
     public void updateRemittance(){
         for(Remittance rem: RemittanceTableModel.remittanceList){
             if(!(rem==null)){
                 if(rem.getIdRemittance()==remittance.getIdRemittance()){
                     rem.setStatus("Pagada");
                     RemittanceTableModel.remittanceList[rem.getIdRemittance()-1] = rem;
                 }
             }
         }
     
     }
    
}
