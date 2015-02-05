import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.skype.ContactList;
import com.skype.Friend;
import com.skype.Skype;
import com.skype.SkypeException;

public class Spam extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public void spam(String friend, String am, String msg) throws SkypeException, InterruptedException{
		ContactList contacts = Skype.getContactList();
		Friend fr = contacts.getFriend(friend);
		int amm = Integer.parseInt(am);
		for(int i = 0; i < amm; i++) {
			fr.send(msg);
		}
	}
	
	public Spam(String title) {
		super(title);
		
		final JTextField msg = new JTextField();
		msg.setText("message to spam...");
		msg.setToolTipText("Enter the message you wanna spam");
		final JTextField am = new JTextField();
		am.setText("how many times to spam...");
		am.setToolTipText("Enter how many times you wanna spam the message");
		final JTextField who = new JTextField();
		who.setText("who to spam...");
		who.setToolTipText("Enter the exact skype name of who you wanna spam");
		final JButton button = new JButton("Spam!");
		
        JPanel buttonPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4,4));
        buttonPanel.add(msg);
        buttonPanel.add(am);
        buttonPanel.add(who);
        buttonPanel.add(button);
        buttonPanel.setPreferredSize(new Dimension(650, 250));
        containerPanel.add(buttonPanel);
        getContentPane().add(containerPanel);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msgg = msg.getText();
				String amm = am.getText();
				String whoo = who.getText();
				if(msg.getText().isEmpty()) {
					msg.setText("You need to enter the message you wanna spam");
				}
				if(am.getText().isEmpty()) {
					am.setText("You need to enter how many times you wanna spam the message");
				}
				if(who.getText().isEmpty()) {
					who.setText("You need to enter the exact skype name of who you wanna spam");
				} else {
				try {
					spam(whoo, amm, msgg);
				} catch (SkypeException | InterruptedException e1) {
					e1.printStackTrace();
				}
				}
			}
		});
	}
}
