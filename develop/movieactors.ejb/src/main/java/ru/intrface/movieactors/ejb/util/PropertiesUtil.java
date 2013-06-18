package ru.intrface.movieactors.ejb.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {
	private Properties props;
	public static final PropertiesUtil INSTANCE = new PropertiesUtil();

	private PropertiesUtil() {
		Properties props = new Properties();
		try {

			props.load(this.getClass().getClassLoader()
					.getResourceAsStream("app.properties"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Properties getProps() {
		return props;
	}

}
