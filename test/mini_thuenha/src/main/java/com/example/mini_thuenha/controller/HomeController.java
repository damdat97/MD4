package com.example.mini_thuenha.controller;

import com.example.mini_thuenha.model.DTO;
import com.example.mini_thuenha.model.Home;
import com.example.mini_thuenha.service.impl.HomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/home")
public class HomeController {
    @Autowired
    private HomeService homeService;

    @GetMapping
    public ResponseEntity<DTO<Page<Home>>> findAll(@PageableDefault(value = 3) Pageable pageable) {
        return new ResponseEntity<>(new DTO<Page<Home>>("Lấy danh sách thành công", homeService.findAll(pageable), "OK"), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Home> handleFileUpload(@Valid @RequestParam("file") MultipartFile file, Home home) {
        String fileName = file.getOriginalFilename();
        home.setImage(fileName);
        try {
            file.transferTo(new File("D:\\MD4\\test\\mini_thuenha\\src\\main\\resources\\templates\\image\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        homeService.save(home);
        return new ResponseEntity<>(HttpStatus.OK) ;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Home>> findById(@PathVariable Long id) {
        return new ResponseEntity<>(homeService.findById(id), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Home> update(@RequestParam("fileEdit") MultipartFile file, @PathVariable Long id, Home home) {
        Optional<Home> homeOptional = homeService.findById(id);
        if(!homeOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        String fileName = file.getOriginalFilename();
        home.setImage(fileName);
        try {
            file.transferTo(new File("D:\\MD4\\test\\mini_thuenha\\src\\main\\resources\\templates\\image\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        home.setId(homeOptional.get().getId());
        homeService.save(home);
        return new ResponseEntity<>(home, HttpStatus.CREATED);
    }
}
