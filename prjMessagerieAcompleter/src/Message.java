
import java.util.ArrayList;
import java.util.Date;
public class Message {
	private String objetMessage;
	private Date dateEnvoi;
	private String emetteur;
	private ArrayList<String> destinataires = new ArrayList<String>();
	private String texteMessage;
	private String stat="Non lu";
	public Message (String obj, String em, String texte)
	{
	objetMessage = obj;
	dateEnvoi = new Date();
	emetteur = em;
	texteMessage = texte;
	
	}
	public void addDestinataire(String adresse)
	{
	destinataires.add(adresse);
	}
	public void addDestinataires(String adrs)
	{   
		String[]ad = adrs.split(";");
		
		for (int i=0; i<ad.length;i++)
			destinataires.add(ad[i]);
		
		
	}
	public void lireMessage()
	{
		stat ="Lu";
	}
	
	public boolean estLu()
	{
		return stat.contentEquals("Lu");
	}
	
	public String getObjetMessage() {
	return objetMessage;
	}
	public void setObjetMessage(String objetMessage) {
	this.objetMessage = objetMessage;
	}
	public Date getDateEnvoi() {
	return dateEnvoi;
	}
	public String getEmetteur() {
	return emetteur;
	}
	public void setEmetteur(String emetteur) {
	this.emetteur = emetteur;
	}
	public ArrayList<String> getDestinataires() {
		return destinataires;
		}
	public void setDestinataires(ArrayList<String> destinataires) {
		this.destinataires = destinataires;
		}
	public String getTexteMessage() {
		return texteMessage;
		}
	public void setTexteMessage(String texteMessage) {
		this.texteMessage = texteMessage;
		}
	public String toString() {
		
		String s = "Objet : " + objetMessage+ " \n De : " + emetteur + "\n A : ";
		if (destinataires.size()>0)
		{
		for (int i=0; i< destinataires.size()-1; i++)
		s = s + destinataires.get(i) + " ; ";
		s = s + destinataires.get(destinataires.size()-1) + "\n" ;
		}
		s = s + "\n-----------------------------------------------------\n";
		s = s + texteMessage ;
		s = s + "\n-----------------------------------------------------\n\n";
		return s;
		}
	public boolean equals (Object o)
		 {
		 Message m = (Message)o;
		 return (m.emetteur.equals(emetteur) && m.dateEnvoi.equals(dateEnvoi)&&
		m.texteMessage.equals(texteMessage));
		 }


}
