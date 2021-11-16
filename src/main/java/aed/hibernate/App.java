package aed.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class App {

	public static void main(String[] args) {
		NomHotel nomHotel = new NomHotel();
		nomHotel.setNombre("Emirates");
		nomHotel.setPrimerApellido("Luxury");
		nomHotel.setSegundoApellido("Hotel");
		
		Hotel h10 = new Hotel(); //NO hay necesidad de crear el constructor para pedir datos a la base de datos
		h10.setCodHotel("555555");
		h10.setNomHotel("Hotel Barceló Los Gigantes");
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hotel.class);
		
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		
		SessionFactory sf = config.buildSessionFactory(reg);
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		//Para guardar en base de datos utilizar session.save(Hotel)
		session.save(h10);
//		h10 = session.get(Hotel.class, "111111");
		
		tx.commit();
		
		System.out.println(h10);
	}

}
