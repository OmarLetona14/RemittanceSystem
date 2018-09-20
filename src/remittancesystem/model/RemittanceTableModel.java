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
public class RemittanceTableModel extends AbstractTableModel{
    public static Remittance[] remittanceList = new Remittance[100];
    private final String[] columnNames = new String[]{
        "ID de remesa", "Identificador unico", "ID del remitente", "ID del beneficiario", "País de destino", "Fecha Venta",
        "Hora Venta", "Monto", "Estado"
    };
    int pointer(){
        int count = 0;
        for(Remittance re: remittanceList){
            if(!(re==null)){
                count += 1;
            }
        }return count;
    }
    private final Class[] columnClass = new Class[] {
        Integer.class, Integer.class, Integer.class, Integer.class, String.class, String.class,
        String.class, double.class, String.class
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
        Remittance row = remittanceList[rowIndex];
        if(!(row.getStatus().equals("Vendido"))){
            if(0 == columnIndex) {
            return row.getIdRemittance();
            }
            else if(1 == columnIndex) {
            return row.getIdentifier();
            }
            else if(2 == columnIndex) {
                return row.getSale().getIdRemitter();
            }
            else if(3 == columnIndex) {
                return row.getSale().getIdBeneficiario();
            }
            else if(4 == columnIndex) {
                return row.getSale().getDestinationCountry().getCountryName();
            }
            else if(5 == columnIndex) {
                return row.getSale().getCurrentDate();
            }
            else if(6 == columnIndex) {
                return row.getSale().getCurrentTime();
            }
            else if(7 == columnIndex) {
                return row.getSale().getAmount();
            }
            else if(8 == columnIndex) {
                return row.getStatus();
            }
        }
        
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       Remittance instance = (Remittance)aValue;
       Remittance row = remittanceList[rowIndex];
       if(0 == columnIndex) {
           row.setIdRemittance((Integer) instance.getIdRemittance());
       }else if(1 == columnIndex) {
           row.setIdentifier((Integer) instance.getIdentifier());
       }
       else if(2 == columnIndex) {
           row.getSale().setIdRemitter((Integer) instance.getSale().getIdRemitter());
       }
       else if(3 == columnIndex) {
           row.getSale().setIdBeneficiario((Integer) instance.getSale().getIdBeneficiario());
       }
       else if(4 == columnIndex) {
           row.getSale().getDestinationCountry().setCountryName((String) instance.getSale().getDestinationCountry().getCountryName());
       }
       else if(5 == columnIndex) {
           row.getSale().setCurrentDate((String) instance.getSale().getCurrentDate());
       }
       else if(6 == columnIndex) {
           row.getSale().setCurrentTime((String) instance.getSale().getCurrentTime());
       }
       else if(7 == columnIndex) {
           row.getSale().setAmount((double) instance.getSale().getAmount());
       }
       else if(8 == columnIndex) {
           row.setStatus((String) instance.getStatus());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
}
