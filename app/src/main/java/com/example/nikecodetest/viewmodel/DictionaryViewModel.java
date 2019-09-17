package com.example.nikecodetest.viewmodel;

import android.content.Context;

import com.example.nikecodetest.adapter.WordDefinitionsAdapter;
import com.example.nikecodetest.model.WordDefinitions;
import com.example.nikecodetest.network.DictionaryRetrofitManager;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.OrientationHelper;
import androidx.recyclerview.widget.RecyclerView;
import rx.Subscriber;

public class DictionaryViewModel extends BaseObservable {

    private Context mContext;
    private WordDefinitionsAdapter adapter;
    private Subscriber<WordDefinitions> mDictionarySubscriber = null;

    public DictionaryViewModel(Context context, String word) {
        this.mContext = context;
        this.adapter = new WordDefinitionsAdapter(mContext);
        initSubscriber();
        DictionaryRetrofitManager.callWebService(DictionaryRetrofitManager.getSatScore(word), mDictionarySubscriber);
    }


    private void initSubscriber() {
        if (mDictionarySubscriber != null) {
            mDictionarySubscriber.unsubscribe();
            mDictionarySubscriber = null;
        }


        mDictionarySubscriber = new Subscriber<WordDefinitions>() {
            @Override
            public void onCompleted() {

                //isDataloading.set(false);
            }

            @Override
            public void onError(Throwable e) {
                //isDataloading.set(false);
                System.out.println("length " + e);
                //Toast.makeText(mContext, e.getMessage(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNext(WordDefinitions response) {
                

                WordDefinitions res = response;

                adapter.updateData(res.getWordDefinitions());


            }
        };


    }

    @Bindable
    public LinearLayoutManager getLayoutManager() {
        return new LinearLayoutManager(mContext, RecyclerView.VERTICAL, false);
    }

    @Bindable
    public WordDefinitionsAdapter getAdapter() {
        return this.adapter;
    }


}
