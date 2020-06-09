package common;

import java.io.File;
import java.io.FilenameFilter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JclOptFactory {
	private static JclOptFactory instance;

	protected JclOptFactory() {
	}

	public static synchronized JclOptFactory instantiate() {
		if (instance == null) {
			instance = new JclOptFactory();
		}
		return instance;
	}

	public Object getInstance(final String fileName) {

		Method m = null;
		Object instance = null;
		try {
			final File f = new File(System.getProperty("user.dir"));

			final File[] matchingFiles = f.listFiles(new FilenameFilter() {
				@Override
				public boolean accept(final File dir, final String name) {
					return name.startsWith(fileName) && name.endsWith("java");
				}
			});
			if (matchingFiles.length != 0) {
				final Class<?> c = Class.forName(matchingFiles[0].getAbsolutePath());
				m = c.getMethod("getInstance", null);
			}
		} catch (final ClassNotFoundException | NoSuchMethodException | SecurityException
				| IllegalArgumentException e) {
			return null;
		} finally {
			try {
				instance = m.invoke(null, null);
			} catch (final IllegalArgumentException | InvocationTargetException | IllegalAccessException e) {
				return null;
			}
		}
		return instance;
	}
}
