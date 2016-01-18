package com.example.elebese.onlinestore.repositories;

import java.util.List;

/**
 * Created by elebese on 2016/01/18.
 */
public interface RestAPI<S, ID> {
    S get(ID id);

    String post(S entity);

    String put(S entity);

    String delete(S entity);

    List<S> getAll();
}
