package dao;

import java.util.ArrayList;


public interface DaoInterface<T> {
    public int insert(T t);

    public int update(T t, String id);

    public int deleteById(String id);
    
    public void deleteAll();

    public ArrayList<T> selectAll();

    public T selectById(String id);
}
