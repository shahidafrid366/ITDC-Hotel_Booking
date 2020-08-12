package com.dxc.dao;

import java.text.ParseException;
import java.util.List;

import org.bson.Document;

import com.dxc.pojo.Bookings;
import com.dxc.pojo.Hotel;

public interface AdminDao {

	public boolean adminLogin(int adminid, int password);

	public boolean addHotel(Hotel hotel);

	public List<Document> allHotels(Hotel hotel);

	public List<Document> dailyBookings(String bookedDate, Bookings booking) throws ParseException;

	public boolean cancelOnRequest(Bookings booking);

	// boolean userGaveCancelRequest(Bookings booking);

}
