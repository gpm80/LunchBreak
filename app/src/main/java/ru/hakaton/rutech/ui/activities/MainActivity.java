package ru.hakaton.rutech.ui.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import ru.hakaton.rutech.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mEnterButton;
    private EditText mCodeEditTect;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mEnterButton = findViewById(R.id.bt_enter_main);
        mCodeEditTect = findViewById(R.id.et_name);

        mEnterButton.setOnClickListener(this);
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
