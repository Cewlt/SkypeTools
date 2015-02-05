import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import com.skype.ContactList;
import com.skype.Friend;
import com.skype.Skype;
import com.skype.SkypeException;

public class Mass extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Panel panel;
	
	StringWriter sw = new StringWriter();
	
	public void mass(String msg) throws SkypeException, InterruptedException{
		ContactList contacts = Skype.getContactList();
		Friend friends[] = contacts.getAllFriends();
	    for(int i=0; i < friends.length; i++) {
	       Friend u = friends[i];
	       u.chat().send(msg);
	    }
	}
	
	public Mass(String title) {
		super(title);
		
		setLayout(new BorderLayout());
		
		final JTextArea text = new JTextArea();
		final JButton button = new JButton("Send!");
		
		Container c = getContentPane();
		
		panel = new Panel();
		
		c.add(text, BorderLayout.CENTER);
		c.add(button, BorderLayout.SOUTH);
		c.add(panel, BorderLayout.WEST);
		
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String msg = text.getText();
				if(text.getText().isEmpty()) {
					text.append("\nYou gotta enter a message..");
				} else {
				try {
					mass(msg);
				} catch (SkypeException | InterruptedException e1) {
					e1.printStackTrace(new PrintWriter(sw));
					String error = sw.toString();
					text.setText("[ERROR]: " + error);
				}
				text.append("\nSent.");
			}
			}
		});
	}
}
