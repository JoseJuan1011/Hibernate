package aed.hibernate;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aed.hibernate.tablas.Estancia;
import aed.hibernate.tablas.Habitacion;

public class Controller {
	
	private Scanner teclado;
	
	private int tipoAccion;
	
	private ConfigurationClass config;
	
	private Session session;
	
	public Controller() {
		tipoAccion = 0;
		config = new ConfigurationClass();
		session = config.getSession();
		teclado = new Scanner(System.in);
	}
	
	public void execProgram() {
		System.out.println("Aquí se muestran las habitaciones: ");
		VisualizeTableHabitaciones();
		System.out.println();
		System.out.println("Aquí están las habitaciones con cada una de sus estancias: ");
		VisualizeTableHabitacionesWithEstancias();
		System.out.println("Elija la acción a tomar:\n" + "1-. Insertar un registro \n" + "2-. Modificar un registro \n"
				+ "3-. Eliminar un registro \n");
		tipoAccion = teclado.nextInt();
		execActions();
		config.closeConfiguration();
	}

	private void execActions() {
		String param = "";
		switch (tipoAccion) {
		case 1:
			
			System.out.println("Elija la tabla en la que quiere insertar los datos (elija por número): ");
			System.out.println("1-. Hoteles, 2-. Habitaciones, 3-. Observaciones, ");
			System.out.println("4-. Clientes, 5-. Regímenes, 6-. Estancias");
			Options.InsertarAction(session,teclado.nextInt());
			System.out.println("¿Quiere seguir (S/N)?");
			param = teclado.next();
			while (!(param.equals("S"))&&!(param.equals("N"))) {
				System.out.println("Elija una de las opciones permitidas (S/N): ");
				param = teclado.next();
			}
			
			if (param.equals("S")) {
				execProgram();
			}
		break;
		
		case 2:
			Options.ModificarAction(session);
			
			System.out.println("¿Quiere seguir (S/N)?");
			param = teclado.next();
			while (!(param.equals("S"))&&!(param.equals("N"))) {
				System.out.println("Elija una de las opciones permitidas (S/N): ");
				param = teclado.next();
			}
			
			if (param.equals("S")) {
				execProgram();
			}
		break;
		
		case 3:
			Options.EliminarAction(session);
			
			System.out.println("¿Quiere seguir (S/N)?");
			param = teclado.next();
			while (!(param.equals("S"))&&!(param.equals("N"))) {
				System.out.println("Elija una de las opciones permitidas (S/N): ");
				param = teclado.next();
			}
			
			if (param.equals("S")) {
				execProgram();
			}
		break;
		
		default:
			System.out.println("No se ha escrito una opción permitida.");
		break;
		}
	}

	private void VisualizeTableHabitaciones() {
		Query q = session.createQuery("from habitaciones");
		
		List<Habitacion> habitaciones =(List<Habitacion>) q.list();
		
		for (Habitacion h : habitaciones) {
			System.out.println(h);
		}
	}
	
	private void VisualizeTableHabitacionesWithEstancias() {
		Query q = session.createQuery("from habitaciones");
		
		List<Habitacion> habitaciones =(List<Habitacion>) q.list();
		
		for (Habitacion h : habitaciones) {
			System.out.println(h);
			for (Estancia e : h.getEstancias()) {
				System.out.println(e);
			}
			System.out.println();
		}
	}

	public int getTipoAccion() {
		return tipoAccion;
	}
}
