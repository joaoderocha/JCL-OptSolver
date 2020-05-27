package common;

public class JclOptSingleton implements JclOptObject {
    private static JclOptSingleton instance;

    protected JclOptSingleton() {
    }

    public static JclOptSingleton instantiate() {
        if (instance == null) {
            synchronized (JclOptSingleton.class) {
                if (instance == null) {
                    instance = new JclOptSingleton();
                }
            }
        }
        return instance;
    }

    @Override
    public JclOptObject getInstance() {
        return instance;
    }
}
