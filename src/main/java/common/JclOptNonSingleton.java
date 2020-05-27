package common;

public abstract class JclOptNonSingleton implements JclOptObject {
    protected JclOptNonSingleton(){
        super();
    }
    public abstract JclOptObject getInstance();
}
