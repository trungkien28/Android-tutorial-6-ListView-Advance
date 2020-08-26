package com.example.listviewadvance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IOnChildItemClick {

    private List<ContactModel> listContact = new ArrayList<>();
    private ListView lvContact;
    private ContactAdapter mAdapter;
    private ImageView ivUser;
    private TextView tvName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();

        mAdapter = new ContactAdapter(this, listContact);
        mAdapter.registerChildItemClick(this);
        lvContact.setAdapter(mAdapter);
        lvContact.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ContactModel model = listContact.get(i);
                Toast.makeText(MainActivity.this, model.getName() + ": " + model.getPhone(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void initView() {
        lvContact = (ListView) findViewById(R.id.lvContact);
        ivUser = (ImageView) findViewById(R.id.ivUser);
        tvName = (TextView) findViewById(R.id.tvName);
    }

    private void initData() {
        listContact.add(new ContactModel("Nguyen Trung Kien", "0915350236", R.drawable.ic_u1));
        listContact.add(new ContactModel("Nguyen Ngoc Son", "0978543188", R.drawable.ic_u2));
        listContact.add(new ContactModel("Doan Manh Thang", "0914987464", R.drawable.ic_u3));
        listContact.add(new ContactModel("Mai Ngoc Toan", "0906586987", R.drawable.ic_u4));
        listContact.add(new ContactModel("Doan Van Quang", "091798795", R.drawable.ic_u3));
        listContact.add(new ContactModel("Vu Le Duy", "099999999", R.drawable.ic_u2));
        listContact.add(new ContactModel("Dang Tien Duoc", "0935487852", R.drawable.ic_u4));
        listContact.add(new ContactModel("Nguyen Trung Kien", "0915350236", R.drawable.ic_u1));
        listContact.add(new ContactModel("Nguyen Trung Kien", "0915350236", R.drawable.ic_u3));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    @Override
    public void onItemChildClick(int position) {
        ContactModel contact = listContact.get(position);
        ivUser.setImageResource(contact.getImage());
        tvName.setText(contact.getName());
    }
}