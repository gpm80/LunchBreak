package ru.hakaton.rutech.ui.room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ru.hakaton.rutech.R;
import ru.hakaton.rutech.model.Room;
import ru.hakaton.rutech.service.RoomService;
import ru.hakaton.rutech.service.UserService;

/**
 * Детальное отображение стола
 */
public class RoomDetailActivity extends AppCompatActivity {

    public static final String KEY_ROOM = "key-room";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_detail);
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra(KEY_ROOM);
        Room room = RoomService.get().getRoomById(UserService.get().current(), stringExtra);
        if (room == null) {
            finish();
        }
        TextView title = findViewById(R.id.room_detail_title);
        TextView description = findViewById(R.id.room_detail_description);
        title.setText(room.getTitle());
        description.setText(room.getDescription());
        findViewById(R.id.room_detail_join_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoomDetailActivity.this, R.string.todo_message, Toast.LENGTH_LONG).show();
            }
        });
        findViewById(R.id.room_detail_cancel_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
