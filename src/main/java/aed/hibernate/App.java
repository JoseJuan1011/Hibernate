package aed.hibernate;

import org.hibernate.query.Query;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import aed.hibernate.tablas.Cliente;
import aed.hibernate.tablas.Estancia;
import aed.hibernate.tablas.Habitacion;
import aed.hibernate.tablas.Hotel;
import aed.hibernate.tablas.Observacion;
import aed.hibernate.tablas.Regimen;
import aed.hibernate.tablas.trials.Laptop;
import aed.hibernate.tablas.trials.Student;

public class App {

	public static void main(String[] args) {	
		
//		Guardar esto para el proyecto de Hibernate
//		Hotel h10 = new Hotel(); //NO hay necesidad de crear el constructor para pedir datos a la base de datos
//		h10.setCodHotel("777777");
//		h10.setNomHotel("Hotel Barceló Los Gigantes");
//		
//		Habitacion hab10 = new Habitacion();
//		hab10.setCodHotel(h10);
//		hab10.setNumHabitacion(7);
//		hab10.setCapacidad(4);
//		hab10.setPreciodia(60);
//		hab10.setActiva(1);
//		
//		h10.getHabitaciones().add(hab10);
		
//		Student student = new Student();
//		student.setRollid(101);
//		student.setName("Gary");
//		
//		Laptop laptop = new Laptop();
//		laptop.setLid(1);
//		laptop.setBrand("HP");
//		laptop.setPrice(379);
//		laptop.setStudent(student);
//		
//		student.getLaptops().add(laptop);
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Hotel.class)
				.addAnnotatedClass(Habitacion.class)
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Regimen.class)
				.addAnnotatedClass(Estancia.class)
				.addAnnotatedClass(Observacion.class)
		;
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		
		//Para guardar en base de datos utilizar session.save(Hotel)
		//Para obtener datos a Objeto sería session.get(object.class,id)

		Query q = session1.createQuery("from habitaciones");
		List<Habitacion> habitaciones = q.list();
		
		for(Habitacion h : habitaciones) {
			System.out.println(h);
		}
		
		tx1.commit();
		session1.close();
		sf.close();
		reg.close();
	}

}
