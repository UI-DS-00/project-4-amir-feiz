package com.example.searchengin.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Tree {

    static private final Character root = null;

    class Node{

        char data;
        Set<Node> children;
        Node father;
        Boolean isEnd;
        Boolean hasNext;
    }


}
