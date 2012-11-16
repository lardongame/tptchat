import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author Xenos
 * La salle de chat
 */
public interface Room extends java.rmi.Remote
{
	/**
	 * Renvoie la liste des nom des clients connectés à cette salle
	 * @return		Tableau des nom des clients
	 * @throws RemoteException
	 */
	public String[] getClientsName()
			throws java.rmi.RemoteException;
	
	/**
	 * Connecte un causeur (client) à cette salle
	 * @param client	Le client à connecter
	 * @throws RemoteException		En cas de soucis réseau
	 * @throws RoomException 		En cas de soucis lors de l'entrée dans la salle (pseudo déjà pris par ex)
	 */
	public void enters(Causeur client)
			throws java.rmi.RemoteException, RoomException;

	/**
	 * Déconnecte un client de la salle
	 * @param client				Le client à déconnecter
	 * @throws RemoteException		En cas d'erreur réseau
	 * @throws RoomException		EN cas d'erreur avec la salle
	 */
	public void exits(Causeur client)
			throws java.rmi.RemoteException, RoomException;
	
	/**
	 * Renvoie tout ce qui a été dit dans cette salle depuis le début
	 * @return		Tout ce qui a été dit
	 * @throws RemoteException		EN cas de soucis réseau
	 * @throws RoomException		En cas de soucis de salle
	 */
	public Phrases[] getAll()
			throws java.rmi.RemoteException, RoomException;
	
	/**
	 * Renvoie ce qui a été dit depuis la date donnée, incluse
	 * @param dateDepuis	Date à partir de laquelle on veut récupérer les textes
	 * @return				Les textes à récupérer
	 * @throws RemoteException	En cas de soucis réseau
	 * @throws RoomException	En cas de soucis de salle
	 */
	public Phrases[] getSince(Date dateDepuis)
			throws java.rmi.RemoteException, RoomException;

}