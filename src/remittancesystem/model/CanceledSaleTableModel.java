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
public class CanceledSaleTableModel extends AbstractTableModel  {
    
     public static CanceledSale[] canceledSaleList = new CanceledSale[100];
    private final String[] columnNames = new String[]{
        "ID", "Idenficiador de remesa", "Fecha", "Hora", "Remitente", "Motivo"
    };
    int pointer(){
        int count = 0;
        for(CanceledSale cs: canceledSaleList){
            if(!(cs==null)){
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
        CanceledSale row = canceledSaleList[rowIndex];
        if(0 == columnIndex) {
            return row.getIdCanceledSale();
        }
        else if(1 == columnIndex) {
            return row.getRemittance().getIdentifier();
        }
        else if(1 == columnIndex) {
            return row.getCurrentDate();
        }
        else if(2 == columnIndex) {
            return row.getCurrentTime();
        }
        else if(3 == columnIndex) {
            return row.getRemitter().getIdRemitter();
        }
        else if(4 == columnIndex) {
            return row.getReason();
        }
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       CanceledSale instance = (CanceledSale)aValue;
       CanceledSale row = canceledSaleList[rowIndex];
       if(0 == columnIndex) {
           row.setIdCanceledSale((Integer) instance.getIdCanceledSale());
       }
       else if(1 == columnIndex) {
           row.getRemittance().setIdentifier((Integer) instance.getRemittance().getIdentifier());
       }
       else if(1 == columnIndex) {
           row.setCurrentDate((String) instance.getCurrentDate());
       }
       else if(2 == columnIndex) {
           row.setCurrentTime((String) instance.getCurrentTime());
       }
       else if(3 == columnIndex) {
           row.getRemitter().setIdRemitter((Integer) instance.getRemitter().getIdRemitter());
       }
       else if(4 == columnIndex) {
           row.setReason((String) instance.getReason());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
}
