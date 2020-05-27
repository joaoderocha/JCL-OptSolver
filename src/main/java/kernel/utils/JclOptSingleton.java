package kernel.utils;

public class JclOptSingleton implements JclOptObject {
    private JclOptObject instance;

    private JclOptSingleton() {
    }

    public JclOptObject getInstance() {
        if (instance == null) {
            synchronized (JclOptNonSingleton.class) {
                if (instance == null) {
                    this.instance = new JclOptSingleton();
                }
            }
        }
        return instance;
    }
}
