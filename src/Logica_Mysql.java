import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class Logica_Mysql {

	public Logica_Mysql() {
		
	}
	
	public void listar() {
		
		System.out.println("esta es la lista ");
		Connection cn = null;
		Conexion conexion = new Conexion();
		Statement stm = null;
		ResultSet rs = null;
		
		try {
			cn = conexion.Conectar();
			stm = cn.createStatement();
			rs=stm.executeQuery("SELECT * FROM administrador");

			while(rs.next()) {
			int codigo =rs.getInt(1);
			String nombre=rs.getString(2);
			String correo=rs.getString(3);
			String contraseņa=rs.getString(4);
			
			System.out.println(codigo+"-"+nombre+"-"+correo+"-"+contraseņa);
			}
			System.out.println("");
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(rs !=null) {
					rs.close();
				}
				if(stm !=null) {
					stm.close();
				}
				if(cn !=null) {
					cn.close();
				}
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	public void insertar() {
		Scanner entrada=new Scanner(System.in);
		
		Connection cn=null;
		Statement stm=null;
		Conexion conex=new Conexion();
		
		System.out.println("ingrese el nombre ");
		String nombre=entrada.next();
		
		System.out.println("ingrese el correo");
		String correo=entrada.next();
		
		System.out.println("ingrese la contraseņa");
		String contraseņa=entrada.next();
		
		try {
			cn=conex.Conectar();
			stm=cn.createStatement();
			stm.executeUpdate("insert into administrador(nombre,correo,contraseņa) Values ('"
			+nombre+"','"+correo+"','"+contraseņa+"')");
			
			System.out.println("guardados correcta mente");
			
		} catch (Exception e) {
			System.out.println("no guardo");
			e.printStackTrace();
		}
		finally {
			try {
				if(stm!=null) {
					stm.close();
				}
				if(cn!=null) {
					cn.close();
				}
				
				
			}catch (Exception e) {
				System.out.println(".....");
				e.printStackTrace();
			}
			
		}
	}
	
	public void buscar() {
		Scanner entrada=new Scanner(System.in);
		
		Connection cn=null;
		Conexion conexion=new Conexion();
		Statement stm=null;
		ResultSet rs=null;
		System.out.println("ingrese la contraseņa: ");
		String contraseņa=entrada.next();
		
		
		try {
			
			cn=conexion.Conectar();
			stm=cn.createStatement();
			rs=stm.executeQuery("SELECT nombre,correo,contraseņa "+"from administrador Where contraseņa="+contraseņa);
			
			if(rs.next()) {
				String per=rs.getString("contraseņa");
				System.out.println(rs.getString("nombre"));
				System.out.println(rs.getString("correo"));
				System.out.println(rs.getString("contraseņa"));
			}else{
				System.out.println("no encontrado");
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(rs !=null) {
					rs.close();
				}
				if(stm !=null) {
					stm.close();
				}
				if(cn !=null) {
					cn.close();
				}
			}catch (Exception e2) {
				System.out.println("......");
				e2.printStackTrace();
			}
	}
}

	public void actulizar() {
		Scanner entrada=new Scanner(System.in);
		
		Connection cn=null;
		Conexion conexion =new Conexion();
		Statement stm=null;
		
		
		System.out.println("ingrese la contraseņa de la persona a modificar");
		String contraseņa=entrada.next();
		
		entrada.nextLine();
		
		System.out.println("ingrese elnuevo nombre");
		String nombre=entrada.next();
		
		System.out.println("ingrese nuevo correo");
		String correo=entrada.next();
		
		try {
			cn=conexion.Conectar();
			stm=cn.createStatement();
			int valor=stm.executeUpdate("update administrador set nombre='"+nombre+"',correo='"+correo+"' Where contraseņa="+contraseņa);			
			if(valor==1) {
				System.out.println("datos de la pesona actualizados");
				
			}else {
				System.out.println("usuario no encontrado");
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(stm!=null) {
					stm.close();
				}
				if(cn!=null) {
					cn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public void eliminar() {
		Scanner entrada=new Scanner(System.in);
		
		Connection cn=null;
		Conexion conexion=new Conexion();
		Statement stm=null;
		
		System.out.println("ingrese la contraseņa de la persona aborrar del sistema");
		String contraseņa=entrada.next();
		
		try {
			cn=conexion.Conectar();
			stm=cn.createStatement();
			int valor=stm.executeUpdate("delete from administrador where contraseņa='"+contraseņa+"'");
			
			if(valor==1) {
				System.out.println("borrado exitosa mente");
			}else {
				System.out.println("error al eliminar usuario ");
			}
			
		} catch (Exception e) {
			System.out.println("el sistema arrojo un error");
			e.printStackTrace();
		}
		finally {
			try {
				if(cn!=null) {
					cn.close();
				}
				if(stm!=null) {
					stm.close();
					
				}
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}

