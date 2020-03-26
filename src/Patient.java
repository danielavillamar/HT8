// DANIELA VILLAMAR
// 19086

// CLASE PACIENTE 
// se usa tanto para vectorheap y javacollection
public class Patient implements Comparable<Patient>{

	private String name;
	private String symptom;
	private String emergencyCode;
	
	public Patient() {
		// TODO Auto-generated constructor stub
		name = "";
		symptom = "";
		emergencyCode = "";
	}

	/**
	 * name = nombre del paciente
	 * symptom = sintoma del paciente
	 * emergencyCode = prioridad
	 */
	public Patient(String name, String symptom, String emergencyCode) {
		super();
		this.name = name;
		this.symptom = symptom;
		this.emergencyCode = emergencyCode;
	}

	/**
	 * return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name de name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * return symptom
	 */
	public String getSymptom() {
		return symptom;
	}

	/**
	 * symptom de symptom to set
	 */
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}

	/**
	 * return el emergencyCode
	 */
	public String getEmergencyCode() {
		return emergencyCode;
	}

	/**
	 * emergencyCode de emergencyCode to set
	 */
	public void setEmergencyCode(String emergencyCode) {
		this.emergencyCode = emergencyCode;
	}

	public String getPatientPriority() {
		
		
		return this.getEmergencyCode();
	}
	
	@Override
	public int compareTo(Patient o) {
		// TODO Auto-generated method stub
		int result = this.getEmergencyCode().compareTo(o.getEmergencyCode());
		
		return result;
	}

	

	
