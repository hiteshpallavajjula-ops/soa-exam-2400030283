package com.klef.soa.exam.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.klef.soa.exam.entity.Crud;
import com.klef.soa.exam.entity.repository.CrudRepository;

@Service
public class CrudService {

    private final CrudRepository repository;

    public CrudService(CrudRepository repository) {
        this.repository = repository;
    }

    public Crud add(Crud crud) {
        return repository.save(crud);
    }

    public List<Crud> displayAll() {
        return repository.findAll();
    }

    public boolean delete(Long id) {
        if (!repository.existsById(id)) {
            return false;
        }

        repository.deleteById(id);
        return true;
    }
}