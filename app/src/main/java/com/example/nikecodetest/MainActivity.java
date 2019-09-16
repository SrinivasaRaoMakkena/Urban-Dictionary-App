package com.example.nikecodetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import rx.Subscriber;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;

import com.example.nikecodetest.databinding.ActivityMainBinding;
import com.example.nikecodetest.model.WordDefinition;
import com.example.nikecodetest.model.WordDefinitions;
import com.example.nikecodetest.network.DictionaryRetrofitManager;
import com.example.nikecodetest.viewmodel.DictionaryViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);


        binding.searchTextView.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 1) {
                    DictionaryViewModel viewModel = new DictionaryViewModel(MainActivity.this, s.toString());

                    binding.setViewModel(viewModel);

                    binding.executePendingBindings();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


    }
}

