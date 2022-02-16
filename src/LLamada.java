import java.util.Scanner;

public class LLamada {
	
	public LLamada() {
		
	}

	public static void main(String[] args) {
		Logica_Mysql logica=new Logica_Mysql();
		Scanner entrada=new Scanner(System.in);
		
		int  opcion=0;
		
		do {
			System.out.println("1 para listar");
			System.out.println("2 para insertar datos");
			System.out.println("3 para buscar datos");
			System.out.println("4 para actualizar datos");
			System.out.println("5 para eliminar datos");
			System.out.println("6 para salir del sistema");
			System.out.println();
			System.out.print("ingresar opcion: ");
			opcion=entrada.nextInt();
			
			switch (opcion) {
				case 1: {
					logica.listar();
					break;
			    }
				case 2:{
					logica.insertar();
					break;
				}
				case 3:{
					logica.buscar();
					break;
				}
				case 4:{
					logica.actulizar();
					break;
				}
				case 5:{
					logica.eliminar();
					break;
				}
				
				
				
				
			}
		} while (opcion<6);
		
	}

}
