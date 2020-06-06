package ru.hakaton.rutech.ui.room;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ru.hakaton.rutech.R;
import ru.hakaton.rutech.model.Room;
import ru.hakaton.rutech.service.MessageService;
import ru.hakaton.rutech.service.RoomService;
import ru.hakaton.rutech.service.UserService;

import java.util.List;

/**
 * Created by Petr Gusarov
 */
public class RoomListActivity extends AppCompatActivity {

    private RoomAdapter roomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
        RecyclerView roomList = findViewById(R.id.room_list_view);
        roomList.setLayoutManager(new LinearLayoutManager(this));
        roomAdapter = new RoomAdapter(this);
        roomList.setAdapter(roomAdapter);
        findViewById(R.id.add_room_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RoomListActivity.this, R.string.todo_message, Toast.LENGTH_LONG).show();
            }
        });
        System.out.println(MessageService.getDefaultListMessage() + "  Answer");
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Room> all = RoomService.get().getAll(UserService.get().current());
        Log.i(this.getClass().getSimpleName(), "size rooms: " + all.size());
        roomAdapter.clear();
        roomAdapter.addAll(all);
    }
}
