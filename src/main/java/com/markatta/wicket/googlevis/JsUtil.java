package com.markatta.wicket.googlevis;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

/**
 *
 * @author johan
 */
class JsUtil {

    private static String renderMapToJs(Map map) {
        StringBuilder builder = new StringBuilder("{");
        for (Object object : map.entrySet()) {
            Map.Entry entry = (Map.Entry) object;
            builder.append(entry.getKey());
            builder.append(":");
            builder.append(render(entry.getValue()));
            builder.append(",");
        }
        builder.setLength(builder.length() - 1);

        builder.append("}");
        return builder.toString();

    }

    private static String renderCollectionToJs(Collection list) {
        StringBuilder builder = new StringBuilder("[");
        for (Object object : list) {
            builder.append(render(object));
            builder.append(",");
        }
        builder.setLength(builder.length() - 1);
        builder.append("]");
        return builder.toString();
    }

    private static String renderArrayToJs(Object[] array) {
        return renderCollectionToJs(Arrays.asList(array));
    }

    /**
     * @return The given object graph as javascript
     */
    static String render(Object object) {
        if (object instanceof String) {
            return "'" + object + "'";
        } else if (object instanceof Object[]) {
            return renderArrayToJs((Object[]) object);
        } else if (object instanceof Map) {
            return renderMapToJs((Map) object);
        } else if (object instanceof Collection) {
            return renderCollectionToJs((Collection) object);
        } else {
            return object.toString();
        }
    }
}
