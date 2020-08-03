package mavendemo.hibernate_mapping.onetoone;

import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.query.Query;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {

		Configuration configuration = new Configuration();

		Properties properties = new Properties();
		properties.setProperty(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
		properties.setProperty(Environment.URL, "jdbc:mysql://localhost:3306/student_demo");
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

		Author author = new Author("Jhon", 2);
		Book book = new Book("My Book", "about my life", 200.00F, author);
		author.setBook(book);

		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			session.save(author);
			session.save(book);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.clear();
			session.close();
		}

		session = sessionFactory.openSession();

		Query<Book> query = session.createQuery("From Book where title=:title", Book.class);
		query.setParameter("title", "My Book");
		Book fetechedBook = query.getSingleResult();
		System.out.println(fetechedBook);

		System.out.println(fetechedBook.getAuthor().getName());

		/*
		 * session = sessionFactory.openSession(); Author fetechedAuthor =
		 * session.createQuery("From Author where id =: id",
		 * Author.class).setParameter("id", 1) .getSingleResult();
		 * 
		 * System.out.println(fetechedAuthor);
		 * 
		 * System.out.println(fetechedAuthor.getBook().getTitle());
		 */

	}
}
