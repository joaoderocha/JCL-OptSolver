package common;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import kernel.utils.FileHunter;

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

	public Object getInstance(final String fileName)
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		Method m = null;
		Object instance = null;
		final FileHunter fh = FileHunter.getInstance();
		try {
			final File[] matchingFiles = fh.search(fileName);
			System.out.println(relativise(matchingFiles[0].getAbsolutePath()));
			if (matchingFiles.length != 0) {
				final Class<?> c = Class.forName("implementation.user_commands.CoordinatesXY");
				System.out.println(c);
				m = c.getMethod("instantiate", null);
				System.out.println(m);
				instance = m.invoke(null, null);
			}
		} catch (final ClassNotFoundException | NoSuchMethodException | SecurityException
				| IllegalArgumentException e) {
			return null;
		}

		return instance;
	}

	private String relativise(final String filepath) {
		final String base = System.getProperty("user.dir");

		return new File(base).toURI().relativize(new File(filepath).toURI()).getPath();
	}

//	private String toPackage(String relativeFilepath) {
//
//	}
}
