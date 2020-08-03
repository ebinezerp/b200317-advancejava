package mavendemo.hibernate_mapping.onetomany;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;

public class App {

	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		// configuration.configure(); -> it loads hibernate.cfg.xml

		Properties properties = new Properties();
		properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/onetomanyexample");
		properties.setProperty(Environment.USER, "root");
		properties.setProperty(Environment.PASS, "root");
		properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL57InnoDBDialect");
		properties.setProperty(Environment.HBM2DDL_AUTO, "create");
		properties.setProperty(Environment.SHOW_SQL, "true");
		properties.setProperty(Environment.FORMAT_SQL, "true");

		configuration.setProperties(properties);

		configuration.addAnnotatedClass(Author.class);
		configuration.addAnnotatedClass(Book.class);

		SessionFactory sessionFactory = configuration.buildSessionFactory();

		Author author = new Author("abc", 5);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(author);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.clear();
			session.close();
		}

		Book book1 = new Book("Java", 200.00F);
		book1.setAuthor(author);

		session = sessionFactory.openSession();
		tx = session.beginTransaction();
		try {
			session.save(book1);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.clear();
			session.close();
		}

	}

}
