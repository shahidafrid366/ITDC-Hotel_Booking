package com.dxc.dao;

import java.util.List;

import org.bson.Document;

import com.dxc.pojo.Bookings;
import com.dxc.pojo.Hotel;
import com.dxc.pojo.User;

public interface UserDao {

	public boolean newUser(User user);

	public boolean userLogin(User user);

	public List<Document> allHotels(Hotel hotel);

	public boolean booked(Bookings booking, Hotel hotel, User user, String un, String id, String r);

	public List<Document> bookingHistory(Bookings booking, String id);

	public boolean userGaveCancelRequest(Bookings booking);

}
