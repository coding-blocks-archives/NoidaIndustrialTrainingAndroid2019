package com.codingblocks.heterogeneousrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<WhatsappMessage> messages = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messages.add(new WhatsappMessage("Hello",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_SENT));
        messages.add(new WhatsappMessage("What's up?",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_SENT));
        messages.add(new WhatsappMessage("Hey!",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("All good",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("What's going on?",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("Pizza tonight?",
                "" + System.currentTimeMillis(),
                MessageType.IMAGE_SENT));
        messages.add(new WhatsappMessage("Yep!",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));

        messages.add(new WhatsappMessage("Hello",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_SENT));
        messages.add(new WhatsappMessage("What's up?",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_SENT));
        messages.add(new WhatsappMessage("Hey!",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("All good",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("What's going on?",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("Pizza tonight?",
                "" + System.currentTimeMillis(),
                MessageType.IMAGE_SENT));
        messages.add(new WhatsappMessage("Yep!",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));

        messages.add(new WhatsappMessage("Hello",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_SENT));
        messages.add(new WhatsappMessage("What's up?",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_SENT));
        messages.add(new WhatsappMessage("Hey!",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("All good",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("What's going on?",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));
        messages.add(new WhatsappMessage("Pizza tonight?",
                "" + System.currentTimeMillis(),
                MessageType.IMAGE_SENT));
        messages.add(new WhatsappMessage("Yep!",
                "" + System.currentTimeMillis(),
                MessageType.TEXT_RECEIVED));

        MessageAdapter messageAdapter = new MessageAdapter(messages, this);
        RecyclerView rvMessages = findViewById(R.id.rvMessages);

        rvMessages.setLayoutManager(new LinearLayoutManager(this));

        rvMessages.setAdapter(messageAdapter);

    }
}
