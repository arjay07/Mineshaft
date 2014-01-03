package com.zeroseven.mineshaft;

import java.awt.*;
import java.io.IOException;
import java.net.*;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class WebWindow extends JFrame{
	
	private JEditorPane editor;
	
	public WebWindow(String title, URL url) throws IOException{
		
		super(title);
		editor = new JEditorPane();
		setLayout(new BorderLayout());
		
		editor.setPage(url);
		editor.addHyperlinkListener(new HyperlinkListener(){

			@Override
			public void hyperlinkUpdate(HyperlinkEvent arg0) {
				// TODO Auto-generated method stub
				try {
					editor.setPage(arg0.toString());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}});
		
		add(editor, BorderLayout.CENTER);
		
	}

}
