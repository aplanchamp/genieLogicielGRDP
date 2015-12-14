package servlet;

import static org.junit.Assert.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

public class TestMap {

	
	@Test
    public void TestMap() {
	    Map<String, Object> map = new HashMap<>();
		assertEquals(Collections.emptyMap(), map);

    }
   
}
