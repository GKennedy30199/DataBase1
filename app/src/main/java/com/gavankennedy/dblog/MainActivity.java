package com.gavankennedy.dblog;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DataBaseHelper db = new DataBaseHelper(this);

        Log.i("Insert: ", "Inserting ..");
        db.addContact(new Contact("Joe", "0873456789"));
        db.addContact(new Contact("Mary", "0863111122"));
        db.addContact(new Contact("Jack", "0859999888"));
        db.addContact(new Contact("Andrew", "083334444"));
        db.addContact(new Contact("Harold", "0831112222"));
        db.addContact(new Contact("Joe", "0835554444"));

        Log.i("Reading: ", "Reading all contacts..");
        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " +
                    cn.getPhoneNumber();
            // Writing Contacts to log
            Log.i("Name: ", log);
        }
        Log.i("divider", "====================");

        Contact singleUser = db.getContact(5);
        Log.i("contact 5 is ", singleUser.getName());

        Log.i("divider", "====================");

        int userCount = db.getContactsCount();
        Log.i("User count: ", String.valueOf(userCount));


    }
}