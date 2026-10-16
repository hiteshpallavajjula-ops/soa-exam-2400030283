package com.klef.soa.exam.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.exam.entity.Crud;
import com.klef.soa.exam.service.CrudService;

@RestController
@CrossOrigin
public class CrudController {

    private final CrudService service;

    public CrudController(CrudService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home() {
        return "CRUD Service is running!";
    }

    @PostMapping("/Add")
    public ResponseEntity<Crud> add(@RequestBody Crud crud) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.add(crud));
    }

    @GetMapping("/DisplayAll")
    public List<Crud> displayAll() {
        return service.displayAll();
    }

    @DeleteMapping("/Delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        if (service.delete(id)) {
            return ResponseEntity.ok("Record deleted successfully");
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Record not found: " + id);
    }
}