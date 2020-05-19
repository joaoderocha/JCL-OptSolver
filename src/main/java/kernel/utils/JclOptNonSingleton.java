package kernel.utils;

public class JclOptNonSingleton implements JclOptObject {

    public Object getInstance() {
        JclOptObject obj = new JclOptNonSingleton();
        return obj;
    }
}
