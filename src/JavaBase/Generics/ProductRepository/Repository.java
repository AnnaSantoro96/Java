package JavaBase.Generics.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class Repository<T> {
    private final List<T> list;

    public Repository(){
        list = new ArrayList<>();
    }

    public void addItem(T item){
        list.add(item);
    }

    public void remove(T item){
        list.remove(item);
    }

    public ArrayList<T> getAll() {
        return new ArrayList<>(list);
    }

    public int size(){
        return list.size();
    }

}