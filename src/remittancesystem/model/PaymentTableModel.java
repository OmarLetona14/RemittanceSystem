/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.model;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar
 */
public class PaymentTableModel extends AbstractTableModel {
    public static Payment[] paymentList = new Payment[100];
    private final String[] columnNames = new String[]{
        "ID", "Fecha de pago", "Hora de pago", "Beneficiario", "Tipo de cambio",
        "Monto de destino"
    };
    int pointer(){
        int count = 0;
        for(Payment p: paymentList){
            if(!(p==null)){
                count += 1;
            }
        }return count;
    }
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, String.class, String.class, double.class,
        double.class
    };
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
    @Override
    public int getRowCount()
    {
        return pointer();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Payment row = paymentList[rowIndex];
        if(0 == columnIndex) {
            return row.getIdPayment();
        }
        else if(1 == columnIndex) {
            return row.getCurrentDate();
        }
        else if(2 == columnIndex) {
            return row.getCurrentTime();
        }
        else if(3 == columnIndex) {
            return row.getIdBeneficiary();
        }
        else if(4 == columnIndex) {
            return row.getExchange();
        }
        else if(5 == columnIndex) {
            return row.getAmount();
        }
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Payment instance = (Payment)aValue;
       Payment row = paymentList[rowIndex];
       if(0 == columnIndex) {
           row.setIdPayment((Integer) instance.getIdPayment());
       }
       else if(1 == columnIndex) {
           row.setCurrentDate((String) instance.getCurrentDate());
       }
       else if(2 == columnIndex) {
           row.setCurrentTime((String) instance.getCurrentTime());
       }
       else if(3 == columnIndex) {
           row.setIdBeneficiary((Integer) instance.getIdBeneficiary());
       }
       else if(4 == columnIndex) {
           row.setExchange((double) instance.getExchange());
       }
       else if(5 == columnIndex) {
           row.setAmount((double) instance.getAmount());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
