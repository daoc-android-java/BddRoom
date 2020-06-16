package com.example.bddroom;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                "misUsuarios").build();

        new Thread() {
            @Override
            public void run() {
                db.userDao().insertAll(new User("Carlos", "Pérez"), new User("Luisa", "López"));
                List<User> list = db.userDao().getAll();
                System.out.println(list);
            }
        }.start();
    }
}