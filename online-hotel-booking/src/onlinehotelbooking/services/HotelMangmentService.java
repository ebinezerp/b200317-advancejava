package onlinehotelbooking.services;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import onlinehotelbooking.dto.HotelManagement;
import onlinehotelbooking.util.HibernateConfiguration;

public class HotelMangmentService {

	/*
	 * private Connection con;
	 * 
	 * public HotelMangmentService() throws SQLException { con = new
	 * DBConnection().getConnection(); }
	 * 
	 * // to store data in DB public boolean save(HotelManagement hotelManagement) {
	 * 
	 * try { PreparedStatement ps = con.prepareStatement(
	 * "insert into hotelmang(fullname,email,mobile,username,password) values(?,?,?,?,?)"
	 * );
	 * 
	 * ps.setString(1, hotelManagement.getFullname()); ps.setString(2,
	 * hotelManagement.getEmail()); ps.setString(3, hotelManagement.getMobile());
	 * ps.setString(4, hotelManagement.getUsername()); ps.setString(5,
	 * hotelManagement.getPassword());
	 * 
	 * int count = ps.executeUpdate(); if (count > 0) { return true; } else { return
	 * false; } } catch (SQLException e) { e.printStackTrace(); return false; }
	 * 
	 * }
	 */

	/*
	 * public HotelManagement login(String username, String password) {
	 * 
	 * try { PreparedStatement ps = con.
	 * prepareStatement("select * from hotelmang where username=? and password = ?"
	 * ); ps.setString(1, username); ps.setString(2, password);
	 * 
	 * ResultSet rs = ps.executeQuery();
	 * 
	 * if (rs.next()) {
	 * 
	 * HotelManagement hotelManagement = new HotelManagement();
	 * hotelManagement.setId(rs.getInt("id"));
	 * hotelManagement.setFullname(rs.getString("fullname"));
	 * hotelManagement.setEmail(rs.getString("email"));
	 * hotelManagement.setMobile(rs.getString("mobile"));
	 * hotelManagement.setUsername(rs.getString("usernanme"));
	 * hotelManagement.setPassword(rs.getString("password"));
	 * 
	 * return hotelManagement;
	 * 
	 * } else { return null; } } catch (SQLException e) { e.printStackTrace();
	 * return null; }
	 * 
	 * }
	 */

	private SessionFactory sessionFactory;

	public HotelMangmentService() {
		sessionFactory = new HibernateConfiguration().getSessionFactory();
	}

	public boolean save(HotelManagement hotelManagement) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(hotelManagement);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.clear();
			session.close();
		}
		return false;
	}

	public HotelManagement login(String username, String password) {

		Session session = sessionFactory.openSession();
		try {
			Query<HotelManagement> query = session
					.createQuery("from HotelManagement where username=:un and password=:pass", HotelManagement.class);
			query.setParameter("un", username);
			query.setParameter("pass", password);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clear();
			session.close();
		}

		return null;
	}

	public boolean delete(HotelManagement hotelManagement) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(hotelManagement);
			tx.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.clear();
			session.close();
		}

		return false;
	}

	public HotelManagement getHotelManagement(Integer id) {

		Session session = sessionFactory.openSession();
		try {
			return session.get(HotelManagement.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.clear();
			session.close();
		}

		return null;

	}

}
