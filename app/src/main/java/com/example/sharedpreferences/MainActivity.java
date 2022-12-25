package com.example.sharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.sharedpreferences.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.btnMoveText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.textView.setText(binding.editTextTextPersonName.getText().toString());
            }
        });

        binding.save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveText();
            }
        });
        againLoadData();
    }

    private void saveText() {
    String apnaText = binding.textView.getText().toString();
    SharedPreferences preferences = getSharedPreferences("SharedPreferences",MODE_PRIVATE);
    SharedPreferences.Editor editor = preferences.edit();
//    editor.putString("text",binding.textView.getText().toString());
    editor.putString("text",apnaText);
    editor.putBoolean("switch",binding.switch1.isChecked());
    editor.apply();
    Toast.makeText(this, "Data is Saved", Toast.LENGTH_SHORT).show();
    }

    private void againLoadData(){
    String text;
    Boolean switchOnOff;
    SharedPreferences preferences = getSharedPreferences("SharedPreferences",MODE_PRIVATE);
    text = preferences.getString("text","");
    switchOnOff = preferences.getBoolean("switch", Boolean.parseBoolean("false"));

    binding.textView.setText(text);
    binding.switch1.setChecked(switchOnOff);

    }

}