package com.dxc.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel {

	@Id
	private String name;
	private String address;
	private String hotelPhone;
	private String rooms;
	private double cost;

	public Hotel() {

	}

	public Hotel(String name, String address, String hotelPhone, String rooms, double cost) {
		super();
		this.name = name;
		this.address = address;
		this.hotelPhone = hotelPhone;
		this.rooms = rooms;
		this.cost = cost;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getHotelPhone() {
		return hotelPhone;
	}

	public void setHotelPhone(String hotelPhone) {
		this.hotelPhone = hotelPhone;
	}

	public String getRooms() {
		return rooms;
	}

	public void setRooms(String rooms) {
		this.rooms = rooms;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		return "Hotel [name=" + name + ", address=" + address + ", hotelPhone=" + hotelPhone + ", rooms=" + rooms
				+ ", cost=" + cost + "]";
	}

}
