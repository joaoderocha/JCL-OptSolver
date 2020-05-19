package kernel.utils;

public class JcLoptNonSingleton implements JclOptObject {

    public Object getInstance() {
        JclOptObject obj = new JcLoptNonSingleton()
        return obj;
    }
}
