
/**
 * @author Xenos
 *
 * G�re l'affichage en sortie des donn�es
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
	 * R�cup�re l'instance output
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
	 * @param text	Texte � indenter
	 * @return	Le texte indent�
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
	 * Renvoie un message de type d�boggage
	 * @param text	Message developpeur � afficher
	 */
	public static void verbose(String text)
	{
		System.out.println(Output.get().tabText(text));
	}
}
