package com.shirtmain.shirtmain.controller;

import com.shirtmain.shirtmain.shirt.Shirt;
import com.shirtmain.shirtmain.shirt.ShirtRepository;
import com.shirtmain.shirtmain.shirt.ShirtRequestDTO;
import com.shirtmain.shirtmain.shirt.ShirtResponseDTO;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("shirt")

public class ShirtController {
    @Autowired
    private ShirtRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity saveShirt(@RequestBody @Valid ShirtRequestDTO data){
        Shirt shirtData = new Shirt(data);
        repository.save(shirtData);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<ShirtResponseDTO> getAll(){

        List<ShirtResponseDTO> shirtList = repository.findAll().stream().map(ShirtResponseDTO::new).toList();
        return shirtList;
    }

    @PutMapping
    @Transactional
    public ResponseEntity updateShirt(@RequestBody @Valid ShirtRequestDTO data){
        Optional<Shirt> optionalShirt = repository.findById(data.id());
        if (optionalShirt.isPresent()){
            Shirt shirt = optionalShirt.get();
            shirt.setTitle(data.title());
            shirt.setImage(data.image());
            shirt.setPrice(data.price());
            return ResponseEntity.ok(shirt);
        } else {
            return ResponseEntity.notFound().build();
        }


    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteShirt(@PathVariable String id){
        repository.deleteById(id);
        return ResponseEntity.noContent().build();

    }

    }
