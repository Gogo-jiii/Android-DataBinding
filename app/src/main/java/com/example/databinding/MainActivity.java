package com.example.databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.databinding.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.btnClick.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                User user = new User("IT wala");
                binding.setUser(user);

                ArrayList<String> list = new ArrayList<>();
                list.add("A");
                list.add("B");
                list.add("C");

                binding.setList(list);
                binding.setIndex(0);

                binding.textViewListItems.setText(list.get(binding.getIndex()));
            }
        });

        binding.btnSecondActivity.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }
}
