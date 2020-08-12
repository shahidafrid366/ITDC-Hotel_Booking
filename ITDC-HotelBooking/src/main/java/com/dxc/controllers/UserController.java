package com.dxc.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojo.Bookings;
import com.dxc.pojo.Hotel;
import com.dxc.pojo.User;
import com.dxc.service.UserService;
import com.dxc.service.UserServiceImpl;

@Controller
public class UserController {

	String status;
	Hotel hotel;
	Bookings booking = new Bookings();

	String phone;
	String fromDate;
	String toDate;
	String bookedDate;
	String room;

	private String uid = null;
	private String uname = null;
	private String ro = null;
	UserService userService = new UserServiceImpl();

	@RequestMapping("/newUser")
	public String newUser(@ModelAttribute User user, Model m) {

		boolean b = userService.newUser(user);
		if (b == true) {
			status = "User Registered Successful";
		} else {
			status = "User Id Already Existing. Try Giving Another ID";
		}
		m.addAttribute("status", status);
		return "Status.jsp";
	}

	@RequestMapping("userLogin")
	public String userLogin(@ModelAttribute User user, Model m) {
		this.uid = user.getUserid();
		this.uname = user.getName();
		boolean b = userService.userLogin(user);
		if (b == true) {
			return "UserOperations.jsp";
		} else {
			status = "User Login Failed";
			m.addAttribute("status", status);
			return "Status.jsp";
		}

	}

	@RequestMapping("viewHotels")
	public String viewHotels(@ModelAttribute Hotel hotel, Model m) {
		List<Document> list = userService.allHotels(hotel);
		m.addAttribute("list", list);
		return "ViewAllHotels.jsp";
	}

	@RequestMapping("/book")
	public String book(@ModelAttribute Hotel hotel, Model m) {
		this.hotel = hotel;
		m.addAttribute("hotel", hotel);
		return "BookingForm.jsp";
	}

	@RequestMapping("/formBooking")
	public String booking(@RequestParam String phone, @RequestParam String fromDate, @RequestParam String toDate,
			@RequestParam String room, @RequestParam String bookedDate, Model m) throws ParseException {

		this.phone = phone;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.room = room;
		this.bookedDate = bookedDate;
		this.ro = room;

		int enteredRooms = Integer.parseInt(room);
		int totalRooms = Integer.parseInt(hotel.getRooms());

		SimpleDateFormat sdformat = new SimpleDateFormat("MM-dd-yyyy");
		Date from = sdformat.parse(fromDate);
		Date to = sdformat.parse(toDate);
		Date sys = sdformat.parse(bookedDate);

		booking.setUserid(uname);
		booking.setPhone(phone);
		booking.setFromDate(fromDate);
		booking.setToDate(toDate);
		booking.setBookedDate(bookedDate);
		booking.setRoom(room);

		if (from.compareTo(sys) >= 0 && to.compareTo(sys) >= 0) {
			if (to.compareTo(from) >= 0) {
				if ((enteredRooms <= totalRooms)) {
					m.addAttribute("hotel", hotel);
					m.addAttribute("booking", booking);
					return "HotelConfirmation.jsp";
				} else {
					status = "We Can't Book " + enteredRooms + " Rooms Try Giving Lesser Rooms";
					m.addAttribute("status", status);
				}
			} else {
				status = "Invalid Boarding / Vacating  Dates";
				m.addAttribute("status", status);
			}
		} else {
			status = "Invalid Boarding / Vacating  Dates";
			m.addAttribute("status", status);
		}
		return "Status.jsp";

	}

	@RequestMapping("/confirmed")
	public String booked(@ModelAttribute Bookings booking, @ModelAttribute Hotel hotel, @ModelAttribute User user,
			Model m) {
		String un = uname;
		String id = uid;
		String r = ro;

		boolean b = userService.booked(booking, hotel, user, un, id, r);
		if (b == true) {
			status = "Hotel Reserved Successfully. Thanks For Bookings";
		}
		m.addAttribute("status", status);
		return "Status.jsp";
	}

	@RequestMapping("/bookingsHistory")
	public String bookingHistory(@ModelAttribute Bookings booking, Model m) {
		String id = uid;
		List<Document> list = userService.bookingHistory(booking, id);
		m.addAttribute("list", list);
		return "BookingHistory.jsp";

	}

	@RequestMapping("/userGaveCancelRequest")
	public String userGaveCancelRequest(@ModelAttribute Bookings booking, Model m) {
		boolean b = userService.userGaveCancelRequest(booking);
		if (b == true) {
			status = "Request For Cancellation Successful";
			m.addAttribute("status", status);
		}
		return "Status.jsp";
	}
}
