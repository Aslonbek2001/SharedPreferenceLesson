package com.aslon.sharedpreferencelesson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.aslon.sharedpreferencelesson.databinding.ActivityMainBinding;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        MyPreference preference = MyPreference.getShp();
    /*    binding.textView.setText(preference.getString("input","saqlanmagan"));

        binding.btn.setOnClickListener(v -> {
            String text = binding.textInput.getText().toString();
            if (!text.isEmpty()){
                preference.edit().putString("input",text).apply();
            }else {
                Toast.makeText(this, "Maydon to'ldirilsin", Toast.LENGTH_SHORT).show();
            }
        });

        binding.delete.setOnClickListener(v->{
            preference.edit().remove("input").apply();
        });

        preference.registerOnSharedPreferenceChangeListener((sharedPreferences, key) -> {
            if (key.equals("input")){
                binding.textView.setText(sharedPreferences.getString("input","saqlanmagan"));
            }
        });*/
        MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.button_click);

        if (preference.getSoundState()) {
            binding.soundIcon.setImageResource(R.drawable.ic_round_volume_up_24);
        } else {
            binding.soundIcon.setImageResource(R.drawable.ic_round_volume_off_24);
        }

        binding.btn.setOnClickListener(v -> {
            if (preference.getSoundState())
                mediaPlayer.start();
        });

        binding.soundIcon.setOnClickListener(v -> {
            Boolean state = preference.getSoundState();

            if (state) {
                binding.soundIcon.setImageResource(R.drawable.ic_round_volume_off_24);
            } else {
                binding.soundIcon.setImageResource(R.drawable.ic_round_volume_up_24);
            }

            preference.changeSoundState(!state);
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}