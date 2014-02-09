/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dbperson;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author fmi
 */
public class MyModel extends AbstractTableModel {

    private ResultSet result;
    private int rowCount;
    private int columnCount;
    private ArrayList data = new ArrayList();

    public MyModel(ResultSet rs) throws Exception {
        setRS(rs);
    }

    public void setRS(ResultSet rs) throws Exception {
        this.result = rs;
        ResultSetMetaData metaData = rs.getMetaData();
        rowCount = 0;
        columnCount = metaData.getColumnCount();
        while (rs.next()){
            Object[] row = new Object[columnCount];
            for(int j=0; j<columnCount; j++){
                row[j]=rs.getObject(j+1);
            }
            data.add(row);
            rowCount++;
        }
    }

    @Override
    public int getRowCount() {
        return rowCount;
    }

    @Override
    public int getColumnCount() {
        return columnCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object[] row = (Object[]) data.get(rowIndex);
        return row[columnIndex];
    }
    
    @Override
    public String getColumnName (int columnIndex){
        try{
            ResultSetMetaData metaData = result.getMetaData();
            return metaData.getColumnName(columnIndex+1);
        }
        catch(Exception e){
            e.printStackTrace();
            return null;
        }
         
        
    }
}
