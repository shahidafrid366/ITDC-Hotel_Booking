package com.dxc.service;

import java.util.List;

import org.bson.Document;

import com.dxc.dao.UserDao;
import com.dxc.dao.UserDaoImpl;
import com.dxc.pojo.Bookings;
import com.dxc.pojo.Hotel;
import com.dxc.pojo.User;

public class UserServiceImpl implements UserService {

	UserDao userDao = new UserDaoImpl();

	@Override
	public boolean newUser(User user) {
		return userDao.newUser(user);
	}

	@Override
	public boolean userLogin(User user) {
		return userDao.userLogin(user);
	}

	@Override
	public List<Document> allHotels(Hotel hotel) {
		return userDao.allHotels(hotel);
	}

	@Override
	public boolean booked(Bookings booking, Hotel hotel, User user, String un, String id, String r) {
		return userDao.booked(booking, hotel, user, un, id, r);
	}

	@Override
	public List<Document> bookingHistory(Bookings booking, String id) {
		return userDao.bookingHistory(booking, id);
	}

	@Override
	public boolean userGaveCancelRequest(Bookings booking) {
		return userDao.userGaveCancelRequest(booking);
	}

}
