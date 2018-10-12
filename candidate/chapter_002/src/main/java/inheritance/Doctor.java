package inheritance;

public class Doctor extends Profession {
	public static int count = 0;
	public Diagnose heal(Patient patient) {
		Diagnose diagnose = new Diagnose();
		if(count % 2 != 0) {
			diagnose.setDiagnose("Вам поможет только чудо");
		} else {
			diagnose.setDiagnose("Поздравляю вы здоровы");
		}
		return diagnose;
	}
}