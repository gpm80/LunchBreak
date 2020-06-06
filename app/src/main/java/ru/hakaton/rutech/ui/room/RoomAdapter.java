package ru.hakaton.rutech.ui.room;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.hakaton.rutech.model.Room;

import java.util.ArrayList;
import java.util.List;

/**
 * Адаптер комнат
 */
public class RoomAdapter extends RecyclerView.Adapter<RoomHolder> {

    private final Context context;
    private List<Room> rooms;

    public RoomAdapter(Context context) {
        this.context = context;
        rooms = new ArrayList<>();
    }

    @NonNull
    @Override
    public RoomHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new RoomHolder(context, viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomHolder roomHolder, int pos) {
        Room room = rooms.get(pos);
        roomHolder.bind(room);
    }

    @Override
    public int getItemCount() {
        return rooms.size();
    }

    public void addAll(List<Room> all) {
        rooms.addAll(all);
        notifyDataSetChanged();
    }

    public void clear() {
        rooms.clear();
        notifyDataSetChanged();
    }
}
