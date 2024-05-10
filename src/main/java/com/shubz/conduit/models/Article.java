package com.shubz.conduit.models;

import java.util.List;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Article {

    private int id;
    
    private String title;
    private String content;
    private String description;
    private String author;
    private List<String> tags;




}
