package dao;

import java.util.List;

import org.hibernate.Session;

public class Queries {

	Session session;
	
	public static String traerPassword(Session session, String usuario) // Ejemplo de metodo para traer datos por HQL
	{	   
		String clave="";
	    List<String> listaDocentes= (List<String>) session.createQuery("SELECT contrasenia FROM Usuario u where nombre='"+usuario+"'").list();
	    for (String contrasenia : listaDocentes) {
			System.out.println(contrasenia);
			clave=contrasenia;
		}
		return clave; 
	}
}
