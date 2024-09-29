import java.util.ArrayList;


public class BoiteMessagerie implements Observable{
	String proprietaire;
	ArrayList<Message> messEnvoyes = new ArrayList<Message>();
	ArrayList<Message> messRecus = new ArrayList<Message>();
	public BoiteMessagerie(String p)
	{
		proprietaire = p;
	}
	private ArrayList<Observer> listObserver = new ArrayList<Observer>();   
	public ArrayList<Message> getMessagesRecus()
	{
		return messRecus;
	}
	public ArrayList<Message> getMessagesEnvoyes()
	{
		return messEnvoyes;
	}
	
	public ArrayList<Message> getMessagesNonLus()
	{
		ArrayList<Message> ls = new ArrayList<Message>();
		for (int i=0; i<messRecus.size(); i++)
		{
			if (messRecus.get(i).estLu()==false)
				ls.add(messRecus.get(i));
		}
		return ls;
	}
	@Override
	public void addObserver(Observer o) {
        listObserver.add(o);
		
		
	}
	@Override
	public void notifyObservers(Object ob) {
		for (Observer o : listObserver) {
            o.update(this, ob);
        }		
	}
	@Override
	public void removeObservers() {
        listObserver.clear();

		
	}
	public boolean equals (Object o)
	{
		BoiteMessagerie b= (BoiteMessagerie)o;
		
		return (b.proprietaire.equals(proprietaire));
	}
	public String getProprietaire()
	{
		return proprietaire;
	}
	public void Envoyer(Message m)
	{
		  messEnvoyes.add(m);
	        notifyObservers(m);
	        }
	public void recevoir (Message m)
	{
		 messRecus.add(m);
        notifyObservers(m);
	}
	public String toString ()
	{return "Boite de messagerie de" + proprietaire;}

}
