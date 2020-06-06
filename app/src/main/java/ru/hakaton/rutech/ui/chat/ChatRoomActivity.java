package ru.hakaton.rutech.ui.chat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.apache.commons.lang3.StringUtils;
import ru.hakaton.rutech.R;
import ru.hakaton.rutech.model.Message;
import ru.hakaton.rutech.model.Room;
import ru.hakaton.rutech.service.MessageService;
import ru.hakaton.rutech.service.RoomService;
import ru.hakaton.rutech.service.UserService;

/**
 * Created by Petr Gusarov
 */
public class ChatRoomActivity extends AppCompatActivity {

    public static final String KEY_ROOM = "key-room";
    private EditText sendText;
    private Room currentRoom;
    private ChatAdapter chatAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Intent intent = getIntent();
        currentRoom = RoomService.get().getRoomById(
                UserService.get().current(), intent.getStringExtra(KEY_ROOM));
        if (currentRoom == null) {
            finish();
        }
        chatAdapter = new ChatAdapter(this);
        RecyclerView chatList = findViewById(R.id.chat_list_view);
        chatList.setLayoutManager(new LinearLayoutManager(this));
        chatList.setAdapter(chatAdapter);

        sendText = findViewById(R.id.send_message_text_view);
        ImageButton sendButton = findViewById(R.id.send_message_send_button);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage();
            }
        });
        chatAdapter.addAll(MessageService.get().getAll(currentRoom));
    }

    private void sendMessage() {
        String message = sendText.getText().toString();
        if (StringUtils.isNoneBlank(message)) {
            Message mess = new Message();
            mess.setMessage(message);
            mess.setParent(UserService.get().current());
            Message sended = MessageService.get().send(currentRoom, mess);
            chatAdapter.add(sended);
        }
    }


}
