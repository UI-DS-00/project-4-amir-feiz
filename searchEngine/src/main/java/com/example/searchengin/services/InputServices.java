package com.example.searchengin.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Slf4j
@AllArgsConstructor
@Service

public class InputServices implements InputServicesInterface {

    //this function changes strings to trees
    @Override
    public void buildTree() {

    }

    //getting file names
    @Override
    public File[] inputFromFile() {

        File file = new File("C:\\Users\\hp\\Desktop\\Desktop\\java\\SearchEngine\\project-4-amir-feiz\\EnglishData");
        File[] files = file.listFiles();
        for (File f : files) {
            System.out.println(f.getName());
        }
        return files;
    }

    // reading files to strings
    @Override
    public String readFiles() throws FileNotFoundException, InterruptedException {
        File[] files = inputFromFile();
        String input;
        for(File file: files){
            System.out.println(file.getName());

            try {
                //catching null file if existed
                Scanner sc = new Scanner(file);
                input = sc.nextLine();
                System.out.println(input);
                fileToAppropriateString(input);
                sc.close();
            }catch (Exception e){
                System.out.println("no line in file");
            }

        }

        return null;
    }

    @Override
    public String fileToAppropriateString(String string) {
        Character[] words = new Character[string.length()];



        return null;
    }


}