package com.zeroseven.mineshaft;

import org.mozilla.javascript.*;

import com.zeroseven.mineshaft.API.Functions;

public class ScriptParser {
	
	public Context ctx;
	public Scriptable scope;
	private FunctionObject alert, log;
	
	public ScriptParser(){
		
		ctx = Context.enter();
		scope = ctx.initStandardObjects();
		
		try {
			
			alert = new FunctionObject("alert", Functions.class.getMethod("alert", new Class<?>[]{String.class}), scope);
			log = new FunctionObject("log", Functions.class.getMethod("log", new Class<?>[]{String.class}), scope);
			
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scope.put("alert", scope, alert);
		scope.put("log", scope, log);
		scope.put("USER_HOME_DIRECTORY", scope, System.getProperty("user.home"));
		scope.put("Block", scope, Context.javaToJS(evaluate("com.zeroseven.mineshaft.API.Block"), scope));
		
	}
	
	public void eval(String code){
		
		try{
		
			ctx.evaluateString(scope, code, "Script:", 1, null);
		
		}catch(Exception e){
			
			javax.swing.JOptionPane.showMessageDialog(null, e.toString());
			
		}
		
	}
	
	public Object evaluate(String code){
		
		Object evaluated = null;
		
		try{
		
			evaluated = ctx.evaluateString(scope, code, "Script:", 1, null);
		
		}catch(Exception e){
			
			javax.swing.JOptionPane.showMessageDialog(null, e.toString());
			
		}
		
		return evaluated;
		
	}
	
}
