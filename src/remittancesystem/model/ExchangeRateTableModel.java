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
public class ExchangeRateTableModel extends AbstractTableModel {
    
    
    public static ExchangeRate[] exchangeRateList = new ExchangeRate[100];
    private final String[] columnNames = new String[]{
        "ID", "Pais", "Moneda", "Tipo de cambio", "Ganancia"
    };
    int pointer(){
        int count = 0;
        for(ExchangeRate eR: exchangeRateList){
            if(!(eR==null)){
                count += 1;
            }
        }return count;
    }
    private final Class[] columnClass = new Class[] {
        Integer.class, String.class, String.class, double.class, double.class
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
        ExchangeRate row = exchangeRateList[rowIndex];
        if(0 == columnIndex) {
            return row.getIdCountry();
        }
        else if(1 == columnIndex) {
            return row.getCountryName();
        }
        else if(2 == columnIndex) {
            return row.getCountryCurrency();
        }
        else if(3 == columnIndex) {
            return row.getExchangeRate();
        }
        else if(4 == columnIndex) {
            return row.getGain();
        }
        return null;
    }
    @Override
   public void setValueAt(Object aValue, int rowIndex, int columnIndex)
   {    
       ExchangeRate instance = (ExchangeRate)aValue;
       ExchangeRate row = exchangeRateList[rowIndex];
       if(0 == columnIndex) {
           row.setIdCountry((Integer) instance.getIdCountry());
       }
       else if(1 == columnIndex) {
           row.setCountryName((String) instance.getCountryName());
       }
       else if(2 == columnIndex) {
           row.setCountryCurrency((String) instance.getCountryCurrency());
       }
       else if(3 == columnIndex) {
           row.setExchangeRate((double) instance.getExchangeRate());
       }
       else if(4 == columnIndex) {
           row.setGain((double) instance.getGain());
       }
   }
   
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return false;
    }
    
    
}
