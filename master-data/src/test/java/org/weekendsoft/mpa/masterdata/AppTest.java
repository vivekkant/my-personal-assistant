package org.weekendsoft.mpa.masterdata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.weekendsoft.mpa.masterdata.controller.HomeController;

public class AppTest {

	@Test
    public void testApp() {
		HomeController hc = new HomeController();
		String result = hc.home();
		assertEquals(result, "Home URL default response of the reference data microservice");
    }
}
