package com.example.demo.service;

import com.example.demo.entity.FormData;
import com.example.demo.repository.FormRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FormService {
    private final FormRepository formRepository;

    public FormData postData(FormData formData){
        return formRepository.save(formData);
    }

    public List<FormData> getAllFormData(){
        return formRepository.findAll();
    }

    public void deleteData(Long id){
        if(!formRepository.existsById(id)){
            throw new EntityNotFoundException("Data with ID " +id+ " Not Found");
        }
        formRepository.deleteById(id);
    }

}
