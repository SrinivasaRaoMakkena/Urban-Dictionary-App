package com.example.nikecodetest.network;

import com.example.nikecodetest.model.WordDefinition;
import com.example.nikecodetest.model.WordDefinitions;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface DictionaryService {

    @GET("define")
    Observable<WordDefinitions> getWordDefinitions(@Query("term") String word);


}
