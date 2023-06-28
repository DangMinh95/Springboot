package com.example.demo.service;

import java.util.List;

public interface CrudService<T> {
    List<T> getAllData();

    T save(T data);
}
