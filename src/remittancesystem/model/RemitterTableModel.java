/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package remittancesystem.model;

import java.util.Date;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Omar
 */
public class RemitterTableModel extends AbstractTableModel {
    
    public static Remitter[] remitterList = new Remitter[100];
    private final String[] columnNames = new String[]{
        "ID", "Nombre", "Fecha de nacimiento", "Nacionalidad", "Dirección", "Número de teléfono",
        "Correo electrónico"
    };
    int pointer(){
        int count = 0;
        for(Remitter r: remitterList){
            if(!(r==null)){
                count += 1;
            }
        }return count;
    }
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, String.class, String.class, String.class, Integer.class,
        String.class
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
        Remitter row = remitterList[rowIndex];
        if(0 == columnIndex) {
            return row.getIdRemitter();
        }
        else if(1 == columnIndex) {
            return row.getName();
        }
        else if(2 == columnIndex) {
            return row.getBirthdate();
        }
        else if(3 == columnIndex) {
            return row.getNationality();
        }
        else if(4 == columnIndex) {
            return row.getAddress();
        }
        else if(5 == columnIndex) {
            return row.getPhoneNumber();
        }
        else if(6 == columnIndex) {
            return row.getEmail();
        }
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Remitter instance = (Remitter)aValue;
       Remitter row = remitterList[rowIndex];
       if(0 == columnIndex) {
           row.setIdRemitter((Integer) instance.getIdRemitter());
       }
       else if(1 == columnIndex) {
           row.setName((String) instance.getName());
       }
       else if(2 == columnIndex) {
           row.setBirthdate((String) instance.getBirthdate());
       }
       else if(3 == columnIndex) {
           row.setNationality((String) instance.getNationality());
       }
       else if(4 == columnIndex) {
           row.setAddress((String) instance.getAddress());
       }
       else if(5 == columnIndex) {
           row.setPhoneNumber((Integer) instance.getPhoneNumber());
       }
       else if(6 == columnIndex) {
           row.setEmail((String) instance.getEmail());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        boolean state = true;
        if(columnIndex == 0){
            state = false;
            return state;
        }
         if(rowIndex == 0){
                state = false;
                return state;
        }
        return state;
    }
    
    
}
