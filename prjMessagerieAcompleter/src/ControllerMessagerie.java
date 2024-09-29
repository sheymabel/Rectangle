
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
public class ControllerMessagerie implements ActionListener{
    frmEnvoyer f;
    BoiteMessagerie bt;
    ControllerMessagerie (frmEnvoyer frm)
    {
    	f=frm;
    }
    ControllerMessagerie (BoiteMessagerie b)
    {bt=b;
    	
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		String emetteur = f.txtEmetteur.getText();
        String destinataire = f.txtDestM.getText();
        String objet = f.txtObj.getText();
        String texte = f.txtTexteM.getText();

        Message nouveauMessage = new Message(objet, emetteur, texte);
        nouveauMessage.addDestinataires(destinataire);

        SystemMessagerie.envoyerMessage(nouveauMessage);

        JOptionPane.showMessageDialog(f, "Message envoyé avec succès !");

        f.txtDestM.setText("");
        f.txtObj.setText("");
        f.txtTexteM.setText("");
    }
	public static void main(String[] args) {
		SystemMessagerie.CreerCompte("aaa@messagerie.com");
		SystemMessagerie.CreerCompte("bbb@messagerie.com");
		SystemMessagerie.CreerCompte("ccc@messagerie.com");
	//ouvrir les bo�tes de messagerie
		FrmBoite b1 = new FrmBoite( "aaa@messagerie.com");
		FrmBoite b2 = new FrmBoite( "bbb@messagerie.com");
		FrmBoite b3 = new FrmBoite( "ccc@messagerie.com");
		FrmBoite b4 = new FrmBoite( "aaa@messagerie.com");

	}

}
