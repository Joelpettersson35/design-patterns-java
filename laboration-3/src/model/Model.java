package model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Model {
	private Path filePath;
	private Boolean isSaved;
	private String text;
	
	public Model() {
		filePath = null;
		isSaved = true;
		text = "";
	}
	

	public Path getFilePath() {
		return filePath;
	}


	public void setFilePath(Path filePath) {
		if (!filePath.toString().toLowerCase().endsWith(".txt")) {
		    filePath = Path.of(filePath.toString() + ".txt");
		}
		this.filePath = filePath;
	}


	public Boolean getIsSaved() {
		return isSaved;
	}

	public void setIsSaved(Boolean saved) {
		this.isSaved = saved;
	}
	
	
	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String openFile() {
		String txt;
		try {
			txt = Files.readString(filePath);
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return txt;
	}
	
	public Boolean saveToFile() {
		try {
			Files.writeString(filePath, text);
			isSaved = true;
			return true;
		}
		catch(IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}
