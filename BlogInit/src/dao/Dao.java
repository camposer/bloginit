package dao;

import java.util.List;

public interface Dao<T, K> {
	public void agregar(T u);
	public void modificar(T u);
	public void eliminar(K id);
	public T obtener(K id);
	public List<T> obtenerTodos();
}
