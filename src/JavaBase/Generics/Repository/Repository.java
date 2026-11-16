package JavaBase.Generics.Repository;

import java.util.ArrayList;

public class Repository<T> {
    private ArrayList<T> list;

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
