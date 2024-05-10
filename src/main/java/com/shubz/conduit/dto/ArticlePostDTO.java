package com.shubz.conduit.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.As.WRAPPER_OBJECT;
import static com.fasterxml.jackson.annotation.JsonTypeInfo.Id.NAME;
import com.fasterxml.jackson.annotation.JsonTypeName;

import lombok.Data;


@JsonTypeName("article")
@JsonTypeInfo(include = WRAPPER_OBJECT, use = NAME)
@Data
public class ArticlePostDTO {

    private String title;

    private String description;

    private String body;

    private List<String> tagList;

}
