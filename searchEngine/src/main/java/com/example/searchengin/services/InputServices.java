package com.example.searchengin.services;

import com.example.searchengin.model.Tree;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Slf4j
@AllArgsConstructor
@Service

public class InputServices implements InputServicesInterface {

    public static Tree mainTree = new Tree();

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //getting file names
    @Override
    public File[] inputFromFile() {

        File file = new File
                ("C:\\Users\\hp\\Desktop\\Desktop\\java\\SearchEngine\\project-4-amir-feiz\\EnglishData");
        File[] files = file.listFiles();
        return files;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // reading files to strings
    @Override
    public String readFilesAndBuildTree() throws FileNotFoundException, InterruptedException {
        File[] files = inputFromFile();
        String input;
        ArrayList<String> nonNullOutput;
        for(File file: files){


            String fileName = file.getName();

            System.out.println(fileName);
            try {
                //catching null file if existed
                Scanner sc = new Scanner(file);
                input = sc.nextLine();
                nonNullOutput = fileToAppropriateString(input,fileName);

                for (String s: nonNullOutput){
                    mainTree.add(s,fileName);
                }
                sc.close();
            }catch (NullPointerException | NoSuchElementException e){
                System.out.println("no line in file");
                System.out.println(fileName);
            }
        }
        mainTree.rootChildrenNum();
        return null;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    //changes words with syntax to string without syntax
    @Override
    public ArrayList<String> fileToAppropriateString(String inputString,String fileName) {
        String correctedWords = "";
        char charAtIndex;
        for(int i =0;i<inputString.length();i++){
            charAtIndex = inputString.charAt(i);
            if((charAtIndex >= 65 &&  charAtIndex <=90)
                    || (charAtIndex >= 97 &&  charAtIndex <=122))
                correctedWords+= charAtIndex;
            else if(charAtIndex == 32)
                try {
                    if (inputString.charAt(i + 1) == 32) {
                        continue;
                    } else {
                        correctedWords += charAtIndex;
                    }
                }catch (StringIndexOutOfBoundsException se){
                    System.out.println("index out of bond");
                    System.out.println(fileName);

                }
            else {
                correctedWords+= " ";
            }
        }
        String[] output = correctedWords.split(" ");
        ArrayList<String> nonNullOutput = new ArrayList<>();


        for (String st:output){
            if (!st.equals("")){
                nonNullOutput.add(st);
//                System.out.println(st);
            }
        }
        return nonNullOutput;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}