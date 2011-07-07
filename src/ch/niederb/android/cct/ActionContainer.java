package ch.niederb.android.cct;

import java.util.HashMap;

public class ActionContainer {
	private static final ActionContainer INSTANCE = new ActionContainer();
	
	public static ActionContainer getInstance() {
		return INSTANCE;
	}
	
	public ActionContainer() {
		actions.put("home.kitchen.spoon", new Action());
		
	}
		
	private HashMap<String, Action> actions = new HashMap<String, Action>();
	
	
	
	public Action getAction(String key) {
		return actions.get(key);
	}
}
