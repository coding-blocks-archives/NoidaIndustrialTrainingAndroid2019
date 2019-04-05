package com.codingblocks.listviewcustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class PersonAdapter extends BaseAdapter {

    private static final long TYPE_TEXT_RECEIVED = 0;
    private static final long TYPE_TEXT_SENT = 1;
    private static final long TYPE_IMAGE_RECEIVED = 2;
    private static final long TYPE_IMAGE_SENT = 3;
    private static final long TYPE_DOC_RECEIVED = 4;
    private static final long TYPE_DOC_SENT = 5;

    private ArrayList<Person> people;
    private Context ctx;

    public PersonAdapter(ArrayList<Person> people, Context context) {
        this.people = people;
        ctx = context;
    }

    @Override
    public int getCount() {
        return people.size();
    }

    @Override
    public Person getItem(int position) {
        return people.get(position);
    }

    @Override
    public long getItemId(int position) {
//        Person currentPerson = getItem(position);
//
//        if (currentPerson.getMessageType().equals("text_sent")){
//            return TYPE_TEXT_SENT;
//        }else if (currentPerson.getMessageType().equals("text_received")){
//            return TYPE_TEXT_RECEIVED;
//        }
        return 0;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {

        Person currentPerson = getItem(position);


//        LayoutInflater li = (LayoutInflater)
//                ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        LayoutInflater li = LayoutInflater.from(ctx);

//        switch (getItemId(position)){
//
//
//            case TYPE_TEXT_SENT :
//
//
//            case TYPE_IMAGE_RECEIVED :
//
//        }

        //The second parameter is the parent
        //viewgroup which will provide the inflated view with its width and height

        //The third parameter specifies if you want to add the inflated layout to your parent viewgroup or not.
        //If false, the view isn't added; else it is added.
        //For BaseAdapter,this will always be false because the view returned by getView()
        //is added to the parent automatically by the BaseAdapter

        View inflatedView = li.inflate(R.layout.item_row,
                parent,
                false);

        ImageView ivProfile = inflatedView.findViewById(R.id.ivProfilePic);
        TextView tvName = inflatedView.findViewById(R.id.tvName);
        TextView tvDateOfBirth = inflatedView.findViewById(R.id.tvDateOfBirth);
        TextView tvContact = inflatedView.findViewById(R.id.tvContact);
        TextView tvAddress = inflatedView.findViewById(R.id.tvAddress);

        tvName.setText(currentPerson.getName());
        tvAddress.setText(currentPerson.getAddress());
        tvDateOfBirth.setText(currentPerson.getDateOfBirth());
        tvContact.setText(currentPerson.getPhoneNumber());

        Picasso.get().load(currentPerson.getPhotoUrl())
                .error(R.drawable.ic_error)
                .placeholder(R.drawable.ic_loading)
                .into(ivProfile);

        return inflatedView;
    }
}
