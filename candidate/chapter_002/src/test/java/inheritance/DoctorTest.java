package inheritance;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class DoctorTest {
    @Test
    public void healTest() {
        Doctor doctor = new Doctor();
        Patient patient = new Patient("Петя");
        Diagnose result = doctor.heal(patient);
        Diagnose diagnose = new Diagnose();
        diagnose.setDiagnose("Вам поможет только чудо");
        assertThat(result.getDiagnose(), is(diagnose.getDiagnose()));
    }
}
