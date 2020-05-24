package model;

public interface JclOptObject<T> {
	public T getInstance() throws InstantiationException, IllegalAccessException;

}
