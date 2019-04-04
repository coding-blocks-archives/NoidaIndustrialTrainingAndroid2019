package com.codingblocks.listviewcustomadapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class StudentAdapter extends BaseAdapter {

    private ArrayList<Student> students;
    private Context context;

    public StudentAdapter(ArrayList<Student> students,
                          Context ctx) {
        this.students = students;
        this.context = ctx;
    }

    @Override
    public int getCount() {
        return students.size();
    }

    @Override
    public Student getItem(int position) {
        return students.get(position);
    }

    //TODO
    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position,
                        View convertView,
                        ViewGroup parent) {

        Student currentStudent = students.get(position);

        //Layout inflater to manually convert item_row.xml
        //to a Java class of the type View

        LayoutInflater li = (LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //TODO
        View inflatedView = li.inflate(R.layout.item_row,
                parent,
                false);

        TextView studentName = inflatedView.findViewById(R.id.tvName);
        TextView studentSurName = inflatedView.findViewById(R.id.tvSurName);
        TextView studentAddress = inflatedView.findViewById(R.id.tvAddress);
        TextView studentContact = inflatedView.findViewById(R.id.tvContact);

        studentName.setText(currentStudent.getName());
        studentContact.setText(currentStudent.getContact());
        studentAddress.setText(currentStudent.getAddress());
        studentSurName.setText(currentStudent.getSurName());

        return inflatedView;
    }

}
