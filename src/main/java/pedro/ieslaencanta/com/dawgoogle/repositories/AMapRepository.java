/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pedro.ieslaencanta.com.dawgoogle.repositories;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.function.BiPredicate;
import pedro.ieslaencanta.com.dawgoogle.entities.IEntity;

/**
 *
 * @author Administrador
 */
public abstract class AMapRepository<T extends IEntity, K, ID> implements IRepository<T, K, ID> {

    private HashMap<K, T> elements;
    private BiPredicate<T, ID> predicateid;
    private BiPredicate<T, K> predicatek;

    protected HashMap<K, T> getElements() {
        return elements;
    }

    public AMapRepository() {
        this.elements = new HashMap<>();
    }

    protected void setElements(HashMap<K, T> elements) {
        this.elements = elements;
    }

    @Override
    public void add(T item) {
        if (item == null) {
            throw new NullPointerException("La categoría a insertar es nula");
        }
        this.getElements().put((K) item.getKey(), item);
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(this.getElements().values());
    }

    @Override
    public int count() {
        return this.getElements().size();
    }


    @Override
    public void removeById(ID id) {
        T tempo = this.elements.values().stream().filter(e -> {
            return this.predicateid.test(e, id);
        }).findFirst().get();
        if (tempo != null) {
            this.elements.remove(tempo.getKey());
        }
    }

    @Override
    public void removeByKey(K k) {
        T tempo = this.elements.values().stream().filter(e -> {
            return this.predicatek.test(e, k);
        }).findFirst().get();
        if (tempo != null) {
            this.elements.remove(tempo.getKey());
        }
    }

    @Override
    public void remove(T item) {
        this.removeByKey((K) item.getKey());

    }

    @Override
    public T getById(ID id) {
        Optional<T> tempo = this.elements.values().stream().filter(e -> {
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

        T tempo = this.elements.get(key);
        return tempo;

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
