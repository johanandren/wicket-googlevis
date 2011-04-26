package com.markatta.wicket.googlevis;

import java.io.Serializable;

/**
 * Simple data table implementation
 *
 * @author johan
 */
public final class ReadOnlyDataTable implements Serializable, DataTable {

    private static final long serialVersionUID = 1L;

    private final Column[] columns;

    private final Object[][] rows;

    public ReadOnlyDataTable(Column[] columns, Object[][] rows) {
        this.columns = columns;
        this.rows = rows;
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public int getRowCount() {
        return rows.length;
    }

    @Override
    public Column getColumn(int index) {
        return columns[index];
    }

    @Override
    public Object[] getRow(int index) {
        return rows[index];
    }
}
