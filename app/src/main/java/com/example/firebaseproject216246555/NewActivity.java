package com.example.firebaseproject216246555;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class NewActivity extends AppCompatActivity {

    private FirebaseUser currentUser;
    private FirebaseAuth mAuth;
    private ListView mylistView;
    int[] IMAGES = {R.drawable.image1,R.drawable.image2,R.drawable.image3,R.drawable.image5,
            R.drawable.image6,R.drawable.image8,R.drawable.image5,R.drawable.image8};
    String[] NAMES = {"potato" , "cat meet" ,"bestceggs", "new fish" ,"italian piza" ,"special" ,"jargon" ,"time"};
    String[] DESCRIPTION = {"here available" ,"only wednesday" ,"free" ,"not available",
            "fast food","free to get it" , "low prices" , "weekend "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        mAuth = FirebaseAuth.getInstance();
        currentUser = mAuth.getCurrentUser();

        mylistView = (ListView)findViewById(R.id.listview);
        customAdapter customAdapter = new customAdapter();
        mylistView.setAdapter(customAdapter);

    }
    @Override
    protected void onStart() {
        super.onStart();
        if (currentUser == null)
        {
            Intent intent = new Intent(NewActivity.this,MainActivity.class);
            startActivity(intent);
        }
    }



    class customAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return IMAGES.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup parent) {

            view = getLayoutInflater().inflate(R.layout.listview,null);
            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            TextView textView_name = (TextView)view.findViewById(R.id.textView_name);
            TextView textView_description = (TextView)view.findViewById(R.id.textView_description);
            imageView.setImageResource(IMAGES[i]);
            textView_name.setText(NAMES[i]);
            textView_description.setText(DESCRIPTION[i]);
            return view;
        }
    }
}
