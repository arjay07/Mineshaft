package com.zeroseven.mineshaft.API;

import java.io.*;

public class Block {

	public static String BLOCKTEMP;
	public static String BLOCKXML;
	public static String GENXML;
	
	
	//Category
	public static String STONE = "stone";
	public static String GRASS = "grass";
	public static String LEAVES = "leaves";
	public static String WOOD = "wood";
	public static String SAND = "sand";
	public static String METAL = "metal";
	public static String CACTUS = "Cactus";
	
	//Block properties
	public int ID;
	public int DROP;
	public int BREAKTIME;
	public String NAME;
	public String CATEGORY;
	
	//Block attributes
	public boolean Solid = false;
	public boolean Transparent = false;
	public boolean Opaque = false;
	public boolean Liquid = false;
	public boolean Visible = false;
	public boolean Removable = false;
	public boolean Special = false;
	public boolean Valuable = false;
	public boolean Active = false;
	public int Emittance = 0;
	
	//Block Textures
	public String DEFAULT = "";
	public String top = "";
	public String bottom = "";
	public String front = "";
	public String back = "";
	public String left = "";
	public String right = "";
	
	public Block(int id, String name, int drop, int breaktime, String category){
		
		ID = id;
		NAME = name;
		DROP = drop;
		BREAKTIME = breaktime;
		CATEGORY = category;
		
		//Creates the template
		File temp = new File("res/templates/Block.xml");
		String tempstr;
		StringBuilder tempdata = new StringBuilder();
		try {
			BufferedReader tempbr = new BufferedReader(new FileReader(temp));
			
			try {
				while((tempstr = tempbr.readLine()) != null){
					
					tempdata.append(tempstr);
					tempdata.append("\n");
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BLOCKTEMP = tempdata.toString();
		
		//Creates the XML
		File xml = new File("res/MBAssets/Data/blocks.xml");
		String xmlstr;
		StringBuilder xmldata = new StringBuilder();
		
		try {
			BufferedReader xmlbr = new BufferedReader(new FileReader(xml));
			
			try {
				while((xmlstr = xmlbr.readLine()) != null){
					
					xmldata.append(xmlstr);
					xmldata.append("\n");
					
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		BLOCKXML = xmldata.toString();
		
	}
	
	//Get Block properties
	public int getId(){
		
		return ID;
		
	}
	
	public String getName(){
		
		return NAME;
		
	}
	
	public String getCategory(){
		
		return CATEGORY;
		
	}
	
	//Set Block attributes
	public void setSolid(boolean b){
		
		Solid = b;
		
	}
	
	public void setTransparent(boolean b){
		
		Transparent = b;
		
	}
	public void setOpaque(boolean b){
		
		Opaque = b;
	}
	
	public void setLiquid(boolean b){
		
		Liquid = b;
	}
	
	public void setVisible(boolean b){
		
		Visible = b;
	}
	
	public void setRemovable(boolean b){
		
		Removable = b;
		
	}
	
	public void setSpecial(boolean b){
		
		Special = b;
		
	}
	
	public void setValuable(boolean b){
		
		Valuable = b;
		
	}
	
	public void setActive(boolean b){
		
		Active = b;
		
	}
	
	public void setEmittance(int i){
		
		Emittance = i;
		
	}
	
	//Set block textures
	public void setTextures(String[] textures){
		
		String[] sides = {top, bottom, front, back, left, right};
		String[] startTag = {"<top>", "<bottom>", "<front>", "<back>", "<left>", "<right>"};
		String[] endTag = {"</top>", "</bottom>", "</front>", "</back>", "</left>", "</right>"};
		
		if(textures.length == 6){
			
			for(int i = 0; i < textures.length; i++){
				
				sides[i] = startTag[i] + textures[i] + endTag[i];
				
			}
			
		}
		
	}
	
	public void setDefaultTexture(String t){
		
		DEFAULT = "<default>" + t + "</default>";
		
	}
	
	public void setTopTexture(String t){
		
		top = "<top>" + t + "</top>";
		
	}
	
	public void setBottomTexture(String t){
		
		bottom = "<bottom>" + t + "</bottom>";
		
	}
	
	public void setFrontTexture(String t){
		
		front = "<front>" + t + "</front>";
		
	}
	
	public void setBackTexture(String t){
		
		back = "<back>" + t + "</back>";
		
	}
	
	public void setLeftTexture(String t){
		
		left = "<left>" + t + "</left>";
		
	}
	
	public void setRightTexture(String t){
		
		right = "<right>" + t + "</right>";
		
	}
	
	public void setTexture(String t){
		
		DEFAULT = "<default>" + t + "</default>";
		
	}
	
	//Create Code
	public void create(){
		
		String CODE = BLOCKTEMP
				.replace("@id", "" + ID)
				.replace("@name", NAME)
				.replace("@category", CATEGORY)
				.replace("@drop", "" + DROP)
				.replace("@default_break", "" + BREAKTIME)
				.replace("@solid", "" + Solid)
				.replace("@transparent", "" + Transparent)
				.replace("@opaque", "" + Opaque);
		
	}
	
}
	
	




