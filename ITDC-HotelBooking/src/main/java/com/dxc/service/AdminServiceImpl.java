package com.dxc.service;

import java.text.ParseException;
import java.util.List;

import org.bson.Document;

import com.dxc.dao.AdminDao;
import com.dxc.dao.AdminDaoImpl;
import com.dxc.pojo.Bookings;
import com.dxc.pojo.Hotel;

public class AdminServiceImpl implements AdminService {

	AdminDao adminDao = new AdminDaoImpl();

	@Override
	public boolean adminLogin(int adminid, int password) {
		return adminDao.adminLogin(adminid, password);
	}

	@Override
	public boolean addHotel(Hotel hotel) {
		return adminDao.addHotel(hotel);
	}

	@Override
	public List<Document> allHotels(Hotel hotel) {
		return adminDao.allHotels(hotel);
	}

	@Override
	public List<Document> dailyBookings(String bookedDate, Bookings booking) throws ParseException {
		return adminDao.dailyBookings(bookedDate, booking);
	}

	@Override
	public boolean cancelOnRequest(Bookings booking) {
		return adminDao.cancelOnRequest(booking);
	}

}
