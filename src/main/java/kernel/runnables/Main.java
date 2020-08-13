package kernel.runnables;

import common.JclOptFactory;
import kernel.user_commands.LoadInterface;

public class Main {

	public static void main(final String[] args) {
		final JclOptFactory factory = JclOptFactory.instantiate();
		final LoadInterface loader = (LoadInterface) factory.getInstance("load", false);
		loader.load(args[0]);
	}

}
