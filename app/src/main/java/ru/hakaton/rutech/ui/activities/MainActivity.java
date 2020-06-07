package ru.hakaton.rutech.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.OutputStream;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

import ru.hakaton.rutech.R;
import ru.hakaton.rutech.model.Message;
import ru.hakaton.rutech.service.MessageService;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mEnterButton;
    private EditText mCodeEditTect;
    List<Message> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterButton = findViewById(R.id.bt_enter_main);
        mCodeEditTect = findViewById(R.id.et_name);

        mEnterButton.setOnClickListener(this);
        MessageService.setDefaultListMessage();

        switch ((int) (Math.random() * 0)) {
            case 0:
                MessageService.getAllDefaultListMessage(0);
                list = new ArrayList<>();
                list.add(MessageService.getAllDefaultListMessage(0).get(0).get(0));
                list.add(MessageService.getAllDefaultListMessage(0).get(0).get(1));
                list.add(MessageService.getAllDefaultListMessage(0).get(0).get(2));
                list.add(MessageService.getAllDefaultListMessage(0).get(0).get(3));
                System.out.println(list.get(1).getParent() + " AAAAAAAAAA");
                System.out.println(list.get(1).getMessage() + " AAAAAAAAAA");
                System.out.println(list.get(1).getAttachments() + " AAAAAAAAAA");
                break;
            case 1:
                MessageService.getAllDefaultListMessage(1);
                list = new ArrayList<>();
                list.add(MessageService.getAllDefaultListMessage(1).get(0).get(0));
                list.add(MessageService.getAllDefaultListMessage(1).get(0).get(1));
                list.add(MessageService.getAllDefaultListMessage(1).get(0).get(2));
                list.add(MessageService.getAllDefaultListMessage(1).get(0).get(3));
                break;
            case 2:
                MessageService.getAllDefaultListMessage(2);
                list = new ArrayList<>();
                list.add(MessageService.getAllDefaultListMessage(2).get(0).get(0));
                list.add(MessageService.getAllDefaultListMessage(2).get(0).get(1));
                list.add(MessageService.getAllDefaultListMessage(2).get(0).get(2));
                list.add(MessageService.getAllDefaultListMessage(2).get(0).get(3));
            case 3:
                MessageService.getAllDefaultListMessage(3);
                list = new ArrayList<>();
                list.add(MessageService.getAllDefaultListMessage(3).get(0).get(0));
                list.add(MessageService.getAllDefaultListMessage(3).get(0).get(1));
                list.add(MessageService.getAllDefaultListMessage(3).get(0).get(2));
                list.add(MessageService.getAllDefaultListMessage(3).get(0).get(3));
            case 4:
                MessageService.getAllDefaultListMessage(4);
                list = new ArrayList<>();
                list.add(MessageService.getAllDefaultListMessage(4).get(0).get(0));
                list.add(MessageService.getAllDefaultListMessage(4).get(0).get(1));
                list.add(MessageService.getAllDefaultListMessage(4).get(0).get(2));
                list.add(MessageService.getAllDefaultListMessage(4).get(0).get(3));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_enter_main:
                String code = mCodeEditTect.getText().toString();
                //if (code.equals("658166")) {
                startUserInfoActivity();
                /*} else {
                    Toast.makeText(this,
                            "Please enter correct code",
                            Toast.LENGTH_SHORT).show();
                }*/
                break;
        }
    }

    private void startUserInfoActivity() {
        Intent intent = new Intent(this, UserInfoActivity.class);
        startActivity(intent);
        finish();
    }
}
