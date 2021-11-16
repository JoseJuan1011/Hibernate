package aed.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	public static void main(String[] args) {
		Hotel h10 = new Hotel();
		h10.setCodHotel("666666");
		h10.setNomHotel("Emirates Luxury Hotel");
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hotel.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		SessionFactory sf = config.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		session.save(h10);
		
		tx.commit();
	}

}
