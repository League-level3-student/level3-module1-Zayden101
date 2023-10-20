/*


package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
	 */

/*
	HashMap<Integer, String> log = new HashMap<Integer, String>();
	JFrame frame;
	JPanel panel;
	JButton button1;
	JButton button2;
	JButton button3;
	JButton button4;
	String userIDInput;
	String nameInput;
	int IDInput;
	String searchIDInput;
	int searchID;
	String searchName;

	_02_LogSearch() {

	}

	public static void main(String[] args) {
		_02_LogSearch logSearch = new _02_LogSearch();
		logSearch.gui();
	}

	void gui() {
		frame = new JFrame();
		panel = new JPanel();
		button1 = new JButton();
		button2 = new JButton();
		button3 = new JButton();
		button4 = new JButton();
		button1.setText("Add an Entry");
		button2.setText("Search by ID");
		button3.setText("View List");
		button4.setText("Remove an Entry");
		button1.addActionListener(this);
		button2.addActionListener(this);
		button3.addActionListener(this);
		button4.addActionListener(this);
		frame.add(panel);
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		frame.setVisible(true);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().equals(button1)) {
			userIDInput = JOptionPane.showInputDialog("Enter the ID Number");
			nameInput = JOptionPane.showInputDialog("Enter the Name corresponding to the ID just entered");
			IDInput = Integer.parseInt(userIDInput);
			log.put(IDInput, nameInput);
		} else if (e.getSource().equals(button2)) {
			searchIDInput = JOptionPane.showInputDialog("Enter the ID to search for");
			searchID = Integer.parseInt(searchIDInput);
			if (log.containsKey(searchID) == true) {
				searchName = log.get(searchID);
				JOptionPane.showMessageDialog(null, "The name at the ID " + searchID + " is " + searchName);
			} else {
				JOptionPane.showMessageDialog(null,
						"There are no matchings for the ID " + searchID + " in the database");
			}

		} else if (e.getSource().equals(button3)) {
			String printText = "";
			for(Integer i : log.keySet()) {
				printText = printText +  "ID: " + i + " Name: " + log.get(i) + "\n";
			}
			JOptionPane.showMessageDialog(null, printText);
		}else if(e.getSource().equals(button4)) {
			String input;
			int remove;
			String a;
			input = JOptionPane.showInputDialog("Enter the ID of the entry you want to remove");
			remove = Integer.parseInt(input);
			if(log.containsKey(remove) == true) {
				a = log.remove(remove);
			}else {
				JOptionPane.showMessageDialog(null, "The ID does not exist in the list.");
			}
		}
	}
}


*/