package ru.hakaton.rutech.ui.room;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import org.apache.commons.lang3.StringUtils;
import ru.hakaton.rutech.R;
import ru.hakaton.rutech.model.Room;

/**
 * Created by Petr Gusarov
 */
public class RoomHolder extends RecyclerView.ViewHolder {

    private final Context context;
    private TextView title;
    private TextView description;
    private Room currentRoom;

    public RoomHolder(Context context, ViewGroup group) {
        super(LayoutInflater.from(context).inflate(R.layout.item_table, group, false));
        this.context = context;
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });
        title = itemView.findViewById(R.id.room_item_title);
        title.setSelected(true);
        description = itemView.findViewById(R.id.room_item_description);
    }

    private void open() {
        if (currentRoom != null) {
            Intent intent = new Intent(context, RoomDetailActivity.class);
            intent.putExtra(RoomDetailActivity.KEY_ROOM, currentRoom.getUid());
            context.startActivity(intent);
        }
    }

    public void bind(Room room) {
        currentRoom = room;
        title.setText(room.getTitle());
        description.setText(StringUtils.abbreviate(room.getDescription(), 80));
    }
}
