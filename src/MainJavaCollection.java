// DANIELA VILLAMAR
// 19086

// CLASE MAIN EN JAVA COLLECTION

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.stream.Stream;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MainJavaCollection {

	public static void main(String[] args){

		//Scanner 
		Scanner s = new Scanner(System.in);
		//Variable que valida lo ingresado por el usuario
		Boolean validado = false;
		//Variable 	que almacena la opcion del menu seleccionada
		int menu = 0;
		
		//Bienvenida al programa 
		System.out.println("Bienvenidos al programa del Hospital para atención de Pacientes utilizando Java Collections.");
		 PriorityQueue<Patient> Patients =  new PriorityQueue<Patient>(); 
		
		//Se lee el archivo txt con las palabras traducidas que tendra el diccionario
		boolean errorOnFile=false;
		String fileDirectory;
		
		do {	
			System.out.println("Ingresa la direccion de pacientes para ser atendidos: ");
			fileDirectory = s.nextLine();
			try {
				//Se lee el archivo
				 Scanner scann = new Scanner(new File(fileDirectory));
				 String line = "";
				 	//Se recorre la linea del archivo txt
					while (scann.hasNextLine()) {
						//En cada linea se encuentra un paciente con sus datos
						line = scann.nextLine();
						String name;
						String symptom;
						String emergencyCode;
						Patient newPatient;
						//Se hace un arreglo de strings
						String[] text = line.split(",");
						//Se obtienen los datos del paciente. Se crea como paciente y luego se inserta al VectorHeap.
						name= text[0];
						symptom= text[1];
						emergencyCode= text[2].toUpperCase();
						
						newPatient= new Patient(name,symptom,emergencyCode);
						Patients.add(newPatient);
					}
					
				errorOnFile=false;
			} catch (Exception e) {
				//Verifica que la direccion sea valida
				System.out.println("Error en los datos ingresados");
				System.out.println("Por favor, verifica la dirección del archivo ingresado sea correcta");
				errorOnFile=true;
			
			}
		}while(errorOnFile);
		
		
		
		//Se muestra el menu	
		do {
			System.out.println("Ingresa el número de una opcion del menu:\n1.Doctor atiende al siguiente paciente por prioridad.\n2.Mostrar al siguiente paciente que debe ser atendido \n3.Salir del programa");
			do{
				//Se setea validado falso
				validado = false;
				String menuStr = s.nextLine();
				try {
					menu = Integer.parseInt(menuStr);
					if((menu>=1)&&(menu<=3)) {
						validado = true;
					}else {
						System.out.println("Ingrese una opción correcta");
						validado = false;
					}
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("Ingrese una opción correcta");
					validado = false;
				}
			}while(validado==false);
					
			//Funcion 1 se atiende al siguiente paciente
			if(menu==1) {
				Patient patientAttended;
				if(!Patients.isEmpty()) {
					patientAttended = Patients.remove();
					System.out.println("El doctor ha atendido al paciente : ");
					System.out.println("\t Nombre: "+patientAttended.getName());
					System.out.println("\t Enfermedad: "+patientAttended.getSymptom());
					System.out.println("\t Nombre: "+patientAttended.getPatientPriority());
				}else {
					System.out.println("Todos los pacientes han sido atendidos!");
				}
			}
			
			//Funcion 2
			//Se muestra al siguiente paciente en ser atendido pero no se atiende.
			if(menu==2) {
				Patient nextPatient;
				if(!Patients.isEmpty()) {
					nextPatient = Patients.peek();
					System.out.println("El siguiente paciente para atender es : ");
					System.out.println("\t Nombre: "+nextPatient.getName());
					System.out.println("\t Enfermedad: "+nextPatient.getSymptom());
					System.out.println("\t Nombre: "+nextPatient.getPatientPriority());
				}else {
					System.out.println("Todos los pacientes han sido atendidos.");
				}
				
			}
			//Sale del menu
		} while (menu!=3);
		System.out.println("Gracias por utilizar el programa de atención de Pacientes.");
	}
}
