package aed.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import aed.hibernate.tablas.Habitacion;
import aed.hibernate.tablas.HabitacionPK;
import aed.hibernate.tablas.Hotel;

public class App {

	public static void main(String[] args) {	
		
//		Guardar esto para el proyecto de Hibernate
//		Hotel h10 = new Hotel(); //NO hay necesidad de crear el constructor para pedir datos a la base de datos
//		h10.setCodHotel("666666");
//		h10.setNomHotel("Hotel Barceló Los Gigantes");
		
		Habitacion hab10 = new Habitacion();
		hab10.setHabitacionPK(new HabitacionPK());
		hab10.getHabitacionPK().setCodHotel("111111");
		hab10.getHabitacionPK().setNumHabitacion(7);
		hab10.setCapacidad(4);
		hab10.setPreciodia(60);
		hab10.setActiva(1);
		
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
		
		Configuration config = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Hotel.class).addAnnotatedClass(Habitacion.class);
		ServiceRegistry reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		SessionFactory sf = config.buildSessionFactory(reg);
		Session session1 = sf.openSession();
		Transaction tx1 = session1.beginTransaction();
		
		//Para guardar en base de datos utilizar session.save(Hotel)
		//Para obtener datos a Objeto sería session.get(object.class,id)
//		session1.save(student);
//		session1.save(laptop);

//		Query q1 = session1.createQuery("from Students where rollid=101");
//		q1.setCacheable(true);
//		
//		Student s1;
//		
//		s1 = (Student) q1.uniqueResult();
		
//		Student s1 = (Student) session1.get(Student.class, 101);
		session1.save(hab10);
		System.out.println(hab10);
		
		tx1.commit();
		session1.close();
	}

}
