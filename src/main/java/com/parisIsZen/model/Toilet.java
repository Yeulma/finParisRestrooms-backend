package com.parisIsZen.model;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Toilet {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
	
	@Column(name = "timetable")
	private String timetable;
	
	@Column(name = "longitude")
	private Double longitude;
	
	@Column(name = "latitude")
	private Double latitude;
	
	@Column(name = "address")
	private String address;

	public String getTimetable() {
		return timetable;
	}

	public void setTimetable(String timetable) {
		this.timetable = timetable;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}