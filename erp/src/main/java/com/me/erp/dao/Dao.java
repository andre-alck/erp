package com.me.erp.dao;

import java.util.Optional;

public interface Dao<T> {
    Optional<T> resgataPorId(String id);
}
