
/**
 * @author Xenos
 * Un gens...
 */
public class Causeur {

	private String id;
	
	/**
	 * Cr�e un nouveau causeur qui se connecte, avec son identifiant
	 * @param id
	 */
	Causeur(String id){
		this.id = id;
	}
	
	/**
	 * R�cup�re le nom du causeur
	 * @return
	 */
	String getName(){
		return this.id;
	}
	
}
