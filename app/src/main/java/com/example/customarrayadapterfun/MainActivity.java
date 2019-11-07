package com.example.customarrayadapterfun;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create and populate contact list
        final List<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Bob", "(111)111-1111"));
        contacts.add(new Contact("Alice", "(222)222-2222"));
        contacts.add(new Contact());

        //create listview, set it to content view
        ListView listView = new ListView(this);
        setContentView(listView);

        //moving beyond s_l_i_1 to s_l_i_2, subclass arrayAdapter and override getView();
        //getView returns an item for each item in the data source
        //do it twice, once for s_l_i_1, once for s_l_i_2

        //create adapter, link it to listview
        ArrayAdapter<Contact> contactArrayAdapter = new ArrayAdapter<Contact>( //if there are multiple views, tell it
                //which is the main view
                this, android.R.layout.simple_list_item_2, android.R.id.text1, contacts
        ) {
            //Inflate a layout for each row
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);
                Contact contact = contacts.get(position);
                //we can set values for subviews of the view
                //for s_l_i_1, no subview
                /* for S_L_I_1
                TextView tv1 = (TextView) view.findViewById(android.R.id.text1);
                tv1.setText(contact.toString());
                */
                //2. simple list item 2
                TextView tv1 = view.findViewById(android.R.id.text1);
                TextView tv2 = view.findViewById(android.R.id.text2);
                tv1.setText(contact.toString());
                tv2.setText(contact.getPhoneNumber());
                return view;
            }
        };

        listView.setAdapter(contactArrayAdapter);
    }
}
