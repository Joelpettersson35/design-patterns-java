package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import controller.Controller;

import view.View;
import view.ViewFactory;

public class Main {

	public static void main(String[] args) {
		//Controller controller = new Controller();
		//controller.handleEvent(1);
		ViewFactory factory = new ViewFactory();
		
		try {
			System.out.println("***** Pick your prefered UI *****");
			System.out.println("Enter '1' for Graphical user interface");
			System.out.println("Enter '2' for Command line interface");
			
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			String choice = r.readLine();
			
			View view = factory.createView(choice);
			
			Controller controller = new Controller(view);
			controller.initialize();
			
			r.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}

}
