package com.markatta.wicket.googlevis;

import java.util.Map;
import java.util.Set;

/**
 *
 * @author johan
 */
public interface Configuration {
    /**
     * @return The full name of the javascript chart class 
     */
    String getChartClass();

    /**
     * @return The required packages for the chart
     */
    Set<String> getPackages();

    /**
     * @return All configuration options for the chart. Should include at least "height" and "width".
     */
    Map<String, Object> getVisualizationOptions();
    
}
