package negocio;

public class PersonaABM {
private static PersonaABM instancia = null; // Patrón Singleton
	
	protected PersonaABM() {
	}
	
	public static PersonaABM getInstance() {
		if (instancia == null)
		instancia = new PersonaABM();
		return instancia;
	}
	
}
