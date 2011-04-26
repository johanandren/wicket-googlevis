package com.markatta.wicket.googlevis;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/** 
 * Displays the data as an area chart. Uses the first column from the data table as x-axis.
 * 
 * http://code.google.com/intl/sv-SE/apis/visualization/documentation/gallery/areachart.html
 *
 * @author johan
 */
public class AreaChartConfiguration extends AbstractConfiguration implements Serializable {

    private static final long serialVersionUID = 1L;

    private String xAxisTitle;

    private String gridlineColor;

    public AreaChartConfiguration(String title, int height, int width) {
        super(title, height, width);
    }

    /**
     * The color of the gridlines inside the chart area. Specify a valid HTML color string.
     */
    public void setGridlineColor(String gridlineColor) {
        this.gridlineColor = gridlineColor;
    }

    public void setXAxisTitle(String title) {
        xAxisTitle = title;
    }

    @Override
    public String getChartClass() {
        return "google.visualization.AreaChart";
    }

    @Override
    public Set<String> getPackages() {
        return Collections.singleton("corechart");
    }

    @Override
    public Map<String, Object> getVisualizationOptions() {
        Map<String, Object> options = super.getVisualizationOptions();
        if (xAxisTitle != null) {
            Map<String, Object> yAxisOptions = new HashMap<String, Object>();
            yAxisOptions.put("title", xAxisTitle);
            options.put("hAxis", yAxisOptions);
        }
        addIfNotNull(options, "gridlineColor", gridlineColor);


        return options;
    }
}
