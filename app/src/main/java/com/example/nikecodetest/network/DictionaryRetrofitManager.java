package com.example.nikecodetest.network;

import com.example.nikecodetest.model.WordDefinition;
import com.example.nikecodetest.model.WordDefinitions;

import java.util.List;

import rx.Observable;

public class DictionaryRetrofitManager extends BaseRetrofitManager {

    public static Observable<WordDefinitions> getSatScore(String word) {
        Observable<WordDefinitions> dictionaryDefinitions;

        DictionaryService dictionaryService
                = getRetrofit().create(DictionaryService.class);

        dictionaryDefinitions
                = dictionaryService.getWordDefinitions(word);


        return dictionaryDefinitions;
    }
}

