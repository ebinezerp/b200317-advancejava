package hibernatedemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

//import org.hibernate.Query; - wrong

public class App {

	public static void main(String[] args) {

		Student std = new Student(101, "geeth", "geetha123@gmail.com");

		Configuration configuration = new Configuration();
		configuration = configuration.configure();
		// instance to provide a pool of sessions to perform transactions
		SessionFactory sessionFactory = configuration.buildSessionFactory();

		/*
		 * // a new session instance will be provided Session session =
		 * sessionFactory.openSession(); only DML commands Transaction tx =
		 * session.beginTransaction(); try { session.save(std); tx.commit(); } catch
		 * (Exception e) { e.printStackTrace(); tx.rollback(); }
		 * 
		 * session.clear(); session.close();
		 */

		/*
		 * Session session = sessionFactory.openSession();
		 * 
		 * // based on primary key Student fetchedStd = session.get(Student.class, 101);
		 * System.out.println(fetchedStd);
		 */

		// based on other attributes

		/*
		 * SQL - Queries HQL - Queries
		 * 
		 */

		Session session = sessionFactory.openSession();

		/*
		 * NativeQuery query =
		 * session.createNativeQuery("select * from student where email=?");
		 * query.setString(1,"geetha@gmail.com"); Object obj = query.getSingleResult();
		 * Student fetechedStd = (Student) obj;
		 */

		/*
		 * NativeQuery<Student> query=
		 * session.createNativeQuery("select * from student where email=?",
		 * Student.class); query.setString(1,"geetha@gmail.com"); Student fetchedStd =
		 * query.getSingleResult();
		 */

		/*
		 * Query query = session.createQuery("from Student where email=:std_mail");
		 * query.setParameter("std_mail","geetha@gmail.com"); Object obj =
		 * query.getSingleResult(); Student fetechedStd = (Student)obj;
		 * 
		 * System.out.println(fetechedStd);
		 */

		/*
		 * Query<Student> query =
		 * session.createQuery("from Student where email=:std_mail", Student.class);
		 * query.setParameter("std_mail", "geetha@gmail.com"); Student fetechedStd =
		 * query.getSingleResult(); System.out.println(fetechedStd);
		 */

		/*
		 * Address address = new Address(); address.setCity("Hyderabad");
		 * address.setState("Telangana"); address.setCountry("India");
		 * address.setZipCode("500030"); address.setStudent(std);
		 * 
		 * Transaction tx = session.beginTransaction(); try { session.save(std);
		 * session.save(address); tx.commit(); } catch (Exception e) {
		 * e.printStackTrace(); tx.rollback(); } finally { session.clear();
		 * session.close(); }
		 */
		
		
		/*
		 * session = sessionFactory.openSession(); Query<Student> query =
		 * session.createQuery("From Student where email=: mail", Student.class);
		 * query.setParameter("mail", "geetha123@gmail.com"); Student fetechedStudent =
		 * query.getSingleResult();
		 * 
		 * System.out.println(fetechedStudent);
		 */
		/*
		 * session = sessionFactory.openSession();
		 * 
		 * Query<Address> query=
		 * session.createQuery("From Address where id=: id_value",Address.class);
		 * query.setParameter("id_value", 1); Address fetechedAddress =
		 * query.getSingleResult();
		 * 
		 * System.out.println(fetechedAddress);
		 */

		sessionFactory.close();

	}

}
