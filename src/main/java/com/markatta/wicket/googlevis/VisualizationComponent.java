package com.markatta.wicket.googlevis;

import java.io.Serializable;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.markup.html.IHeaderResponse;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;

/**
 *
 * @author johan
 */
public class VisualizationComponent extends WebComponent implements IHeaderContributor, Serializable {

    private static final long serialVersionUID = 1L;

    private final Configuration configuration;

    public VisualizationComponent(String id, IModel<DataTable> model, Configuration configuration) {
        super(id, model);
        setOutputMarkupId(true);
        this.configuration = configuration;
    }

    private DataTable getModelObject() {
        return (DataTable) getDefaultModelObject();
    }

    private Configuration getConfiguration() {
        return configuration;
    }

    @Override
    public void renderHead(IHeaderResponse response) {

        response.renderJavascriptReference("https://www.google.com/jsapi");
        response.renderJavascript(createDrawFunctionJs("drawGraph"), null);
        response.renderJavascript(createLoadPackagesJs(), null);
        response.renderOnDomReadyJavascript("drawGraph();");
    }

    private String createLoadPackagesJs() {
        StringBuilder builder = new StringBuilder();
        builder.append("google.load('visualization', '1', {'packages':[");
        for (String packageName : getConfiguration().getPackages()) {
            builder.append("'");
            builder.append(packageName);
            builder.append("',");
        }
        // remove last ','
        builder.setLength(builder.length() - 1);
        builder.append("]});\n");
        return builder.toString();
    }

    private String createDrawFunctionJs(String functionName) {
        StringBuilder builder = new StringBuilder();

        builder.append("\n\nfunction ");
        builder.append(functionName);
        builder.append("() {\n");

        builder.append(" var data = new google.visualization.DataTable();\n");

        // add columns
        DataTable dataTable = getModelObject();
        for (int i = 0; i < dataTable.getColumnCount(); i++) {
            Column column = dataTable.getColumn(i);
            builder.append("data.addColumn('");
            builder.append(column.getType());
            builder.append("'");
            String label = column.getLabel();
            if (label != null) {
                builder.append(", '");
                builder.append(label);
                builder.append("'");
            }
            builder.append(");\n");
        }

        // add rows
        builder.append("data.addRows([");
        for (int i = 0; i < dataTable.getRowCount(); i++) {
            Object[] row = dataTable.getRow(i);
            builder.append(JsUtil.render(row));
            builder.append(",");
        }
        // remove last ','
        builder.setLength(builder.length() - 1);
        builder.append("]);\n");
        
        builder.append(" var chart = new ");
        builder.append(getConfiguration().getChartClass());
        builder.append("(document.getElementById('");
        builder.append(getMarkupId());
        builder.append("'));\n");

        builder.append("chart.draw(data, ");
        builder.append(JsUtil.render(getConfiguration().getVisualizationOptions()));
        builder.setLength(builder.length() - 1);

        builder.append("});\n");
        
        builder.append("}\n");

        return builder.toString();
    }
}
