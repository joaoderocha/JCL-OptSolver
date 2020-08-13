package common;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class JclOptPropertiesHandler {
	private final static String SEPARATOR = ";";

	public static String[] getProperty(final String property) {
		final Properties properties = new Properties();
		String[] result = null;
		try {
			properties.load(new FileInputStream("JCLopt_naming.properties"));

			result = properties.getProperty(property).split(SEPARATOR);
		} catch (Error | IOException e) {
			e.printStackTrace();
		}

		return result;
	}

}
