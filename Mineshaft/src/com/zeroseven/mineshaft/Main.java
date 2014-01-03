package com.zeroseven.mineshaft;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Window window = new Window("Mineshaft");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setSize(950, 550);
		window.setVisible(true);
		
		Directory directory = new Directory();
		directory.createDirectories();
		
	}

}
