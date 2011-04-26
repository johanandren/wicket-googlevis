package com.markatta.wicket.googlevis;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author johan
 */
public final class PieChartConfiguration extends AbstractConfiguration implements Configuration, Serializable {

    private static final long serialVersionUID = 1L;
    
    private final boolean is3D;
    
    public PieChartConfiguration(String title, int height, int width, boolean is3D) {
        super(title, height, width);
        this.is3D = is3D;
    }

    @Override
    public Set<String> getPackages() {
        return Collections.singleton("corechart");
    }

    @Override
    public String getChartClass() {
        return "google.visualization.PieChart";
    }

    @Override
    public Map<String, Object> getVisualizationOptions() {
        Map<String, Object> options = super.getVisualizationOptions();
        options.put("is3D", is3D);
        return options;
    }
}
