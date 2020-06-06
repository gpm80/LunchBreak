package ru.hakaton.rutech.ui.room;

import android.os.Bundle;
import android.os.PersistableBundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import ru.hakaton.rutech.R;

/**
 * Created by Petr Gusarov
 */
public class RoomDetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room_list);
    }
}
