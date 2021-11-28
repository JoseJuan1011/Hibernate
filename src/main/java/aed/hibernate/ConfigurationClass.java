package aed.hibernate;

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

public class ConfigurationClass {

	private Configuration config;
	
	private ServiceRegistry reg;
	
	private SessionFactory sf;
	
	private Session session;
	
	private Transaction tx1;
	
	public ConfigurationClass() {
		config = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Hotel.class)
				.addAnnotatedClass(Habitacion.class)
				.addAnnotatedClass(Cliente.class)
				.addAnnotatedClass(Regimen.class)
				.addAnnotatedClass(Estancia.class)
				.addAnnotatedClass(Observacion.class)
		;
		reg = new StandardServiceRegistryBuilder().applySettings(config.getProperties()).build();
		sf = config.buildSessionFactory(reg);
		session = sf.openSession();
		tx1 = session.beginTransaction();
	}
	
	public void closeConfiguration() {
		tx1.commit();
		sf.close();
	}
	
	public Transaction getTx1() {
		return tx1;
	}

	public void setTx1(Transaction tx1) {
		this.tx1 = tx1;
	}

	public Session getSession() {
		return session;
	}

}
