package com.mftplus.demo.model.service;

import java.util.List;

public interface Service <T,I>{
    public void save(T t);
    public void edit(T t);
    public void remove(I id);
    public T findById(I id);
    public List<T> findAll();
}
