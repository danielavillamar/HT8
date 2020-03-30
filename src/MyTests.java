// DANIELA VILLAMAR
// 19086

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import org.hamcrest.Matcher;
import org.junit.jupiter.api.Test;

public class MyTests {

    @Test
    public void VectorHeapTester() {
    	//Prueba del vector heap y clase patient
    	VectorHeap<Patient> Patients = new VectorHeap<Patient>();
    	//Creacion de pacientes
    	Patient patientA = new Patient("Jorge","Apendicitis","A");
    	Patient patientB = new Patient("Andres","Operacion","B");
    	Patient patientC = new Patient("Gustavo","Zika","C");
    	Patient patientCC = new Patient("Jose","VIH","C");
    	Patient patientD = new Patient("Estuardo","Intoxicacion","D");
    	Patient patientE = new Patient("Antonio","Gripe","E");
    	//Prueba Junit
    	assertEquals(true,Patients.isEmpty(), "Respuesta true esta vacio");
    	//Añadir pacientes a vectorheap en desorden
    	Patients.add(patientC);
    	Patients.add(patientD);
    	Patients.add(patientA);
    	Patients.add(patientCC);
    	Patients.add(patientB);
    	Patients.add(patientE);
    	
    	
    }

	
}
