package com.markatta.wicket.googlevis;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * A column for the google visualizations data table
 *
 * @author johan
 */
public interface Column {

    public static final Set<String> VALID_TYPES = new HashSet<String>(Arrays.asList("boolean", "string", "number", "date"));

    /**
     * A label for the column or null if none was specified
     */
    String getLabel();

    /**
     * @return One of the {@link #VALID_TYPES}
     */
    String getType();
}
