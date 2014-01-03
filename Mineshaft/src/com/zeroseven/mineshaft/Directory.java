package com.zeroseven.mineshaft;

import java.io.*;

import com.zeroseven.mineshaft.API.Functions;

public class Directory {
	
	public String USER_HOME_DIRECTORY;
	public File USER_DOCUMENTS_DIRECTORY;
	public File MINESHAFT_FOLDER;
	public File MINESHAFT_SCRIPTS;
	public File MINESHAFT_MODS;
	
	public Directory(){
		
		USER_HOME_DIRECTORY = System.getProperty("user.home");
		USER_DOCUMENTS_DIRECTORY = new File(USER_HOME_DIRECTORY, "My Documents");
		MINESHAFT_FOLDER = new File(USER_DOCUMENTS_DIRECTORY, "Mineshaft");
		MINESHAFT_SCRIPTS = new File(MINESHAFT_FOLDER, "Scripts");
		MINESHAFT_MODS = new File(MINESHAFT_FOLDER, "Mods");
		
	}
	
	public void createDirectories(){
		
		try{

			if(!USER_DOCUMENTS_DIRECTORY.exists()){
				
				Functions.log("Documents directory does not exist!");
				Functions.log("Creating directory...");
				
				USER_DOCUMENTS_DIRECTORY.mkdirs();
				
			}
			
			if(!MINESHAFT_FOLDER.exists()){
				
				Functions.log("Mineshaft directory does not exist!");
				Functions.log("Creating directory...");
				MINESHAFT_FOLDER.mkdirs();
				
			}
			
			if(!MINESHAFT_SCRIPTS.exists()){
				
				Functions.log("Scripts directory does not exist!");
				Functions.log("Creating directory...");
				MINESHAFT_SCRIPTS.mkdirs();
				
			}
			
			if(!MINESHAFT_MODS.exists()){
				
				Functions.log("Mods directory does not exist!");
				Functions.log("Creating directory...");
				MINESHAFT_MODS.mkdirs();
				
			}
			
		}catch(Exception e){
			
			Functions.log("Could not create all directories!");
			
		}
		
	}

}
