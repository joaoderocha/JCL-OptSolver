package common;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;

import kernel.utils.FileHunter;

public class JclOptFactory {
	private static JclOptFactory instance;
	private final Map<String, Object> singletons;

	protected JclOptFactory() {
		singletons = new TreeMap<>();
	}

	public static synchronized JclOptFactory instantiate() {
		if (instance == null) {
			instance = new JclOptFactory();
		}
		return instance;
	}

	public Object getInstance(final String nickname, final boolean isSingleton) {
		if (nickname == null) {
			return null;
		}

		if (isSingleton && singletons.containsKey(nickname)) {
			return singletons.get(nickname);
		}

		final Object objInstance = returnInstance(nickname);

		if (objInstance == null) {
			return objInstance;
		}

		singletons.put(nickname, objInstance);
		return objInstance;

	}

	private String relativise(final String filepath) {
		final String base = System.getProperty("user.dir");

		return new File(base).toURI().relativize(new File(filepath).toURI()).getPath();
	}

	public Object findInstance(final String fileName) {

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
				instance = m.invoke(null, null);
			}
		} catch (final NoSuchMethodException | SecurityException | IllegalArgumentException | IllegalAccessException
				| InvocationTargetException e) {
			return null;
		}

		return instance;
	}

	@SuppressWarnings("finally")
	private Class<?> extractClass(final String relativeFilepath) {
		final String dotedString = relativeFilepath.replace('/', '.');
		final String[] possiblePackage = dotedString.split("\\.");
		Class<?> minhaClasse = null;
		final StringBuilder sb = new StringBuilder();
		for (int i = possiblePackage.length - 2; i > 0; i--) {
			sb.insert(0, possiblePackage[i]);
			try {
				minhaClasse = Class.forName(sb.toString());
			} finally {
				sb.insert(0, ".");
				continue;
			}
		}

		return minhaClasse;
	}

	private Object returnInstance(final String nickname) {

		final Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("JCLopt_naming.properties"));
			final Class<?> c = Class.forName(properties.getProperty(nickname));
			return c.newInstance();
		} catch (final Exception e) {
			e.printStackTrace();
		}

		// otherwise
		return null;
	}

}
