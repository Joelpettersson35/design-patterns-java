package controller;

import java.io.File;
import java.nio.file.Path;

import model.Model;
import view.View;

//this skickar adressen till objektet från minnet
//skillnaden mellan text och rit programmet är att... composite i labb 4
//Creational, Structural och behaviorual...
//Klassrelation (arv)
//objektrelation (agregat och association)
//Adapter = översätter anropsinterface (hårtorken, från existerande interface till nödvändigt interface
//Annan adapter (Object adapter / wrapper) = association till den implementerade klassen
//Facade skapar minimala kontaktytor mellan programdelar/moduler/osv
//Composite = containrar kan innehålla containrar och löv men löv kan bara vara löv
//Chain of responsibilty
//kolla main i checkauthoroty för hur man länkar lista av object, måste dock inte vara länkad lista kan vara composite

public class Controller {
	View view;
	Model model;
	
	public Controller() {
		view = new View(this);
		model = new Model();
	}
	
	public void handleEvent(int event) {
		switch(event) {
		case 1:
			System.out.println("start app");
			view.runUI();
			break;
		case 2:
			System.out.println("exit app");
			if(!model.getIsSaved()) {
				Boolean wantToSave = view.askToSave();
				if(wantToSave) {
					if(model.getFilePath() == null) {
						Path saveLocation = view.askForSaveDir();
						if(saveLocation != null) {
							model.setFilePath(saveLocation);
						}
					}
					model.setText(view.getText());
					model.saveToFile();
				}
			}
			System.exit(0);
			break;
		case 3:
			System.out.println("open file");
			if(!model.getIsSaved()) {
				Boolean wantToSave = view.askToSave();
				if(wantToSave) {
					System.out.println("wanna save");
					if(model.getFilePath() == null) {
						Path saveLocation = view.askForSaveDir();
						if(saveLocation != null) {
							model.setFilePath(saveLocation);
						}
					}
					model.setText(view.getText());
					model.saveToFile();
				}
			}
			Path fileLocation = view.askForOpenDir();
			if(fileLocation != null) {
				model.setFilePath(fileLocation);
				String txt = model.openFile();
				if(txt != null) {
					view.displayText(txt);
					view.updateHeader(model.getFilePath().getFileName().toString());
					model.setIsSaved(true);
				}
				else {
					view.showErrorMsg("Whöööööp, Error reading file");
				}
			}
			break;
		case 4:
			System.out.println("create new file");
			if(!model.getIsSaved()) {
				Boolean wantToSave = view.askToSave();
				if(wantToSave) {
					if(model.getFilePath() == null) {
						Path saveLocation = view.askForSaveDir();
						if(saveLocation != null) {
							model.setFilePath(saveLocation);
						}
					}
					model.setText(view.getText());
					model.saveToFile();
				}
			}
			Path newFileLocation = view.askForSaveDir();
			if(newFileLocation != null) {
				model.setFilePath(newFileLocation);
				view.clearText();
				view.updateHeader(model.getFilePath().getFileName().toString());
				model.setText("");
				model.setIsSaved(true);
			}
			break;
		case 5:
			System.out.println("edit text");
			view.updateHeader(model.getFilePath().getFileName()+ "*");
			model.setIsSaved(false);
			break;
		case 6:
			System.out.println("save file");
			if(model.getFilePath() == null) {
				Path saveLocation = view.askForSaveDir();
				if(saveLocation != null) {
					model.setFilePath(saveLocation);
				}
			}
			view.updateHeader(model.getFilePath().getFileName().toString());
			model.setText(view.getText());
			model.saveToFile();
			break;
		case 7:
			System.out.println("save file as");
			Path saveLocation = view.askForSaveDir();
			if(saveLocation != null) {
				model.setFilePath(saveLocation);
				view.updateHeader(model.getFilePath().getFileName().toString());
				model.saveToFile();
			}
			break;
		case 8:
			System.out.println("Cut");
			view.cutSelectedText();
			break;
		case 9:
			System.out.println("Copy");
			view.copyText();
			break;
		case 10:
			System.out.println("Paste");
			view.pasteText();
			break;
		default:
			System.out.println("unexpected event");
		}
	}
	
	public void initialize() {
		
	}
}
