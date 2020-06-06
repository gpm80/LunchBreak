package ru.hakaton.rutech;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MainActivity extends AppCompatActivity {
    Properties properties = new Properties();
    FileOutputStream fileOutputStream;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createUser();
        System.out.println(user.toString() + " aaaaaaa");
    }

    private void createUser() {
        user = new User("people", "John", Value.Second);
        setProperties(user);
    }

    private void setProperties(User user) {
        File file = new File("/data/user/0/ru.hakaton.rutech/files");
        file.mkdirs();
        try {
            fileOutputStream = new FileOutputStream("/data/user/0/ru.hakaton.rutech/files/resource.txt");
            properties.setProperty("identify", user.getIdentify());
            properties.setProperty("name", user.getName());
            properties.setProperty("enum", String.valueOf(user.getValue()));
            properties.store(fileOutputStream, null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public User getUser() {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("/files/resource.txt")) {
            properties.load(fileInputStream);
            user.setIdentify(properties.getProperty("identify"));
            user.setName(properties.getProperty("name"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return user;
    }
}
