package com.example.searchengin.controller;

import com.example.searchengin.model.Tree;
import com.example.searchengin.services.InputServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;

@RestController
@AllArgsConstructor
public class InputController {

    InputServices inputServices = new InputServices();
    Tree myTree;
    @GetMapping("/readFiles")
    public ResponseEntity<String> f1() throws FileNotFoundException, InterruptedException {
        return new ResponseEntity<>(inputServices.readFilesAndBuildTree(), HttpStatus.OK);
    }

    @GetMapping("/searchWord")
    public ResponseEntity<Boolean> f2() {
        return new ResponseEntity<>(myTree.wordExist("Covington"), HttpStatus.OK);
    }
}
