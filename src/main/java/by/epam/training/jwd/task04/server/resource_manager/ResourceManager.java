package by.epam.training.jwd.task04.server.resource_manager;

import java.util.ResourceBundle;

public class ResourceManager {

	private final static ResourceManager instance = new ResourceManager();
	private ResourceBundle bundle = ResourceBundle.getBundle("server");
	
	public static ResourceManager getInstance () {
		return instance;
	}
	
	public String getValue (String key) {
		return bundle.getString(key);
	}
}
