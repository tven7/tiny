package com.tiny.persistence;

/**
 * Created by tven on 5/10/18.
 */
public interface Store<T> {
    void index(Class<T> type);
    boolean isExists(Class<T> type);

}
