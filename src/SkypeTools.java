import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class SkypeTools {
	
	public static JFrame frame1 = new JFrame("Pick one..");
	public static JFrame frame2 = new Spam("Spammah");
	public static JFrame frame3 = new Mass("Mass Messenger");
	
	public static void main(String[] args) {
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel buttonPanel = new JPanel();
        JPanel containerPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2,2));
        JButton b11 = new JButton("Spammer");
        JButton b22 = new JButton("Mass Messenger");
        buttonPanel.add(b11);
        buttonPanel.add(b22);
        buttonPanel.setPreferredSize(new Dimension(300, 100));
        containerPanel.add(buttonPanel);     

        frame1.getContentPane().add(containerPanel);
        frame1.pack();
        frame1.setVisible(true);
        frame2.setVisible(false);
        frame3.setVisible(false);
        
		b11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				frame2.setSize(700, 300);
				frame2.setLocationRelativeTo(null);
				frame2.setVisible(true);
			}
		});
        
		b22.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame1.setVisible(false);
				frame3.setSize(700, 300);
				frame3.setLocationRelativeTo(null);
				frame3.setVisible(true);
			}
		});
	}
}
