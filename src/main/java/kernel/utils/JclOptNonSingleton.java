package kernel.utils;

public class JclOptNonSingleton implements JclOptObject {

    public JclOptObject getInstance() {
        JclOptObject obj = new JclOptNonSingleton();
        return obj;
    }
}
