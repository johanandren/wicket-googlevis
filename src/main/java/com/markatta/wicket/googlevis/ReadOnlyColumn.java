package com.markatta.wicket.googlevis;

import java.io.Serializable;

/**
 * Immutable column implementation
 * 
 * @author johan
 */
public final class ReadOnlyColumn implements Column, Serializable {

    private static final long serialVersionUID = 1L;
    
    private final String type;

    private final String label;

    public ReadOnlyColumn(String type, String label) {
        this.type = type;
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getType() {
        return type;
    }
}
