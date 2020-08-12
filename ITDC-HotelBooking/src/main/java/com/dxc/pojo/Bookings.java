package com.dxc.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bookings {

	@Id
	private String serialNo;
	private String userid;

	private String phone;
	private String hotelName;
	private String address;
	private String hotelPhone;
	private String room;
	private double cost;
	private String fromDate;
	private String toDate;
	private String bookedDate;
	private String status;

	// "userid": "shahidafrid@366.com",
	// "userName": "shahid",
	// "phone": "7416512910",
	// "hotelName": "dxc",
	// "address": "bangalore",
	// "hotelPhone": "123456",
	// "room": "1",
	// "cost": 1000,
	// fromDate: "2020-08-08",
	// toDate: "2020-08-08",
	// bookedDate: "2020-08-07"
	public Bookings() {

	}

	public Bookings(String serialNo, String userid, String phone, String hotelName, String address, String hotelPhone,
			String room, double cost, String fromDate, String toDate, String bookedDate, String status) {
		super();
		this.serialNo = serialNo;
		this.userid = userid;
		this.phone = phone;
		this.hotelName = hotelName;
		this.address = address;
		this.hotelPhone = hotelPhone;
		this.room = room;
		this.cost = cost;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.bookedDate = bookedDate;
		this.status = status;
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
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

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getBookedDate() {
		return bookedDate;
	}

	public void setBookedDate(String bookedDate) {
		this.bookedDate = bookedDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Bookings [serialNo=" + serialNo + ", userid=" + userid + ", phone=" + phone + ", hotelName=" + hotelName
				+ ", address=" + address + ", hotelPhone=" + hotelPhone + ", room=" + room + ", cost=" + cost
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", bookedDate=" + bookedDate + ", status=" + status
				+ "]";
	}

}
