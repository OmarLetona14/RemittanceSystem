/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar
 */
public class SaleTableModel extends AbstractTableModel {
    public static Sale[] saleList = new Sale[100];
    private final String[] columnNames = new String[]{
        "ID", "ID del remitente", "ID del beneficiario", "País de destino", "Fecha",
        "Hora", "Monto"
    };
    int pointer(){
        int count = 0;
        for(Sale s: saleList){
            if(!(s==null)){
                count += 1;
            }
        }return count;
    }
    private final Class[] columnClass = new Class[] {
        Integer.class, Integer.class, Integer.class, String.class, String.class,
        String.class, double.class
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
        Sale row = saleList[rowIndex];
        if(0 == columnIndex) {
            return row.getIdSale();
        }
        else if(1 == columnIndex) {
            return row.getIdRemitter();
        }
        else if(2 == columnIndex) {
            return row.getIdBeneficiario();
        }
        else if(3 == columnIndex) {
            return row.getDestinationCountry().getCountryName();
        }
        else if(4 == columnIndex) {
            return row.getCurrentDate();
        }
        else if(5 == columnIndex) {
            return row.getCurrentTime();
        }
        else if(6 == columnIndex) {
            return row.getAmount();
        }
        
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Sale instance = (Sale)aValue;
       Sale row = saleList[rowIndex];
       if(0 == columnIndex) {
           row.setIdSale((Integer) instance.getIdSale());
       }
       else if(1 == columnIndex) {
           row.setIdRemitter((Integer) instance.getIdRemitter());
       }
       else if(2 == columnIndex) {
           row.setIdBeneficiario((Integer) instance.getIdBeneficiario());
       }
       else if(3 == columnIndex) {
           row.getDestinationCountry().setCountryName((String) instance.getDestinationCountry().getCountryName());
       }
       else if(4 == columnIndex) {
           row.setCurrentDate((String) instance.getCurrentDate());
       }
       else if(5 == columnIndex) {
           row.setCurrentTime((String) instance.getCurrentTime());
       }
       else if(6 == columnIndex) {
           row.setAmount((double) instance.getAmount());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
