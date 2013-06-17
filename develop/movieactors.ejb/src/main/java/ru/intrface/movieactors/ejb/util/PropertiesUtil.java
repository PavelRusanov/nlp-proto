package ru.intrface.movieactors.ejb.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private Properties props;
	public static final PropertiesUtil INSTANCE = new PropertiesUtil();
	
	private PropertiesUtil(){
		Properties props = new Properties();
		try {
			props.load(new FileInputStream("app.properties"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Properties getProps() {
		return props;
	}
	
	

}
