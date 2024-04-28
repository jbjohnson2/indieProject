package edu.matc.com.zipcodeapi;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DistanceResults{

	@JsonProperty("distance")
	private Object distance;

	public Object getDistance(){
		return distance;
	}
}