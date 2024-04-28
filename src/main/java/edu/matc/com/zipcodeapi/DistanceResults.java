package edu.matc.com.zipcodeapi;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * The type Distance results.
 */
public class DistanceResults{

	@JsonProperty("distance")
	private Object distance;

	/**
	 * Get distance object.
	 *
	 * @return the object
	 */
	public Object getDistance(){
		return distance;
	}
}