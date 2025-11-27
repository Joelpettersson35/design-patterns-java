package view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.nio.file.Path;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.Controller;

public class GUIView implements View {

	Controller controller;
	
	private JFrame frame;
	private JTextArea textArea;
	private JMenuBar menuBar;
	private JMenu fileTab;
	private JMenu editTab;
	private JMenuItem open;
	private JMenuItem newFile;
	private JMenuItem save;
	private JMenuItem saveAs;
	private JMenuItem cut;
	private JMenuItem copy;
	private JMenuItem paste;

	
	public GUIView() {
		
	}
	
	public void runUI() {
		frame = new JFrame("New text document");
		textArea = new JTextArea();
		menuBar = new JMenuBar();
		fileTab = new JMenu("File");
		editTab = new JMenu("Edit");
		open = new JMenuItem("Open");
		newFile = new JMenuItem("New File");
		save = new JMenuItem("Save");
		saveAs = new JMenuItem("Save As");
		cut = new JMenuItem("Cut");
		copy = new JMenuItem("Copy");
		paste = new JMenuItem("Paste");
		
		open.addActionListener(e -> controller.handleEvent(3));
		newFile.addActionListener(e -> controller.handleEvent(4));
		save.addActionListener(e -> controller.handleEvent(6));
		saveAs.addActionListener(e -> controller.handleEvent(7));
		cut.addActionListener(e -> controller.handleEvent(8));
		copy.addActionListener(e -> controller.handleEvent(9));
		paste.addActionListener(e -> controller.handleEvent(10));
		
		fileTab.add(open);
		fileTab.add(newFile);
		fileTab.add(save);
		fileTab.add(saveAs);
		menuBar.add(fileTab);
		
		editTab.add(cut);
		editTab.add(copy);
		editTab.add(paste);
		menuBar.add(editTab);
		
		frame.setSize(400, 500);
		textArea.setBounds(10, 10, 365, 400);
		textArea.setLineWrap(true);
		textArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowAdapter() {
		    @Override
		    public void windowClosing(WindowEvent e) {
		        controller.handleEvent(2);
		    }
		});

		
		textArea.getDocument().addDocumentListener(new DocumentListener() {
		    @Override
		    public void insertUpdate(DocumentEvent e) {
		        controller.handleEvent(5);
		    }

		    @Override
		    public void removeUpdate(DocumentEvent e) {
		    	controller.handleEvent(5);
		    }

			@Override
			public void changedUpdate(DocumentEvent e) {}
		});


		frame.setJMenuBar(menuBar);
		frame.add(textArea);
		frame.setVisible(true);
	}
	
	public Path askForOpenDir() {
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("Text files only", "txt");
		chooser.setFileFilter(filter);
		chooser.setAcceptAllFileFilterUsed(false);
		int returnVal = chooser.showOpenDialog(frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			System.out.println(chooser.getSelectedFile());
			File file = chooser.getSelectedFile();
			return file.toPath();
		}
		return null;
	}
	
	public Path askForSaveDir() {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showSaveDialog(frame);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			File file = chooser.getSelectedFile();
			return file.toPath();
			
			}
		return null;
	}
	
	public boolean askToSave() {
		String[] options = { "Save", "Don't Save" };
		int choice = JOptionPane.showOptionDialog(
				frame, 
				"Do you want to save? Unsaved changes will get lost",
				"Unsaved changes", 
				JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE, 
				null, 
				options, 
				options[0]);
		
		if(choice == 0) {
			return true;
		}
		
		return false;
	}
	
	public void displayText(String text) {
		textArea.setText(text);
	}
	
	public String getText() {
		return textArea.getText();
	}
	
	public void newFile() {
		textArea.setText("");
	}
	
	public void cutSelectedText() {
		textArea.cut();
	}
	
	public void copyText() {
		textArea.copy();
	}
	
	public void pasteText() {
		textArea.paste();
	}
	
	public void showErrorMsg(String msg) {
		JOptionPane.showMessageDialog(frame, msg, "Error", JOptionPane.OK_OPTION);
	}
	
	public void updateHeader(String name) {
		frame.setTitle(name);
	}

	@Override
	public void setController(Controller c) {
		controller = c;
		
	}
}
