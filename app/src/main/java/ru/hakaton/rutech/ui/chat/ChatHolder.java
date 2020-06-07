package ru.hakaton.rutech.ui.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import ru.hakaton.rutech.R;
import ru.hakaton.rutech.model.Message;

/**
 * Created by Petr Gusarov
 */
public class ChatHolder extends RecyclerView.ViewHolder {

    private final Context context;
    private Message currentMessage;
    private TextView userName;
    private TextView userMessage;

    public ChatHolder(Context context, ViewGroup group) {
        super(LayoutInflater.from(context).inflate(R.layout.item_chat, group, false));
        this.context = context;
        userName = itemView.findViewById(R.id.chat_item_user);
        userMessage = itemView.findViewById(R.id.chat_item_message);
    }

    public void bind(Message message) {
        currentMessage = message;
        userName.setText(message.getParent().getName());
        userMessage.setText(message.getMessage());
        //todo картинку подгрузить
    }
}
