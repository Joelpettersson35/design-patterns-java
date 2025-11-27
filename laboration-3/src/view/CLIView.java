package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;

import controller.Controller;

public class CLIView implements View {
	
	Controller controller;
	
	//test path /Users/joelpetterssonmac/newtestfile.txt

	@Override
	public boolean askToSave() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void runUI() {
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("********* Menu *********");
			System.out.println("3. Open file");
			System.out.println("4. Create new file");
			System.out.println("6. Save text to current file");
			
			try {
				String choice = r.readLine();
				int parsedChoice = Integer.parseInt(choice);
				//System.out.println(parsedChoice);
				controller.handleEvent(parsedChoice);
			}
			catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public Path askForSaveDir() {
		System.out.print("Give your file a name and directory:");
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		try {
			String choice = r.readLine();
			Path path = Path.of(choice);
			return path;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String getText() {
		System.out.println("Enter text:");
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder builder = new StringBuilder();
		try {
			String line = r.readLine();

			while (line != null && !line.isEmpty()) {
			    builder.append(line).append("\n");
			    line = r.readLine();
			}
			
			System.out.println("SAVED");
			return builder.toString();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Path askForOpenDir() {
		System.out.print("Enter path to file:");
		BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
		try {
			String choice = r.readLine();
			Path path = Path.of(choice);
			return path;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void displayText(String txt) {
		System.out.println("Content:\n" + txt);
	}

	@Override
	public void updateHeader(String file) {
		System.out.println("Current file: " + file);
	}

	@Override
	public void showErrorMsg(String msg) {
		System.out.println(msg);
		
	}

	@Override
	public void newFile() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cutSelectedText() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void copyText() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pasteText() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setController(Controller c) {
		controller = c;
		
	}
}
