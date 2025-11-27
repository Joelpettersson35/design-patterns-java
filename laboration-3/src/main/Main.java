package main;

import controller.Controller;

import view.View;

//nameuser = controler, //konsol vy och GUI ska vara produkter av en abstract klass (gemensam superklass)

public class Main {

	public static void main(String[] args) {
		Controller controller = new Controller();
		controller.handleEvent(1);
	}

}
