package model;

public abstract class JclOptSingleton<T extends JclOptSingleton<T>> implements JclOptObject<T> {
    private T instance;
    private int id;
    
    private JclOptSingleton() {
        id = Integer.MIN_VALUE;
    }

	@SuppressWarnings("unchecked")
	public T getInstance() throws InstantiationException, IllegalAccessException {
        if (instance == null) {
        	this.instance = (T) instance.getClass().newInstance();            
        }
        return instance;
    }

    public abstract void setProperties(Object...objects);

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
