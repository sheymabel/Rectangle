

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class frmEnvoyer extends JFrame {
	BoiteMessagerie bt;
	JTextField txtObj, txtEmetteur;
	JTextArea txtTexteM;
	JTextArea txtDestM;
	JButton btEnvoyer;
	
	public frmEnvoyer (BoiteMessagerie b)
	{   super ("Envoyer message");
		bt=b;
		JPanel p= new JPanel (new GridLayout(0,2));
		p.add(new JLabel("Emetteur"));
		txtEmetteur = new JTextField(b.getProprietaire());
		p.add(txtEmetteur);
		p.add(new JLabel("Destinataire"));
		txtDestM = new JTextArea();
		p.add(txtDestM);
		p.add(new JLabel("Objet message"));
		txtObj = new JTextField();
		p.add(txtObj);
		p.add(new JLabel("Texte message"));
		txtTexteM = new JTextArea("�crire votre message");
		p.add(txtTexteM);
		btEnvoyer = new JButton("Envoyer");
		p.add(btEnvoyer);
		btEnvoyer.addActionListener(new ControllerMessagerie(this));
		getContentPane().add(p);
		this.setSize(new Dimension(400,500));
        this.setVisible(true);
	}
	

}
