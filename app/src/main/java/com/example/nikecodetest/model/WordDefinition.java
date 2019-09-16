package com.example.nikecodetest.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WordDefinition implements Comparable<WordDefinition> {


    @SerializedName("definition")
    @Expose
    private String definition;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("thumbs_up")
    @Expose
    private String thumbsUp;
    @SerializedName("sound_urls")
    @Expose
    private List<Object> soundUrls = null;
    @SerializedName("author")
    @Expose
    private String author;
    @SerializedName("word")
    @Expose
    private String word;
    @SerializedName("defid")
    @Expose
    private Integer defid;
    @SerializedName("current_vote")
    @Expose
    private String currentVote;
    @SerializedName("written_on")
    @Expose
    private String writtenOn;
    @SerializedName("example")
    @Expose
    private String example;
    @SerializedName("thumbs_down")
    @Expose
    private String thumbsDown;

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbsUp() {
        return thumbsUp;
    }

    public void setThumbsUp(String thumbsUp) {
        this.thumbsUp = thumbsUp;
    }

    public List<Object> getSoundUrls() {
        return soundUrls;
    }

    public void setSoundUrls(List<Object> soundUrls) {
        this.soundUrls = soundUrls;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Integer getDefid() {
        return defid;
    }

    public void setDefid(Integer defid) {
        this.defid = defid;
    }

    public String getCurrentVote() {
        return currentVote;
    }

    public void setCurrentVote(String currentVote) {
        this.currentVote = currentVote;
    }

    public String getWrittenOn() {
        return writtenOn;
    }

    public void setWrittenOn(String writtenOn) {
        this.writtenOn = writtenOn;
    }

    public String getExample() {
        return example;
    }

    public void setExample(String example) {
        this.example = example;
    }

    public String getThumbsDown() {
        return thumbsDown;
    }

    public void setThumbsDown(String thumbsDown) {
        this.thumbsDown = thumbsDown;
    }


    @Override
    public int compareTo(WordDefinition definition) {
        return Integer.parseInt(definition.thumbsUp) - Integer.parseInt(this.thumbsUp);
    }
}
