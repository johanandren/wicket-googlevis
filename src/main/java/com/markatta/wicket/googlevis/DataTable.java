package com.markatta.wicket.googlevis;

import java.io.Serializable;

/**
 * Java representation of the google visualizations DataTable js class
 * 
 * @author johan
 */
public interface DataTable extends Serializable {

    Column getColumn(int i);

    int getColumnCount();

    Object[] getRow(int i);

    int getRowCount();
    
}
