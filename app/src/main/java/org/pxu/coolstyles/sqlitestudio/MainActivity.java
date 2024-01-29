package org.pxu.coolstyles.sqlitestudio;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler dbHandler;
    private ListView listV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHandler = new DatabaseHandler(this);
        listV = findViewById(R.id.listV);

        displayData();
    }

    private void displayData() {
        List<User> userList = dbHandler.getAllUsers();

        List<String> userInformation = new ArrayList<>();
        for (User user : userList) {
            String userInfo = "ID: " + user.getId() +
                    "\nEmail: " + user.getEmail() +
                    "\nPassword: " + user.getPassword() +
                    "\nRole: " + user.getRole() + "\n";

            userInformation.add(userInfo);
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, userInformation);
        listV.setAdapter(adapter);
    }
}
