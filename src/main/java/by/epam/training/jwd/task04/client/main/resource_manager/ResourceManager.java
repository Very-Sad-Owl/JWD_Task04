package by.epam.training.jwd.task04.client.main.resource_manager;

import java.util.ResourceBundle;

public class ResourceManager {

private final static ResourceManager instance = new ResourceManager();

	private ResourceBundle bundle = ResourceBundle.getBundle("client");
	
	public static ResourceManager getInstance () {
		return instance;
	}
	
	public String getValue (String key) {
		return bundle.getString(key);
	}
}
