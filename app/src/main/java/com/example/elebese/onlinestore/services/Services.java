package com.example.elebese.onlinestore.services;

import java.util.List;

/**
 * Created by elebese on 2016/01/18.
 */
public interface Services<S, ID> {
    public S findById(ID id);

    public String save(S entity);

    public String update(S entity);

    public String delete(S entity);

    public List<S> findAll();
}
