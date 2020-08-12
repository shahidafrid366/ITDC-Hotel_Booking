package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;
import java.text.*;
import java.util.Date;

import org.bson.Document;

import com.dxc.pojo.Bookings;
import com.dxc.pojo.Hotel;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class AdminDaoImpl implements AdminDao {

	MongoClient mongoclient = new MongoClient("localhost", 27017);
	MongoDatabase mongodatabase = mongoclient.getDatabase("itdc");

	@Override
	public boolean adminLogin(int adminid, int password) {

		MongoCollection<Document> collection = mongodatabase.getCollection("admin");

		List<Document> documents = collection.find().into(new ArrayList<>());

		for (Document d : documents) {
			double id = (double) d.get("adminid");
			double pass = (double) d.get("password");

			if (id == adminid && pass == password) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean addHotel(Hotel hotel) {
		MongoCollection<Document> collection = mongodatabase.getCollection("hotel");
		List<Document> documents = collection.find().into(new ArrayList<>());

		String name = hotel.getName();
		String address = hotel.getAddress();
		String phone = hotel.getHotelPhone();
		String rooms = hotel.getRooms();
		double cost = hotel.getCost();

		for (Document d : documents) {
			Document d1 = new Document();
			d1.append("name", name);
			d1.append("address", address);
			d1.append("hotelPhone", phone);
			d1.append("rooms", rooms);
			d1.append("cost", cost);
			collection.insertOne(d1);
			return true;
		}
		return false;
	}

	@Override
	public List<Document> allHotels(Hotel hotel) {

		MongoCollection<Document> collection = mongodatabase.getCollection("hotel");
		List<Document> list = new ArrayList<Document>();

		FindIterable<Document> cursor = collection.find();
		MongoCursor<Document> itr = cursor.iterator();

		while (itr.hasNext()) {
			Document d = itr.next();
			list.add(d);
		}
		return list;
	}

	@Override
	public List<Document> dailyBookings(String bookedDate, Bookings booking) throws ParseException {

		Document d1 = new Document();
		d1.append("bookedDate", bookedDate);
		MongoCollection<Document> collection = mongodatabase.getCollection("bookings");
		List<Document> list = (List<Document>) collection.find(d1).into(new ArrayList<>());

		FindIterable<Document> cursor = collection.find();
		MongoCursor<Document> itr = cursor.iterator();

		while (itr.hasNext()) {
			Document d = itr.next();
			String d2 = d.getString("bookedDate");

			if (bookedDate == d2) {
				list.add(d1);
			}
		}
		return list;

	}

	@Override
	public boolean cancelOnRequest(Bookings booking) {

		MongoCollection<Document> mongoCollection = mongodatabase.getCollection("bookings");
		List<Document> documents = mongoCollection.find().into(new ArrayList<>());


		String status = "cancelled";
		System.out.println(booking.getBookedDate() + " " + booking.getUserid());

		Document refno = new Document();
		refno.append("bookedDate", booking.getBookedDate());
		refno.append("userid", booking.getUserid());
		refno.append("phone", booking.getPhone());

		Document d1 = new Document();
		d1.append("$set", new Document("status", status));
		mongoCollection.updateOne(refno, d1);
		return true;
	}

}
