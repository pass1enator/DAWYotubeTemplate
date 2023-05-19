/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pedro.ieslaencanta.com.dawgoogle.repositories;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import pedro.ieslaencanta.com.dawgoogle.entities.IEntity;

/**
 *
 * @author Pedro
 */
public interface IRepository<T extends IEntity, K, ID> {

    public void add(T item);

    public void setPredicateId(BiPredicate<T,ID> c);

    public void setPredicateKey(BiPredicate<T,K> c);

    public void update(T item);

    public void removeById(ID id);

    public void removeByKey(K key);

    public void remove(T item);

    public T getById(ID id);

    public T getByKey(K key);

    public List<T> getAll();

    public int count();

    public boolean existsById(ID id);

    public boolean existsByKey(K key);

    public List<T> find(K find);

    public List<T> find(Object... arg);
}
