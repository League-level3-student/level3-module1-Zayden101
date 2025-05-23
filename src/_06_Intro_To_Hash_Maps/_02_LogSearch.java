package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	/*
	 * Crate a HashMap of Integers for the keys and Strings for the values. Create a
	 * GUI with three buttons. Button 1: Add Entry When this button is clicked, use
	 * an input dialog to ask the user to enter an ID number. After an ID is
	 * entered, use another input dialog to ask the user to enter a name. Add this
	 * information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID When this button is clicked, use an input dialog to
	 * ask the user to enter an ID number. If that ID exists, display that name to
	 * the user. Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List When this button is clicked, display the entire list in a
	 * message dialog in the following format: ID: 123 Name: Harry Howard ID: 245
	 * Name: Polly Powers ID: 433 Name: Oliver Ortega etc...
	 * 
	 * When this is complete, add a fourth button to your window. Button 4: Remove
	 * Entry When this button is clicked, prompt the user to enter an ID using an
	 * input dialog. If this ID exists in the HashMap, remove it. Otherwise, notify
	 * the user that the ID is not in the list.
	 *
	 */

	HashMap<Integer, String> log = new HashMap<Integer, String>();

	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton button1 = new JButton();
	JButton button2 = new JButton();
	JButton button3 = new JButton();

	public static void main(String[] args) {

		new _02_LogSearch().run();

	}

	private void run() {

		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);

		button1.setText("add");
		button2.setText("search");
		button3.setText("view");

		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);

		frame.pack();

		frame.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();

		if (buttonPressed == button1) {
			String id = JOptionPane.showInputDialog("Enter New ID");
			int ids = Integer.parseInt(id);
			String name = JOptionPane.showInputDialog("Enter Name");
			log.put(ids, name);

		}
		
		if (buttonPressed == button2) {
			String search = JOptionPane.showInputDialog("Enter an ID number");
			int searchint = Integer.parseInt(search);
			log.containsKey(searchint);
			if(log.containsKey(searchint)==true) {
				JOptionPane.showMessageDialog(null, log.get(searchint));
			}else {
				JOptionPane.showMessageDialog(null, "This entry does not exist");
			}
		}
		
		if (buttonPressed == button3) {
			String message = "";
			for(Entry<Integer, String> entry : log.entrySet()) {
				message += "ID: " + entry.getKey() + " Name:" + entry.getValue() + "\n";
			}
			JOptionPane.showMessageDialog(null, message);

		}


	}

}
