package com.example.nikecodetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WordDefinitions {

    @SerializedName("list")
    @Expose
    private List<WordDefinition> wordDefinitions = null;

    public List<WordDefinition> getWordDefinitions() {
        return wordDefinitions;
    }

    public void setWordDefinitions(List<WordDefinition> wordDefinitions) {
        this.wordDefinitions = wordDefinitions;
    }
}
