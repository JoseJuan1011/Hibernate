package aed.hibernate;

import java.sql.Date;
import java.util.Objects;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.query.Query;

import aed.hibernate.tablas.Cliente;
import aed.hibernate.tablas.Estancia;
import aed.hibernate.tablas.Habitacion;
import aed.hibernate.tablas.Hotel;
import aed.hibernate.tablas.Observacion;
import aed.hibernate.tablas.ObservacionPK;
import aed.hibernate.tablas.Regimen;

public class Options {

	private static Scanner teclado;
	
	public static void InsertarAction(Session session, int numTable) {
		teclado = new Scanner(System.in);
		
		System.out.println("Escriba aquí los datos del registro a insertar: ");
		try {
			switch (numTable) {
			case 1:
				Hotel hotel = onInsertarHotel(session);
				session.save(hotel);
			break;
				
			case 2:
				Habitacion habitacion = onInsertarHabitacion(session);
				session.save(habitacion);
			break;
			
			case 3:
				Observacion observacion = onInsertarObservacion(session);
				session.save(observacion);
			break;
			
			case 4:
				Cliente cliente = onInsertarCliente(session);
				session.save(cliente);
			break;
			
			case 5:
				Regimen regimen = onInsertarRegimen(session);
				session.save(regimen);
			break;
			
			case 6:
				Estancia estancia = onInsertarEstancias(session);
				session.save(estancia);
			break;
			}
			System.out.println("Insercción Completada");
		} catch (Exception e) {
			System.out.println("Insercción NO Completada");
			e.printStackTrace();
		}
		
		
	}

	//onInsertarMethods
	private static Hotel onInsertarHotel(Session session) {
		Hotel hotel = new Hotel();
		
		System.out.println("codHotel: ");
		hotel.setCodHotel(teclado.next());
		
		System.out.println("nomHotel: ");
		teclado.nextLine();
		hotel.setNomHotel(teclado.nextLine());
		
		return hotel;
	}

	private static Habitacion onInsertarHabitacion(Session session) {
		Habitacion habitacion = new Habitacion();
		
		System.out.println("codHabitacion: ");
		habitacion.setCodHabitacion(teclado.nextInt());
		
		System.out.println("codHotel: ");
		String codHotel = teclado.next();
		habitacion.setCodHotel(session.get(Hotel.class,codHotel));
		
		System.out.println("numHabitación: ");
		habitacion.setNumHabitacion(teclado.nextInt());
		
		System.out.println("capacidad: ");
		habitacion.setCapacidad(teclado.nextInt());
		
		System.out.println("preciodia: ");
		habitacion.setPreciodia(teclado.nextInt());
		
		System.out.println("activa: ");
		habitacion.setActiva(teclado.nextInt());
		
		return habitacion;
	};

	private static Observacion onInsertarObservacion(Session session) {
		Observacion observacion = new Observacion();
		
		System.out.println("codHabitacion: ");
		ObservacionPK obPK = new ObservacionPK();
		obPK.setHabitacion(session.get(Habitacion.class,teclado.nextInt()));
		observacion.setObservacionPK(obPK);
		
		System.out.println("Observaciones: ");
		teclado.nextLine();
		observacion.setObservaciones(teclado.nextLine());
		return observacion;
	}
	
	private static Cliente onInsertarCliente(Session session) {
		Cliente cliente = new Cliente();
		
		System.out.println("codDNIoNIE: ");
		cliente.setCoddnionie(teclado.next());
		
		System.out.println("nombre: ");
		teclado.nextLine();
		cliente.setNombre(teclado.nextLine());
		
		System.out.println("nacionalidad: ");
		teclado.nextLine();
		cliente.setNacionalidad(teclado.nextLine());
		
		return cliente;
	}
	
	private static Regimen onInsertarRegimen(Session session) {
		Regimen regimen = new Regimen();
		
		System.out.println("codRegimen: ");
		regimen.setCodRegimen(teclado.nextInt());
		
		System.out.println("codHotel: ");
		Hotel hotel = session.get(Hotel.class, teclado.next());
		regimen.setCodHotel(hotel);
		
		System.out.println("tipo: ");
		regimen.setTipo(teclado.next());
		
		System.out.println("precio: ");
		regimen.setPrecio(teclado.nextInt());
		
		return regimen;
	}
	
