package model;

public class JclOptNonSingleton<T extends JclOptObject<?>> implements JclOptObject<T> {
    private T instance;
    @SuppressWarnings("unchecked")
	public T getInstance() throws InstantiationException, IllegalAccessException {
        return (T) instance.getClass().newInstance(); 
    }
}
