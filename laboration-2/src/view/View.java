package view;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;

public class View {
	
	public View() {
		runUI();
	}
	
	public void runUI() {
		JFrame frame = new JFrame("TextEditor");
		JTextArea textArea = new JTextArea();
		JMenuBar menuBar = new JMenuBar();
		JMenu fileTab = new JMenu("File");
		JMenuItem open = new JMenuItem("Open");
		JMenuItem newFile = new JMenuItem("New File");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem saveAs = new JMenuItem("Save As");
		
		fileTab.add(open);
		fileTab.add(newFile);
		fileTab.add(save);
		fileTab.add(saveAs);
		menuBar.add(fileTab);
		
		frame.setSize(400, 500);
		textArea.setBounds(10, 10, 365, 400);
		textArea.setLineWrap(true);
		textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		frame.setJMenuBar(menuBar);
		frame.add(textArea);
		frame.setVisible(true);
	}
}
