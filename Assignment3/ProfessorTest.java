package Assignment3;

public class ProfessorTest {

	public static void main(String[] args) {
		Professor professor = new Professor.Builder("Charles", "Leclerc", 16).setOfficeRoomNumber(0016)
				.setEmail("CL@Ferrari.Scuderia").build();
		
		System.out.println(professor);
	}
}
