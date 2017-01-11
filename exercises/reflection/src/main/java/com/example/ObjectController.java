package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/categories")
public class ObjectController {

    List<Object> objects = new ArrayList<>();

    @RequestMapping(path = "", method = RequestMethod.GET)
    public Iterable<Object> listObjects() {
        return new ArrayList<>();
    }

    @RequestMapping(path = "", method = RequestMethod.POST)
    public Object createCategory(@RequestBody Object object) {
        return object;
    }

    @RequestMapping(path = "/{objectId}", method = RequestMethod.PUT)
    public ResponseEntity<Object> updateCategory(@PathVariable Long objectId, @RequestBody Object object) {
        return new ResponseEntity<>(object, HttpStatus.OK);
    }

    @RequestMapping(path = "/{objectId}", method = RequestMethod.DELETE)
    public void deleteCategory(@PathVariable Long objectId) {

    }

    @RequestMapping(path = "/{objectId}", method = RequestMethod.GET)
    public Iterable<Object> categories(@PathVariable Long objectId) {
        return objects;
    }

}