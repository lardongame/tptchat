import java.rmi.RemoteException;
import java.util.Date;

/**
 * @author Xenos
 * La salle de chat
 */
public interface Room extends java.rmi.Remote
{
	/**
	 * Renvoie la liste des nom des clients connect�s � cette salle
	 * @return		Tableau des nom des clients
	 * @throws RemoteException
	 */
	public String[] getClientsName()
			throws java.rmi.RemoteException;
	
	/**
	 * Connecte un causeur (client) � cette salle
	 * @param client	Le client � connecter
	 * @throws RemoteException		En cas de soucis r�seau
	 * @throws RoomException 		En cas de soucis lors de l'entr�e dans la salle (pseudo d�j� pris par ex)
	 */
	public void enters(Causeur client)
			throws java.rmi.RemoteException, RoomException;

	/**
	 * D�connecte un client de la salle
	 * @param client				Le client � d�connecter
	 * @throws RemoteException		En cas d'erreur r�seau
	 * @throws RoomException		EN cas d'erreur avec la salle
	 */
	public void exits(Causeur client)
			throws java.rmi.RemoteException, RoomException;
	
	/**
	 * Renvoie tout ce qui a �t� dit dans cette salle depuis le d�but
	 * @return		Tout ce qui a �t� dit
	 * @throws RemoteException		EN cas de soucis r�seau
	 * @throws RoomException		En cas de soucis de salle
	 */
	public Phrases[] getAll()
			throws java.rmi.RemoteException, RoomException;
	
	/**
	 * Renvoie ce qui a �t� dit depuis la date donn�e, incluse
	 * @param dateDepuis	Date � partir de laquelle on veut r�cup�rer les textes
	 * @return				Les textes � r�cup�rer
	 * @throws RemoteException	En cas de soucis r�seau
	 * @throws RoomException	En cas de soucis de salle
	 */
	public Phrases[] getSince(Date dateDepuis)
			throws java.rmi.RemoteException, RoomException;

}