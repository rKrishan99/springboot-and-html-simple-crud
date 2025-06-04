package com.example.demo.controller;


import com.example.demo.entity.FormData;
import com.example.demo.service.FormService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin("*")
public class FormController {

    private final FormService formService;

    @PostMapping("/form-data")
    public FormData postData(@RequestBody FormData formData){

        return formService.postData(formData);
    }

    @GetMapping("/read-form-data")
    public List<FormData> getAllFormData(){
        return formService.getAllFormData();
    }

    @DeleteMapping("/form-data/{id}")
    public ResponseEntity<?> deleteData(@PathVariable Long id){
        try{
            formService.deleteData(id);
            return new ResponseEntity<>("Data with ID " + id + " deleted successfully", HttpStatus.OK);

        }catch (EntityNotFoundException e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

}

}
