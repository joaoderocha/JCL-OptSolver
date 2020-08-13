package kernel.user_commands;

import java.util.Map;

import implementations.dm_kernel.user.JCL_FacadeImpl;
import interfaces.kernel.JCL_facade;
import it.unimi.dsi.fastutil.objects.ObjectOpenHashSet;
import it.unimi.dsi.fastutil.objects.ObjectSet;
import kernel.utils.Pair;

/**
 *
 * @author Joao Abstract class used to guarantee essentials implementations used
 *         on kernel
 */
public abstract class LoadAbstract implements LoadInterface {

	@Override
	public Map<String, Object> load(final String filePath) {
		final JCL_facade jcl = JCL_FacadeImpl.getInstance();
		jcl.instantiateGlobalVar("upper", Double.valueOf(Double.MAX_VALUE));
		jcl.instantiateGlobalVar("lower", Double.valueOf(Double.MIN_VALUE));
		jcl.instantiateGlobalVar("path", "");
		final Pair<String, Double> x = new Pair<>("", Double.MAX_VALUE);
		jcl.instantiateGlobalVar("bestResult", x);
		final ObjectSet<String> vertices = new ObjectOpenHashSet<>();
		jcl.instantiateGlobalVar("vertices", vertices);
		return null;
	}

}