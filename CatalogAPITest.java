package test;

import static org.junit.Assert.*;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import api.CatalogAPI;

public class CatalogAPITest {

	@Test
	public void testXMLResponseIsEmpty() {
		String city = "New York";
		String xmlResponse = CatalogAPI.getXMLResponse(city);
		assertNotNull("XML Response cannot be null.", xmlResponse);
		assertNotSame("XML Response cannot be empty.", "", xmlResponse);
	}
	
	@Test
	public void testEventListIsEmpty() {
		String city = "New York";
		String eventType = "Theater tickets and Arts tickets";
		JSONArray events = CatalogAPI.getEventList(city, eventType);
		
		assertNotNull("Events list cannot be null", events);
		assertNotSame("Events list cannot be empty.", 0, events.length());
	}
	
	@Test
	public void testEventHasRequiredFields() {
		String city = "New York";
		String eventType = "Theater tickets and Arts tickets";
		JSONArray events = CatalogAPI.getEventList(city, eventType);
		
		for (int i = 0; i < events.length(); i++) {
			try {
				JSONObject event = events.getJSONObject(i);
				assertTrue("An event object does not specify \'channel\' field.", event.has("channel"));
				assertTrue("An event object does not specify \'description\' field.", event.has("description"));
				assertTrue("An event object does not specify \'minPrice\' field.", event.has("minPrice"));
				assertTrue("An event object does not specify \'venue_name\' field.", event.has("venue_name"));
				assertTrue("An event object does not specify \'zip\' field.", event.has("zip"));
				assertTrue("An event object does not specify \'lat_lon\' field.", event.has("lat_lon"));
				assertTrue("An event object does not specify \'timezone\' field.", event.has("timezone"));
				assertTrue("An event object does not specify \'addr1\' field.", event.has("addr1"));
			} catch (JSONException e) {
				fail("Cannot get events as JSON objects.");
			}
		}
	}

}
