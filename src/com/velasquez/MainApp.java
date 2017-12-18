package com.velasquez;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.CannotGetJdbcConnectionException;

import com.velasquez.dao.AdminDao;
import com.velasquez.pojo.Admin;

public class MainApp {
	
	public static void main(String[] args) {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring_config.xml");
		// Con esto puedo usar el Bean (Que está configurado en el xml
		// spring_config)

		// Admin administrador = (Admin) applicationContext.getBean("admin");
		// Con esto, estoy haciendo la instancia... Traigo el Bean (El objeto)
		// con el id correspondiente

		// administrador.imprimirDireccion();//Llamé el método de la clase, sin
		// necesidad de usar el New
		// Esto, es... Inyección de dependecias :)
		
		AdminDao adminDao = (AdminDao) applicationContext.getBean("adminDao");
		
		Timestamp ts = new Timestamp(new Date().getTime());
		
		/*Admin admin = new Admin();
		//El id es autoincremental
		admin.setCargo("Desarrollador");
		admin.setNombre("Dario");
		admin.setFechaCreacion(ts);*/
		
		
		try {
			
			/*if (adminDao.save(admin)) {
			System.out.println("Admin guardado correctamente");
		} else {
			System.out.println("Error al insertar el Administrador");
		}*/
		
		//adminDao.save(admin);
		
		//List<Admin> admins = adminDao.findAll();

		/*for(Admin admin2: admins){
			System.out.println(admin2);
		}*/
		
		//System.out.println(adminDao.findById(1));//Como el Admin Tiene un metodo toString, con la instancia de una vez la muestra
		//System.out.println(adminDao.findById(3));
		//System.out.println(adminDao.findByNombre("j").toString());
		
		/*Admin admin2 = adminDao.findById(2);
		System.out.println("Admin con id 1: "+admin2);
		
		admin2.setCargo("Subgerente");
		admin2.setNombre("Jakeline");
		
		if(adminDao.update(admin2)){
			System.out.println("Actualizado correctamente: "+admin2);
		}
		
		if(adminDao.delete(admin2.getIdAd())){
			System.out.println("Admin: "+admin2.getNombre()+" Eliminado correctamente");
		}*/
		
		/*List<Admin> admins = new ArrayList<Admin>();
		admins.add(new Admin("Raul","Analista", ts));
		admins.add(new Admin("Camilo","Desarrollador", ts));
		admins.add(new Admin("Ingrid","Supervisora", ts));
		
		int[] vals = adminDao.saveAll(admins);
		for(int i : vals){//For each
			System.out.println("Filas Afectadas para esta operación: "+vals);
		}*/
			
			List<Admin> admins = new ArrayList<Admin>();
			admins.add(new Admin(1234, "pedro", "jefe de ingenieria", ts));
			admins.add(new Admin(4563, "jorge", "subjefe de ingenieria", ts));
			admins.add(new Admin(9632, "maria", "representante legal", ts));
			
			int[] vals = adminDao.saveAll(admins);
			
			for (int i : vals) {
				System.out.println("filas afectadas para la operacion: " + i);
			}
			
		} 
		catch (CannotGetJdbcConnectionException ex) {
			ex.printStackTrace();
		}
		catch (DataAccessException ex) {
			ex.printStackTrace();
		}
		
		
		((ClassPathXmlApplicationContext)applicationContext).close();
		// Esto se escribió para  eliminar el Warning de la linea donde se crea el Application context

		// System.out.println(administrador);
	}

}
