

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class FrmBoite extends JFrame implements Observer {
	String proprietaire;
	
	JTable tpenvoi, tpreception;
	JPanel p1, p2, p3, pcenter;
	JButton bt1;
	BoiteMessagerie b;
	public FrmBoite(String p)
	{   
		super("Bo�te de messagerie de " + p);
		proprietaire =p;
		b= SystemMessagerie.getBoite(proprietaire);
		
		p1= new JPanel( );
		p1.setLayout(new BoxLayout (p1, BoxLayout.LINE_AXIS));
		JPanel pt1 = new JPanel (new BorderLayout());
		JPanel pt2 = new JPanel (new BorderLayout());
		pt1.add(new JLabel ("Messages re�us"), BorderLayout.NORTH);
		p2 = new JPanel();
		pt2.add(new JLabel ("Messages envoy�s"), BorderLayout.NORTH);
		p2.setLayout(new BoxLayout (p2, BoxLayout.LINE_AXIS));
		p3 = new JPanel();
		p3.setLayout(new BoxLayout (p3, BoxLayout.LINE_AXIS));
		bt1=new JButton ("Ecrire un message");
		p3.add(bt1);
		bt1.addActionListener(new ControllerMessagerie(b));
		pcenter= new JPanel();
		pcenter.setLayout(new BoxLayout (pcenter, BoxLayout.PAGE_AXIS));
		RemplirMessagesEnvoyes(b);
        JScrollPane ps2= new JScrollPane(tpenvoi);
        pt2.add(ps2, BorderLayout.CENTER);
        p2.add(pt2);
        RemplirMessagesRecus(b);
        
        JScrollPane ps1= new JScrollPane(tpreception);
        pt1.add(ps1, BorderLayout.CENTER);
        p1.add(pt1);
        pcenter.add(p1);
		pcenter.add(p2);
		pcenter.add(p3);
		getContentPane().add(pcenter, BorderLayout.CENTER);
        this.setSize(new Dimension(400,400));
        double h1 = Math.random()*1000;
        double w1 = (int)Math.random()*1000;
        this.setLocation((int)h1, (int)w1 );
        this.setVisible(true);   
		b.addObserver(this);
		
	}
	public void RemplirMessagesRecus(BoiteMessagerie b) {
		String col[] = { "Emetteur", "Objet", "Texte"};
		
		b= SystemMessagerie.getBoite(proprietaire);
		ArrayList<Message>ls=b.getMessagesRecus();
		String[][]cont = new String[ls.size()][3];
		Message m;
		for (int i=0; i<ls.size(); i++)
		{
			
			m= ls.get(i);
			cont[i][0]=m.getEmetteur();
			cont[i][1]=m.getObjetMessage();
			if (m.getTexteMessage().length()>20)
				cont[i][2]=m.getTexteMessage().substring(0,20) + "...";
			else
				cont[i][2]=m.getTexteMessage();
			
		}
		tpreception = new JTable (new DefaultTableModel(cont, col));
		
       
	}
	
	public void RemplirMessagesEnvoyes(BoiteMessagerie b) {
		String col[] = { "Destinataire(s)", "Objet", "Texte"};
		
		
		ArrayList<Message>ls=b.getMessagesEnvoyes();
		String[][]cont = new String[ls.size()][3];
		Message m;
		for (int i=0; i<ls.size(); i++)
		{
			m= ls.get(i);
			cont[i][0]=m.getEmetteur();
			cont[i][1]=m.getObjetMessage();
			if (m.getTexteMessage().length()>20)
			cont[i][2]=m.getTexteMessage().substring(0,20) + "...";
			else
				cont[i][2]=m.getTexteMessage();
			
		}
		tpenvoi = new JTable (new DefaultTableModel(cont, col));
        tpenvoi.setPreferredSize(new Dimension (600, 250));
        tpenvoi.setMinimumSize(new Dimension (600, 250));
       
	}
	@Override
	public void update(Observable arg0, Object arg1) {
		 if (b instanceof BoiteMessagerie && arg0 instanceof Message) {
		        Message newMessage = (Message) arg1;
		        if (newMessage.getDestinataires().contains(proprietaire)) {
		            DefaultTableModel model = (DefaultTableModel) tpreception.getModel();
		            model.addRow(new Object[]{newMessage.getEmetteur(), newMessage.getObjetMessage(), newMessage.getTexteMessage()});
		        }
		 }
	
}
}

