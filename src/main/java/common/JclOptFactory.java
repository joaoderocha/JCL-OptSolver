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
			final String relativePath = relativise(matchingFiles[0].getAbsolutePath());
			if (matchingFiles.length != 0) {
				final Class<?> c = extractClass(relativePath);
				System.out.println(c);
				m = c.getMethod("instantiate", null);
				System.out.println(m);
				instance = m.invoke(null, null);
			}
		} catch (final NoSuchMethodException | SecurityException | IllegalArgumentException e) {
			return null;
		}

		return instance;
	}

	private String relativise(final String filepath) {
		final String base = System.getProperty("user.dir");

		return new File(base).toURI().relativize(new File(filepath).toURI()).getPath();
	}

	@SuppressWarnings("finally")
	private Class<?> extractClass(final String relativeFilepath) {

		final String dotedString = relativeFilepath.replace('/', '.');
		System.out.println(dotedString);
		final String[] possiblePackage = dotedString.split("\\.");
		System.out.println(possiblePackage);
		Class<?> minhaClasse = null;
		final StringBuilder sb = new StringBuilder();
		for (int i = possiblePackage.length - 2; i > 0; i--) {
			sb.insert(0, possiblePackage[i]);
			System.out.println(sb.toString());
			try {
				minhaClasse = Class.forName(sb.toString());
			} finally {
				sb.insert(0, ".");
				continue;
			}
		}
		return minhaClasse;
	}
}
