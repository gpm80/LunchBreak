package ru.hakaton.rutech.ui.room;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ru.hakaton.rutech.R;
import ru.hakaton.rutech.model.Room;

/**
 * Created by Petr Gusarov
 */
public class RoomHolder extends RecyclerView.ViewHolder {

    private TextView title;
    private TextView description;

    public RoomHolder(Context context, ViewGroup group) {
        super(LayoutInflater.from(context).inflate(R.layout.item_room, group, false));
        title = itemView.findViewById(R.id.room_item_title);
        description = itemView.findViewById(R.id.room_item_description);
    }

    public void bind(Room room) {
        title.setText(room.getTitle());
        description.setText(room.getDescription());
    }
}
