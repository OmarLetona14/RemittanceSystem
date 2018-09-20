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
public class CanceledPaymentTableModel extends AbstractTableModel {
    public static CanceledPayment[] canceledPaymentList = new CanceledPayment[100];
    private final String[] columnNames = new String[]{
        "ID", "Identificador de remesa", "Fecha", "Hora", "Beneficiario", "Motivo"
    };
    int pointer(){
        int count = 0;
        for(CanceledPayment cp: canceledPaymentList){
            if(!(cp==null)){
                count += 1;
            }
        }return count;
    }
    private final Class[] columnClass = new Class[] {
        Integer.class, Integer.class, String.class, String.class, Integer.class, String.class
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
        CanceledPayment row = canceledPaymentList[rowIndex];
        if(0 == columnIndex) {
            return row.getIdCanceledPayment();
        }else if(1 == columnIndex) {
            return row.getRemittance().getIdentifier();
        }
        else if(2 == columnIndex) {
            return row.getCurrentDate();
        }
        else if(3 == columnIndex) {
            return row.getCurrentTime();
        }
        else if(4 == columnIndex) {
            return row.getBeneficiary().getIdBeneficiary();
        }
        else if(5 == columnIndex) {
            return row.getReason();
        }
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       CanceledPayment instance = (CanceledPayment)aValue;
       CanceledPayment row = canceledPaymentList[rowIndex];
       if(0 == columnIndex) {
           row.setIdCanceledPayment((Integer) instance.getIdCanceledPayment());
       }
       else if(1 == columnIndex) {
           row.getRemittance().setIdentifier((Integer) instance.getRemittance().getIdentifier());
       }
       else if(2 == columnIndex) {
           row.setCurrentDate((String) instance.getCurrentDate());
       }
       else if(3 == columnIndex) {
           row.setCurrentTime((String) instance.getCurrentTime());
       }
       else if(4 == columnIndex) {
           row.getBeneficiary().setIdBeneficiary((Integer) instance.getBeneficiary().getIdBeneficiary());
       }
       else if(5 == columnIndex) {
           row.setReason((String) instance.getReason());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
