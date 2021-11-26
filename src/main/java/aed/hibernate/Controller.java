package aed.hibernate;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class Controller {
	
	private Scanner teclado;
	
	private int tipoAccion = 0;
	
	private ConfigurationClass config = new ConfigurationClass();
	
	private Session session = config.getSession();
	
	public void execProgram() {
		VisualizeTableHabitaciones();
		System.out.println("Elija la acción a tomar:\n" + "1-. Insertar un registro \n" + "2-. Modificar un registro \n"
				+ "3-. Eliminar un registro \n");
		execActions();
		teclado.close();
		config.closeConfiguration();
	}
	
	private void execActions() {
		String param = "";
		switch (tipoAccion) {
		case 1:
			Options.InsertarAction(session);
			
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
		}
	}

	public void VisualizeTableHabitaciones() {
		Query q = session.createQuery("from habitaciones");
	}

	public int getTipoAccion() {
		return tipoAccion;
	}
}
