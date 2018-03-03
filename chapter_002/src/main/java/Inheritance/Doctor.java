package Inheritance;

public class Doctor extends Profession {
	// Лечим пациента, в качестве аргумента функции выступает объект класса Patient
	// В качестве возвращаемого значение  - объект класса Patient.
	public Patient Cure(Patient patient) {
		patient.name = patient.name + " вылечен";
		return patient;
	}
}