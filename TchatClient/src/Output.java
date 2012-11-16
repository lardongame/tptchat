
/**
 * @author Xenos
 *
 * Gère l'affichage en sortie des données
 */
public class Output
{
	/**
	 * Instance singleton
	 */
	private static Output instance;
	
	/**
	 * Singleton
	 */
	private Output()
	{
	}
	
	/**
	 * Récupère l'instance output
	 * @return L'instance output
	 */
	public static Output get()
	{
		if (Output.instance == null)
			Output.instance = new Output();
		return (Output.instance);
	}
	
	/**
	 * Indente un texte d'une tabulation et le renvoie
	 * @param text	Texte à indenter
	 * @return	Le texte indenté
	 */
	private String tabText(String text)
	{
		return ("\t" + text.replace("\n", "\n\t"));
	}

	/**
	 * @param titre	Titre de l'erreur
	 * @param text	Contenu du message d'erreur
	 */
	public static void error(String titre, String text)
	{
		System.out.println(" **** ERROR: " + titre + " **** ");
		System.out.println(Output.get().tabText(text));
	}
	
	/**
	 * Renvoie une alerte dans la console
	 * @param text		Message d'alerte
	 */
	public static void warning(String text)
	{
		System.out.println(" /!\\ WARNING /!\\ ");
		System.out.println(Output.get().tabText(text));
	}
	
	/**
	 * Renvoie un message de type déboggage
	 * @param text	Message developpeur à afficher
	 */
	public static void verbose(String text)
	{
		System.out.println(Output.get().tabText(text));
	}
}
