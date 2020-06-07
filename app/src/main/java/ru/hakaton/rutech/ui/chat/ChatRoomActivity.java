package ru.hakaton.rutech.ui.chat;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

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
    private RecyclerView chatList;
    List<Message> list;

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
        chatList = findViewById(R.id.chat_list_view);
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
        jump();

        //chatAdapter.clear();
        switch ((int) (Math.random() * 4)) {
            case 0:
                MessageService.getAllDefaultListMessage(0);
                list = new ArrayList<>();
                for(int i = 0; i < 4; i++) {
                    list.add(MessageService.getAllDefaultListMessage(0).get(0).get(i));
                    sendMessage(list.get(i).getMessage());
                }
                break;
            case 1:
                MessageService.getAllDefaultListMessage(1);
                list = new ArrayList<>();
                for(int i = 0; i < 4; i++) {
                    list.add(MessageService.getAllDefaultListMessage(1).get(0).get(i));
                    sendMessage(list.get(i).getMessage());
                }
                break;
            case 2:
                MessageService.getAllDefaultListMessage(2);
                list = new ArrayList<>();
                for(int i = 0; i < 4; i++) {
                    list.add(MessageService.getAllDefaultListMessage(2).get(0).get(i));
                    sendMessage(list.get(i).getMessage());
                }
            case 3:
                MessageService.getAllDefaultListMessage(3);
                list = new ArrayList<>();
                for(int i = 0; i < 4; i++) {
                    list.add(MessageService.getAllDefaultListMessage(3).get(0).get(i));
                    sendMessage(list.get(i).getMessage());
                }
            case 4:
                MessageService.getAllDefaultListMessage(4);
                list = new ArrayList<>();
                for(int i = 0; i < 4; i++) {
                    list.add(MessageService.getAllDefaultListMessage(4).get(0).get(i));
                    sendMessage(list.get(i).getMessage());
                }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void sendMessage(String message) {
        if (StringUtils.isNoneBlank(message)) {
            Message mess = new Message();
            mess.setMessage(message);
            mess.setParent(UserService.get().current());
            Message sended = MessageService.get().send(currentRoom, mess);
            chatAdapter.add(sended);
            sendText.getText().clear();
            jump();
        }
    }

    private void sendMessage() {
        String message = sendText.getText().toString();
        if (StringUtils.isNoneBlank(message)) {
            Message mess = new Message();
            mess.setMessage(message);
            mess.setParent(UserService.get().current());
            Message sended = MessageService.get().send(currentRoom, mess);
            chatAdapter.add(sended);
            sendText.getText().clear();
            jump();
        }
    }

    private void jump() {
        try {
            chatList.scrollToPosition(chatAdapter.getItemCount() - 1);
        } catch (Exception e) {
            Log.i(this.getClass().getSimpleName(), "an error jump", e);
        }

    }
}
