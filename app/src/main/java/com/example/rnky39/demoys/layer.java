package com.example.rnky39.demoys;

import android.support.v7.app.AppCompatActivity;

//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.View.OnClickListener;

//import com.google.firebase.auth.FirebaseAuth;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class layer extends AppCompatActivity implements OnClickListener {

    private CardView dietplan,alarm,steps,fitness,macros;
    private String username;
    private ArrayList<String> user_data;
    private ArrayList<String> user_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layer);

        Bundle bundle=getIntent().getExtras();
        this.username =bundle.getString("username");
        this.user_data=bundle.getStringArrayList("user_data");
        this.user_info=bundle.getStringArrayList("user_info");

        dietplan=(CardView) findViewById(R.id.diet_control);
        alarm=(CardView) findViewById(R.id.alarm);
        steps=(CardView) findViewById(R.id.steps);
        fitness=(CardView) findViewById(R.id.fitness);
        macros=(CardView) findViewById(R.id.macros_setup);

        dietplan.setOnClickListener(this);
        alarm.setOnClickListener(this);
        steps.setOnClickListener(this);
        fitness.setOnClickListener(this);
        macros.setOnClickListener(this);
    }


    public void logout(View view) {
//        FirebaseAuth.getInstance().signOut();//logout
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch(view.getId()){
            case R.id.diet_control:
                i=new Intent(this,HomeScreen.class);
                i.putExtra("username",this.username);
                i.putExtra("user_data",this.user_data);
                i.putExtra("user_info",this.user_info);
                startActivity(i);
                break;
            case R.id.alarm: i=new Intent(this,alarm.class);startActivity(i); break;
            case R.id.steps: i=new Intent(this,steps.class);startActivity(i); break;
            case R.id.fitness: i=new Intent(this,fitness.class);startActivity(i); break;
            case R.id.macros_setup: i=new Intent(this,macros.class);startActivity(i); break;
            default: break;

        }

    }
}

