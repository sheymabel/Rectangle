

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class SystemMessagerie {
	
	private static HashSet<BoiteMessagerie> lstBoites= new HashSet<BoiteMessagerie>();
	
	public static void CreerCompte(String p)
	{	BoiteMessagerie b= new BoiteMessagerie(p);
		lstBoites.add(b);
		Message m= new Message("Bienvenue", "Admin@messagerie.com", "Bienvenue dans notre syst�me de messagerie");
		m.addDestinataire(p);
		envoyerMessage(m);
	}
	public static void envoyerMessage (Message m)
	{	
		String emetteur = m.getEmetteur();
		ArrayList<String> dest = m.getDestinataires();
		
		String d;
		BoiteMessagerie b1=getBoite(emetteur);
		BoiteMessagerie bdest;
		if (b1!=null)
			b1.Envoyer(m);
		for (int i=0; i<dest.size(); i++)
		{
			d=dest.get(i);
			bdest=getBoite(d);
			if (bdest!=null)
				bdest.recevoir(m);
		}
		
	}
	
	public static BoiteMessagerie getBoite (String proprietaire)
	{	BoiteMessagerie bt= null;
		Iterator<BoiteMessagerie> it = lstBoites.iterator(); 
		while (it.hasNext())
		{
			BoiteMessagerie b = it.next();
			if (b.getProprietaire().equals(proprietaire))
				bt=b;
				
		}
		return bt;
	}
}
