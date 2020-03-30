package utils;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;

public class JCLdataAccess {
	/**
	 *
	 * @param name String value of variable to be instantiated on cluster
	 * @param var  Object value of variable to be instantiated on cluster
	 * @return true if the variable was successfully instantiated false either
	 */
	public static boolean instantiateVarInJCL(String name, Object var) {
		final JCL_facade jcl = JCL_FacadeImpl.getInstance();
		return jcl.instantiateGlobalVar(name, var);
	}

	/**
	 *
	 * @param name String name of variable inside cluster
	 * @return Object value of variable inside cluster
	 */
	public static Object getVarJCL(String name) {
		final JCL_facade jcl = JCL_FacadeImpl.getInstance();
		return jcl.getValue(name).getCorrectResult();
	}

	/**
	 *
	 * @param varsName String list containing all variable names to be retrieve from
	 *                 cluster
	 * @return Object array containing all variable in argument order
	 */
	public static Object[] getVarsJCL(String[] varsName) {
		final Object[] results = new Object[varsName.length];
		final JCL_facade jcl = JCL_FacadeImpl.getInstance();
		final int i = 0;
		for (final String name : varsName) {
			results[i] = jcl.getValue(name).getCorrectResult();
		}

		return results;
	}

	/**
	 *
	 * @return Object array with all variables declared on vars field on
	 *         config.properties
	 */
	public static Object[] getVarsJCL() {

		final Properties properties = new Properties();
		String[] varsName = null;
		try {
			properties.load(new FileInputStream("config.properties"));
			final String property = properties.getProperty("vars");
			varsName = property.split(";");

		} catch (final Exception e) {
			e.printStackTrace();
		}

		final Object[] results = new Object[varsName.length];
		final JCL_facade jcl = JCL_FacadeImpl.getInstance();
		final int i = 0;
		for (final String name : varsName) {
			results[i] = jcl.getValue(name).getCorrectResult();
		}

		return results;
	}

	/**
	 *
	 * @param name String name of variable on cluster
	 * @param obj  Object of given variable to be instantiated on cluster
	 */
	public static void setVarJCL(String name, Object obj) {
		final JCL_facade jcl = JCL_FacadeImpl.getInstance();
		jcl.setValueUnlocking(name, obj);
	}

	/**
	 *
	 * @param names String list with all variable names to be set on cluster
	 * @param vars  Object list with all object value to be set on cluster
	 */
	public static void setVarsJCL(List<String> names, List<Object> vars) {
		final JCL_facade jcl = JCL_FacadeImpl.getInstance();
		int i = 0;
		for (final String name : names) {
			jcl.setValueUnlocking(name, vars.get(i));
			i++;
		}
	}
}
