package test;

import static org.junit.Assert.*;

import org.junit.Test;

import api.GeoAPI;

public class GeoAPITest {
	
	@Test
	public void testIsEmpty1() {
		String testCity = GeoAPI.getCity("40.761075", "-73.985756");
		assertNotNull("City name cannot be null.", testCity);
		assertNotSame("City name cannot be empty.", "", testCity);
	}
	
	@Test
	public void testIsEmpty2() {
		String testCity = GeoAPI.getCity("47.613566","-122.33191");
		assertNotNull("City name cannot be null.", testCity);
		assertNotSame("City name cannot be empty.", "", testCity);
	}

	@Test
	public void testGetCity1() {
		String testCity = GeoAPI.getCity("40.761075", "-73.985756");
		assertEquals("New York", testCity);
	}
	
	@Test
	public void testGetCity2() {
		String testCity = GeoAPI.getCity("47.613566","-122.33191");
		assertEquals("Washington", testCity);
	}
	
}
