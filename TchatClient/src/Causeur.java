
/**
 * @author Xenos
 * Un gens...
 */
public class Causeur {

	private String id;
	
	/**
	 * Crée un nouveau causeur qui se connecte, avec son identifiant
	 * @param id
	 */
	Causeur(String id){
		this.id = id;
	}
	
	/**
	 * Récupère le nom du causeur
	 * @return
	 */
	String getName(){
		return this.id;
	}
	
}
