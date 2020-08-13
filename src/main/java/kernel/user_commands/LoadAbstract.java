package kernel.user_commands;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
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
	public Object2ObjectMap<String, Object> load(final String filePath) {
		final Object2ObjectMap<String, Object> map = new Object2ObjectOpenHashMap<>();
		map.put("upper", Double.valueOf(Double.MAX_VALUE));
		map.put("lower", Double.valueOf(Double.MIN_VALUE));
		map.put("path", "");
		final Pair<String, Double> x = new Pair<>("", Double.MAX_VALUE);
		map.put("bestResult", x);
		final ObjectSet<String> vertices = new ObjectOpenHashSet<>();
		map.put("vertices", vertices);
		return map;
	}

}