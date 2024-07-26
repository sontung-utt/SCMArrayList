package manager;

import java.util.ArrayList;

public interface IManager<E> {
    void add(E e);
    void remove(int id);
    void update(int id, E e);
    int findById(int id);
    ArrayList<E> getAll();
    ArrayList<E> getByName(String name);
}
