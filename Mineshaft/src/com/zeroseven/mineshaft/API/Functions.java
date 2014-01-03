package com.zeroseven.mineshaft.API;

import java.util.ArrayList;

import javax.swing.*;

import com.zeroseven.mineshaft.Window;

public class Functions {
	
	public static void alert(String message){
		
		JOptionPane.showMessageDialog(null, message);
		
	}
	
	public static void log(String message){
		
		if(Window.log.getText().contains("<Script Log>")){
			
			Window.log.setText(message + "\n");
			
		}else{
			
			Window.log.append(message);
			Window.log.append("\n");
			
		}
		
		//Commands
		String[] cmd = message.split(" ");
		ArrayList<String> availableCommands = new ArrayList<String>();
		if(cmd[0] == "/clear"){
			
			availableCommands.add("/clear");
			Window.log.setText("<Script Log>\n\n\n\n\n\n\n");
			
		}
		if(cmd[0] == "/copy"){
			
			availableCommands.add("/copy");
			
		}
		
		if(cmd[0].startsWith("/") && !availableCommands.contains(cmd[0])){
			
			log("The command: "  + cmd[0] + " does not exist!");
			
		}
		
	}

}
