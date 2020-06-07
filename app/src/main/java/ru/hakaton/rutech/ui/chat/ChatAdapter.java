package ru.hakaton.rutech.ui.chat;

import android.content.Context;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import ru.hakaton.rutech.model.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Petr Gusarov
 */
public class ChatAdapter extends RecyclerView.Adapter<ChatHolder> {

    private final Context context;
    private List<Message> messages;

    public ChatAdapter(Context context) {
        this.context = context;
        messages = new ArrayList<>();
    }

    @NonNull
    @Override
    public ChatHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ChatHolder(context, viewGroup);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatHolder chatHolder, int pos) {
        chatHolder.bind(messages.get(pos));
    }

    public void clear() {
        messages.clear();
    }

    public boolean addAll(List<Message> values) {
        boolean b = messages.addAll(values);
        notifyDataSetChanged();
        return b;
    }

    public void add(Message message) {
        messages.add(message);
        notifyItemInserted(messages.size() - 1);
    }

    @Override
    public int getItemCount() {
        return messages.size();
    }
}
