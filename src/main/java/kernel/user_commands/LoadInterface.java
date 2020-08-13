package kernel.user_commands;

import common.JclOptObject;
import it.unimi.dsi.fastutil.objects.Object2ObjectMap;

public interface LoadInterface extends JclOptObject {

	public Object2ObjectMap<String, Object> load(String filePath);

	@Override
	JclOptObject getInstance();

}