package com.markatta.wicket.googlevis;

import java.util.HashSet;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author johan
 */
public class JsUtilTest {

    @Test
    public void renderString() {
        assertEquals("'value'", JsUtil.render("value"));
    }

    @Test
    public void renderNumber() {
        assertEquals("1", JsUtil.render(1));
    }

    @Test
    public void renderBoolean() {
        assertEquals("false", JsUtil.render(Boolean.FALSE));
    }
    
    @Test
    public void renderMap() {
        Map map = new HashMap();
        map.put("key", "value");
        assertEquals("{key:'value'}", JsUtil.render(map));
    }
    
      @Test
    public void renderCollection() {
        Set map = new HashSet();
        map.add("value");
        assertEquals("['value']", JsUtil.render(map));
    }
}
