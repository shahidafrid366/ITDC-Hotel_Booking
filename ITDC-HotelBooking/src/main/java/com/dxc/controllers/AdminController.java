package com.dxc.controllers;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojo.Bookings;
import com.dxc.pojo.Hotel;
import com.dxc.service.AdminService;
import com.dxc.service.AdminServiceImpl;

@Controller
public class AdminController {

	String status;
	Bookings booking = new Bookings();

	AdminService adminService = new AdminServiceImpl();

	@RequestMapping("/home")
	public String home() {
		return "home.jsp";
	}

	@RequestMapping("/adminLogin")
	public String adminLogin(@RequestParam int adminid, @RequestParam int password, HttpSession session, Model m) {

		session.setAttribute("adminid", adminid);

		boolean b = adminService.adminLogin(adminid, password);
		if (b == true) {
			return "AdminOperations.jsp";
		} else {
			status = "Admin Login Failed !";
		}
		m.addAttribute("status", status);
		return "Status.jsp";
	}

	@RequestMapping("/addHotel")
	public String addHotel(@ModelAttribute Hotel hotel, Model m) {
		boolean b = adminService.addHotel(hotel);
		if (b == false) {
			status = "Hotel Not Added";
		} else {
			status = "Hotel Added Succesfully";
		}
		m.addAttribute("status", status);
		return "Status.jsp";
	}

	@RequestMapping("/AllHotels")
	public String allHotels(@ModelAttribute Hotel hotel, Model m) {
		List<Document> list = adminService.allHotels(hotel);
		m.addAttribute("list", list);
		return "ListOfHotels.jsp";
	}

	@RequestMapping("/dailyBookings")
	public String dailyBookings(@RequestParam String bookedDate, @ModelAttribute Bookings booking, Model m)
			throws ParseException {

		List<Document> list = adminService.dailyBookings(bookedDate, booking);
		if (list.isEmpty()) {
			status = "There Are No Bookings On This Day";
			m.addAttribute("status", status);
			return "Status.jsp";
		} else {
			m.addAttribute("list", list);
			return "ViewDailyBookings.jsp";
		}
	}

	@RequestMapping("/cancelOnRequest")
	public String cancelOnRequest(@ModelAttribute Bookings booking, Model m) {
		adminService.cancelOnRequest(booking);
		status = "Booking Cancelled Upon Request";
		m.addAttribute("status", status);
		return "Status.jsp";
	}

}
