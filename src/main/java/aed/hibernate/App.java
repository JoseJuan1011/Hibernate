package aed.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hotel h10 = new Hotel();
		h10.setCodHotel("333333C");
		h10.setNomHotel("H10 Los Gigantes");
		
		Configuration config = new Configuration();
		
		SessionFactory sf = config.buildSessionFactory();
		
		Session session = sf.openSession();
		session.save(h10);
	}

}
