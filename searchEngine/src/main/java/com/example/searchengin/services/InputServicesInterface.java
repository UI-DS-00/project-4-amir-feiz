package com.example.searchengin.services;

import java.io.File;
import java.io.FileNotFoundException;

public interface InputServicesInterface {
    public void buildTree();
    public File[] inputFromFile();
    public String readFiles() throws FileNotFoundException, InterruptedException;
    public String fileToAppropriateString(String string);
}
