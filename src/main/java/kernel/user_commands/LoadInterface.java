package kernel.user_commands;

import java.util.Map;

import common.JclOptObject;

public interface LoadInterface extends JclOptObject {

	public Map<String, Object> load(String filePath);

	@Override
	LoadInterface getInstance();

}