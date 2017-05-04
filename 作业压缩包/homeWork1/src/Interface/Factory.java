package Interface;

public interface Factory<T> {
	T made(Class<?extends T> Type);
}
