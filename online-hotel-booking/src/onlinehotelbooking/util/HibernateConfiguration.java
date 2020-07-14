package onlinehotelbooking.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateConfiguration {

	public SessionFactory getSessionFactory() {
		return new Configuration().configure().buildSessionFactory();
	}

}
