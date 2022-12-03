package com.example.searchengin.services;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public interface InputServicesInterface {
    public File[] inputFromFile();
    public String readFilesAndBuildTree() throws FileNotFoundException, InterruptedException;
    public ArrayList<String> fileToAppropriateString(String string,String str);
}
