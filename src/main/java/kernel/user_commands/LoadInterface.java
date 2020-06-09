package kernel.user_commands;

import common.JclOptObject;

public interface LoadInterface extends JclOptObject {

	public void load(String filePath);

	@Override
	LoadInterface getInstance();

}