	private static Estancia onInsertarEstancias(Session session) {
		Estancia estancia = new Estancia();
		
		System.out.println("codEstancia: ");
		estancia.setCodEstancia(teclado.nextInt());
		
		System.out.println("codDNIoNIE: ");
		estancia.setDni(session.get(Cliente.class, teclado.next()));
		
		System.out.println("codHabitacion: ");
		estancia.setHabitacion(session.get(Habitacion.class, teclado.nextInt()));
		
		System.out.println("fechaInicio(YYYY-MM-DD): ");
		estancia.setFechaInicio(Date.valueOf(teclado.next()));
		
		System.out.println("fechaFin(YYYY-MM-DD): ");
		estancia.setFechaFin(Date.valueOf(teclado.next()));
		
		System.out.println("codRegimen: ");
		estancia.setCodRegimen(session.get(Regimen.class, teclado.nextInt()));
		
		System.out.println("ocupantes: ");
		estancia.setOcupantes(teclado.nextInt());
		
		System.out.println("precioestancia: ");
		estancia.setPrecioestancia(teclado.nextInt());
		
		System.out.println("pagado: ");
		estancia.setPagado(teclado.nextInt());
		
		return estancia;
	}
	
	
	
	public static void ModificarAction(Session session) {
		int capacidad, preciodia, activa;
		teclado = new Scanner(System.in);
		
		System.out.println("Escriba los datos del registro a modificar: ");
		System.out.println("codHabitacion: ");
		int codHabitacion = teclado.nextInt();
		
		if (mostrarRegistro(session,codHabitacion)) {
			System.out.println("Escriba los valores del registro a modificar: ");
			System.out.print("capacidad: ");
			capacidad = teclado.nextInt();
			System.out.print("preciodia: ");
			preciodia = teclado.nextInt();
			System.out.print("activa: ");
			activa = teclado.nextInt();
			
			try {
				Query q = session.createQuery("update from habitaciones set capacidad = ?1, preciodia = ?2, activa = ?3 where codHabitacion = ?4");
				q.setParameter(1,capacidad);
				q.setParameter(2, preciodia);
				q.setParameter(3, activa);
				q.setParameter(4, codHabitacion);
				
				q.executeUpdate();
				
				System.out.println("Modificacion Completada");
			} catch (Exception e) {
				System.out.println("Modificacion NO Completada");
				e.printStackTrace();
			}
			
		} else {
			System.out.println("No existe tal registro");
		}
		
	}

	public static void EliminarAction(Session session) {
		teclado = new Scanner(System.in);
		System.out.println("Escriba los datos del registro a Eliminar: ");
		System.out.print("codHabitacion: ");
		int codHabitacion = teclado.nextInt();
		if (mostrarRegistro(session,codHabitacion)) {
			
			System.out.println("¿Quiere Eliminar las Estancias dependientes también (S/N)?");
			String param = teclado.next();
			while (!(param.equals("S"))&&!(param.equals("N"))) {
				System.out.println("Elija una de las opciones permitidas (S/N): ");
				param = teclado.next();
			}
			
			try {
				if (param.equals("S")) {
					Query q = session.createQuery("delete from estancias where codHabitacion = ?1");
					q.setParameter(1,codHabitacion);
					
					q.executeUpdate();
				}
				else {
					Query q = session.createQuery("update from estancias set codHabitacion = null where codHabitacion = ?1");
					q.setParameter(1,codHabitacion);
					
					q.executeUpdate();
				}
				Query q = session.createQuery("delete from habitaciones where codHabitacion = ?1");
				q.setParameter(1,codHabitacion);
				
				q.executeUpdate();
				
				System.out.println("Eliminación Completada");
			} catch (Exception e) {
				System.out.println("Eliminación Incompleta");
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("No existe tal registro en la base de datos");
		}
		
	}

	private static boolean mostrarRegistro(Session session, int codHabitacion) {	
		Query q = session.createQuery("from habitaciones where codHabitacion = ?1");
		q.setParameter(1, codHabitacion);
			
		Habitacion habitacion = (Habitacion) q.uniqueResult();
		
		return (Objects.isNull(habitacion) ? false : true);
	}
}
