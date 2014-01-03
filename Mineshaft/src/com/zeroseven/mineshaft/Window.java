package com.zeroseven.mineshaft;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.*;

import com.zeroseven.mineshaft.API.Functions;

public class Window extends JFrame{
	
	private BorderLayout layout;
	private JTextArea code;
	public static JTextArea log;
	public JTextField logger;
	private JButton run, save, load, about, help;
	private JScrollPane scroll, logscroll;
	private JToolBar toolbar, logtoolbar;
	
	public Window(String title){
		
		super(title);
		layout = new BorderLayout();
		setLayout(layout);
		
		toolbar = new JToolBar("Tools");
		logtoolbar = new JToolBar("Script Log");
		code = new JTextArea();
		log = new JTextArea();
		run = new JButton("Run");
		save = new JButton("Save");
		load = new JButton("Load");
		about = new JButton("About");
		help = new JButton("Help");
		scroll = new JScrollPane(code);
		logscroll = new JScrollPane(log);
		logger = new JTextField();
		
		log.setEditable(false);
		log.setText("<Script Log>\n\n\n\n\n\n\n\n");
		
		//Tool Bar
		toolbar.add(run);
		toolbar.add(save);
		toolbar.add(load);
		toolbar.add(about);
		toolbar.add(help);
		
		//Log Tool Bar
		logtoolbar.add(logger);
		
		//Main Layout
		add(toolbar, BorderLayout.PAGE_START);
		add(scroll, BorderLayout.CENTER);
		add(logscroll, BorderLayout.PAGE_END);
		
		run.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String script = code.getText();
				ScriptParser sp = new ScriptParser();
				sp.eval(script);
				
			}});
		about.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				Functions.alert("Mineshaft\nVersion 0.1.1 TESTING\nCopyright Zero-Seven Productions 2014");
				
			}});
		
		help.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				WebWindow web = null;
				try {
					web = new WebWindow("Help", new URL("http://zeroseven.x10.mx/"));
				} catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				if(web != null)web.setVisible(true);
				
			}});
		
		save.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				String filename = JOptionPane.showInputDialog("Enter the file name.");
				Directory Dirs = new Directory();
				File script = new File(Dirs.MINESHAFT_SCRIPTS, filename + ".js");
				try {
					FileOutputStream fos = new FileOutputStream(script);
					fos.write(code.getText().toString().getBytes());
					if(filename != null){
						Functions.log("Successfully saved " + filename);
					}else{
						Functions.log("Make sure your file has a name");
					}
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					Functions.log("Failed to save " + filename);
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					Functions.log("Failed to save " + filename);
					e.printStackTrace();
				}
				
				
			}});
		
		load.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				JFrame loadwindow = new JFrame();
				JLabel title = new JLabel("Scripts");
				
				loadwindow.setLayout(new FlowLayout());
				loadwindow.add(title);
				
				loadwindow.setSize(150, 350);
				loadwindow.setResizable(false);
				loadwindow.setVisible(true);
				Directory dir = new Directory();
				File[] listscripts = dir.MINESHAFT_SCRIPTS.listFiles();
				
				for(final File script: listscripts){
					
					Button open = new Button(script.getName().replace(".js", ""));
					open.setSize(loadwindow.getWidth(), 25);
					open.addActionListener(new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							// TODO Auto-generated method stub
							try {
								BufferedReader br = new BufferedReader(new FileReader(script));
								String str;
								StringBuilder data = new StringBuilder();
								
								try {
									while((str = br.readLine()) != null){
										
										data.append(str);
										data.append("\n");
										
									}
									
									String dat = data.toString();
									code.setText(dat);
									Functions.log("Loaded " + script.getAbsolutePath().replace(".js", ""));
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						}});
					
					JScrollPane loadscroll = new JScrollPane(open);
					loadwindow.add(loadscroll);
					
				}
				
			}});
		
		run.setToolTipText("Run the script");
		save.setToolTipText("Save the script");
		load.setToolTipText("Load an existing script");
		about.setToolTipText("About this program");
		
	}
	
}
