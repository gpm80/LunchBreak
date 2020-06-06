package ru.hakaton.rutech.ui.room;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import ru.hakaton.rutech.R;
import ru.hakaton.rutech.service.RoomService;
import ru.hakaton.rutech.service.UserService;

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
        RoomAdapter roomAdapter = new RoomAdapter(this);
        roomList.setAdapter(roomAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        roomAdapter.clear();
        roomAdapter.addAll(RoomService.get().getAll(UserService.get().current()));
    }
}
