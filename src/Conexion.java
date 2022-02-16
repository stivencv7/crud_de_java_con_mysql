import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//esta es la Clase que nos permite conectarnos a mysql
public class Conexion {
	
	private static final String CONTROLADOR="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/jva";
	private static final String USER="root";
	private static final String CLAVE="";  //si tienen una clave en el mysql la ponen, como yo no
											//no le tengo clave la dejo vasia  
	
	public Connection Conectar() {
		Connection conexion=null;
		try {
			Class.forName(CONTROLADOR);
			
			conexion=DriverManager.getConnection(URL,USER,CLAVE);
			System.out.println("conexion ok");
			
		}catch (ClassNotFoundException e) {
			System.out.println("Error al cargar el conector");
			e.printStackTrace();
		
		}catch (SQLException e) {
			System.out.println("error de conexion");
			e.printStackTrace();
		}
		return conexion;
	}

}