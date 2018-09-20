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
public class OperationalUserTableModel extends AbstractTableModel {
    
    public static OperationalUser[] operationalUserList = new OperationalUser[100];
    private final String[] columnNames = new String[]{
        "ID", "Nombre de usuario", "Contraseña", "Rol"
    };
    int pointer(){
        int count = 0;
        for(OperationalUser uo: operationalUserList){
            if(!(uo==null)){
                count += 1;
            }
        }return count;
    }
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, String.class, String.class
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
        OperationalUser row = operationalUserList[rowIndex];
        if(0 == columnIndex) {
            return row.getIdOperationalUser();
        }
        else if(1 == columnIndex) {
            return row.getNickname();
        }
        else if(2 == columnIndex) {
            return row.getPassword();
        }
        else if(3 == columnIndex) {
            return row.getRole();
        }
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       OperationalUser instance = (OperationalUser)aValue;
       OperationalUser row = operationalUserList[rowIndex];
       if(0 == columnIndex) {
           row.setIdOperationalUser((Integer) instance.getIdOperationalUser());
       }
       else if(1 == columnIndex) {
           row.setNickname((String) instance.getNickname());
       }
       else if(2 == columnIndex) {
           row.setPassword((String) instance.getPassword());
       }
       else if(3 == columnIndex) {
           row.setRole((String) instance.getRole());
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
