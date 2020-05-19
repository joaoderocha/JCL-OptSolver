package kernel.utils;

public class JclOptSingleton implements JclOptObject {
    private JclOptObject instance;

    private JclOptSingleton() {
    }

    public Object getInstance() {
        if (instance == null) {
            JclOptObject obj = new JclOptSingleton();
            return obj;
        }
        return instance;
    }
}
