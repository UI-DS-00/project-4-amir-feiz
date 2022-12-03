package com.example.searchengin.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.*;

@Component
@ToString
@Getter
@Setter
public class Tree {

    int counter = 0;
    static Node root = new Node();
    String fileName;
    Queue<Node> bfsQueue = new PriorityQueue<>();
    Node lastContainedNode = new Node();
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
static
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    class Node{

        Character data;
        ArrayList<Node> children = new ArrayList<>();
        Node father ;
        Boolean isEnd;
        Boolean hasNext;
        int dept;
        ArrayList<String> fileNames = new ArrayList<>();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Tree(){
        root = new Node(null,new ArrayList<>(),
                null, false,true,0,null);

        lastContainedNode = root;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void add(String input,String fileName){

        Node newNode = new Node();
        int length = input.length();
        lastContainedNode = root;
        for (int i=0;i<length;i++) {

            if(!bfsSearch(root,input.charAt(i))){
                for (int j=i;j<length;j++) {

                    newNode.setData(input.charAt(j));
                    newNode.setFather(lastContainedNode);
                    newNode.fileNames.add(fileName);
                    lastContainedNode.children.add(newNode);
                    lastContainedNode = newNode;
                    newNode = new Node();
                    counter++;
                }
                break;

            }
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public boolean wordExist(String word){

            char[] inputWord = new char[word.length()];
            inputWord = word.toCharArray();
            Node temp = root;
            int counter=0;

            try {
                while (counter != inputWord.length) {
                    for (Node tempNode : temp.getChildren()) {
                        if (inputWord[counter] == tempNode.getData()) {
                            temp = tempNode;
                            counter++;

                            if (counter == inputWord.length)
                                return true;

                        }
                    }
                    return false;
                    //lastContainedNode = node;
                }
                return true;
            }catch (NullPointerException ne){
                //System.out.println(counter);
                //lastContainedNode = root;
                return false;
            }
        }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean bfsSearch(Node node,char c){
        try {
            ArrayList<Node> childrenNodes = node.getChildren();
            for (Node tempNode : childrenNodes) {
                if (c == tempNode.getData()) {
                    lastContainedNode = tempNode;
                    return true;
                }
            }
            //lastContainedNode = node;
            return false;

        }catch (NullPointerException ne){
            //System.out.println(counter);
            //lastContainedNode = root;
            return false;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void rootChildrenNum(){
        System.out.println(root.children.size());

    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////


}