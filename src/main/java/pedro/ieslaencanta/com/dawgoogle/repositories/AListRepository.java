/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawgoogle.repositories;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import pedro.ieslaencanta.com.dawgoogle.entities.IEntity;

/**
 *
 * @author Administrador
 */
public abstract class AListRepository<T extends IEntity, K, ID> implements IRepository<T, K, ID> {

    private List<T> elements;
    private BiPredicate<T, ID> predicateid;
    private BiPredicate<T, K> predicatek;

    public AListRepository() {
        this.elements = new ArrayList<>();
    }

    @Override
    public void add(T item) {
        if (item == null) {
            throw new NullPointerException("La categoría a insertar es nula");
        }
        this.getElements().add(item);
    }

    @Override
    public List<T> getAll() {
        return this.getElements();
    }

    @Override
    public int count() {
        return this.getElements().size();
    }

    protected List<T> getElements() {
        return elements;
    }

    protected void setElements(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public void update(T item) {

    }

    @Override
    public void removeById(ID id) {
        //borra solo aquellos que el predicado sea cierto
        this.elements.removeIf(
                e -> {
                    return this.predicateid.test(e, id);
                }
        );
    }

    @Override
    public void removeByKey(K k) {
        this.elements.removeIf(
                e -> {
                    return this.predicatek.test(e, k);
                }
        );
    }

   

    @Override
    public void remove(T item) {
        this.elements.remove(item);
    }

    @Override
    public T getById(ID id) {
        Optional<T> tempo = this.elements.stream().filter(e -> {
            return this.predicateid.test(e, id);
        }).findFirst();
        if (tempo.isPresent()) {
            return tempo.get();
        } else {
            return null;
        }
    }
     @Override
    public T getByKey(K key) {
          Optional<T> tempo = this.elements.stream().filter(e -> {
            return this.predicatek.test(e, key);
        }).findFirst();
        if (tempo.isPresent()) {
            return tempo.get();
        } else {
            return null;
        }
    
    }

   

    @Override
    public boolean existsById(ID id) {
        if (this.getById(id) != null) {
            return true;
        } else {
            return false;
        }
    }

     @Override
    public boolean existsByKey(K key) {
          if (this.getByKey(key) != null) {
            return true;
        } else {
            return false;
        }
     }

 

    @Override
    public void setPredicateId(BiPredicate<T, ID> c) {
        this.predicateid = c;
    }

    @Override
    public void setPredicateKey(BiPredicate<T, K> c) {
        this.predicatek = c;
    }

}
