package ru.hakaton.rutech.ui.room;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import ru.hakaton.rutech.R;
import ru.hakaton.rutech.model.Room;
import ru.hakaton.rutech.service.RoomService;
import ru.hakaton.rutech.service.UserService;

import java.util.List;

/**
 * Created by Petr Gusarov
 */
public class RoomListActivity extends AppCompatActivity {

    private RoomAdapter roomAdapter;
    private MediaPlayer mediaPlayer;
    private boolean isMusicStarted = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
        RecyclerView roomList = findViewById(R.id.room_list_view);
        roomList.setLayoutManager(new GridLayoutManager(this, 2));
        roomAdapter = new RoomAdapter(this);
        roomList.setAdapter(roomAdapter);

        findViewById(R.id.add_room_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoomListActivity.this, R.string.todo_message, Toast.LENGTH_LONG).show();
            }
        });

        int maxVolume = 50;

        AudioManager am = (AudioManager) getSystemService(AUDIO_SERVICE);
        int currVolume= am.getStreamVolume(AudioManager.STREAM_MUSIC);
        float log1=(float)(Math.log(maxVolume-currVolume)/Math.log(maxVolume));

        mediaPlayer = MediaPlayer.create(this, R.raw.betty_swing);
        mediaPlayer.setVolume(0.01f, 0.01f);
        mediaPlayer.start();
        isMusicStarted = true;

        FloatingActionButton myFab = (FloatingActionButton) findViewById(R.id.pause_music);
        myFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                FloatingActionButton fab = (FloatingActionButton)v;
                if (isMusicStarted) {
                    mediaPlayer.pause();
                    isMusicStarted = false;
                    fab.setImageResource(android.R.drawable.ic_media_play);

                } else {
                    mediaPlayer.start();
                    isMusicStarted = true;
                    fab.setImageResource(android.R.drawable.ic_media_pause);
                }
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Room> all = RoomService.get().getAll(UserService.get().current());
        Log.i(this.getClass().getSimpleName(), "size rooms: " + all.size());
        roomAdapter.clear();
        roomAdapter.addAll(all);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
        mediaPlayer = null;
    }

}
