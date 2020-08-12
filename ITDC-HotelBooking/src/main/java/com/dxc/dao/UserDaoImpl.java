package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.dxc.pojo.Bookings;
import com.dxc.pojo.Hotel;
import com.dxc.pojo.User;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class UserDaoImpl implements UserDao {

	MongoClient mongoclient = new MongoClient("localhost", 27017);
	MongoDatabase mongodatabase = mongoclient.getDatabase("itdc");

	@Override
	public boolean newUser(User user) {
		MongoCollection<Document> mongoCollection = mongodatabase.getCollection("user");
		List<Document> documents = mongoCollection.find().into(new ArrayList<>());

		String userId = user.getUserid();
		String name = user.getName();
		String password = user.getPassword();

		for (Document d : documents) {
			String uid = (String) d.get("userid");
			if (uid.equals(userId)) {
				return false;
			}
		}
		Document d1 = new Document();
		d1.append("userid", userId);
		d1.append("name", name);
		d1.append("password", password);
		mongoCollection.insertOne(d1);
		return true;

	}

	@Override
	public boolean userLogin(User user) {

		MongoCollection<Document> collection = mongodatabase.getCollection("user");

		List<Document> list = (List<Document>) collection.find().into(new ArrayList<>());
		FindIterable<Document> cursor = collection.find();

		MongoCursor<Document> itr = cursor.iterator();

		String ph = user.getUserid();
		String pass = user.getPassword();

		for (int i = 0; i < list.size(); i++) {

			Document document = itr.next();
			String u = (String) document.get("userid");
			String p = (String) document.get("password");

			if (ph.equals(u) && pass.equals(p)) {
				return true;

			}
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
	public boolean booked(Bookings booking, Hotel hotel, User user, String un, String id, String r) {

		Document d2 = new Document();
		d2.append("rooms", r);
		MongoCollection<Document> collection = mongodatabase.getCollection("hotel");

		List<Document> list = (List<Document>) collection.find(d2).into(new ArrayList<>());
		FindIterable<Document> cursor = collection.find();

		MongoCursor<Document> itr = cursor.iterator();
		while (itr.hasNext()) {
			Document d = itr.next();
			String dbName = d.getString("name");

			if (hotel.getName().equals(dbName)) {

				int userGivenRooms = Integer.parseInt(r);
				int hotelRooms = Integer.parseInt(d.getString("rooms"));

				int finalRooms = hotelRooms - userGivenRooms;
				String fr = Integer.toString(finalRooms);

				Document o = new Document();
				o.append("name", d.getString("name"));

				Document u = new Document();
				u.append("$set", new Document("rooms", fr));
				collection.updateOne(o, u);
				cursor = collection.find();
				itr = cursor.iterator();
				while (itr.hasNext()) {
					list.add(itr.next());
				}

			}
		}

		MongoCollection<Document> mongoCollection = mongodatabase.getCollection("bookings");
		List<Document> documents = mongoCollection.find().into(new ArrayList<>());

		String uph = booking.getPhone();
		String hphone = hotel.getHotelPhone();
		String hname = hotel.getName();
		String haddress = booking.getAddress();
		double hcost = booking.getCost();
		String fdate = booking.getFromDate();
		String tdate = booking.getToDate();
		String bdate = booking.getBookedDate();
		String status = "booked";

		Document d1 = new Document();
		d1.append("userid", id);
		d1.append("phone", uph);
		d1.append("hotelName", hname);
		d1.append("address", haddress);
		d1.append("hotelPhone", hphone);
		d1.append("room", r);
		d1.append("cost", hcost);
		d1.append("fromDate", fdate);
		d1.append("toDate", tdate);
		d1.append("bookedDate", bdate);
		d1.append("status", status);
		mongoCollection.insertOne(d1);
		return true;
	}

	@Override
	public List<Document> bookingHistory(Bookings booking, String id) {
		Document d2 = new Document();
		d2.append("userid", id);

		MongoCollection<Document> collection = mongodatabase.getCollection("bookings");

		List<Document> list = (List<Document>) collection.find(d2).into(new ArrayList<>());
		FindIterable<Document> cursor = collection.find();

		MongoCursor<Document> itr = cursor.iterator();

		while (itr.hasNext()) {
			Document d = itr.next();
			String d1 = d.getString("userid");

			if (id == d1) {
				list.add(d2);
			}
		}
		return list;

	}

	@Override
	public boolean userGaveCancelRequest(Bookings booking) {

		MongoCollection<Document> mongoCollection = mongodatabase.getCollection("bookings");
		List<Document> documents = mongoCollection.find().into(new ArrayList<>());

		String status = "requested";
		System.out.println(booking.getBookedDate());

		Document refno = new Document();
		refno.append("userid", booking.getUserid());
		refno.append("phone", booking.getPhone());

		Document d1 = new Document();
		d1.append("$set", new Document("status", status));
		mongoCollection.updateOne(refno, d1);
		return true;
	}

}
