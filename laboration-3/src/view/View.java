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

public interface View {
	
	public void setController(Controller c);
	
	public void runUI();
	
	public boolean askToSave();

	public Path askForSaveDir();

	public String getText();

	public Path askForOpenDir();

	public void displayText(String txt);

	public void updateHeader(String string);

	public void showErrorMsg(String string);

	public void newFile();

	public void cutSelectedText();

	public void copyText();

	public void pasteText();
	
}
