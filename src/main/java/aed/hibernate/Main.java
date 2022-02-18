package aed.hibernate;

public class Main {
	
	private static ConfigurationClass configurationClass;
	
	public static void main(String[] args) {
		configurationClass = new ConfigurationClass();
		
		
		
		configurationClass.closeConfiguration();
	}

}
