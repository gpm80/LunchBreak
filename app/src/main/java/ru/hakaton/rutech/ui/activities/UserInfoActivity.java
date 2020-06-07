package ru.hakaton.rutech.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ru.hakaton.rutech.R;
import ru.hakaton.rutech.ui.room.RoomListActivity;

public class UserInfoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mEnterButton;
    private EditText mNameEditTect;
    private EditText mSurnameEditTect;
    private EditText mCompanyNameEditTect;
    private TextView mStatus;
    private ImageView mLeftArrow;
    private ImageView mRightArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        mEnterButton = findViewById(R.id.bt_enter_user);
        mEnterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_enter_user:
                   startTablesActivity();
                break;
        }
    }

    private void startTablesActivity() {
        Intent intent = new Intent(this, RoomListActivity.class);
        startActivity(intent);
        finish();
    }
}
