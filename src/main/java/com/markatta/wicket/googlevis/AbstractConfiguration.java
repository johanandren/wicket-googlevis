package com.markatta.wicket.googlevis;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author johan
 */
public abstract class AbstractConfiguration implements Configuration, Serializable {

    private static final long serialVersionUID = 1L;

    private String title;

    private int height = 200;

    private int width = 400;

    private String backgroundColor;

    private String backgroundColorStroke;

    private Integer backgroundColorStrokeWidth;
    
    private String backgroundColorFill;
    
    private Collection<String> colors;

    public AbstractConfiguration() {
    }

    public AbstractConfiguration(String title, int height, int width) {
        this.title = title;
        this.height = height;
        this.width = width;
    }

    /**
     * The background color for the main area of the chart. Default is white.
     * @param backgroundColor HTML color string or color hex value, for example '#00cc00'
     */
    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    /**
     * The color of the chart border, as an HTML color string. Default is #666
     * @param backgroundColorStroke HTML color string or color hex value, for example '#00cc00'
     */
    public void setBackgroundColorStroke(String backgroundColorStroke) {
        this.backgroundColorStroke = backgroundColorStroke;
    }

    /**
     * Border width in pixels, default is 0
     */
    public void setBackgroundColorStrokeWidth(Integer backgroundColorStrokeWidth) {
        this.backgroundColorStrokeWidth = backgroundColorStrokeWidth;
    }

    /**
     * The chart fill color, as an HTML color string
     */
    public void setBackgroundColorFill(String backgroundColorFill) {
        this.backgroundColorFill = backgroundColorFill;
    }

    /**
     * The colors to use for the chart elements. An array of strings, where each 
     * element is an HTML color string, for example: ['red','#004411'].
     * @param colors 
     */
    public void setColors(Collection<String> colors) {
        this.colors = colors;
    }
    
    @Override
    public Map<String, Object> getVisualizationOptions() {
        Map<String, Object> options = new HashMap<String, Object>();

        addIfNotNull(options, "title", title);
        options.put("width", width);
        options.put("height", height);
        addIfNotNull(options, "backgroundColor", backgroundColor);
        addIfNotNull(options, "backgroundColor.stroke", backgroundColorStroke);
        addIfNotNull(options, "backgroundColor.strokeWidth", backgroundColorStrokeWidth);
        addIfNotNull(options, "backgroundColor.fill", backgroundColorFill);
        addIfNotNull(options, "colors", colors);
        
        return options;
    }

    protected void addIfNotNull(Map<String, Object> options, String optionKey, Object optionValue) {
        if (optionValue == null) {
            return;
        }
        options.put(optionKey, optionValue);
    }
}
