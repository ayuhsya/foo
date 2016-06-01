package com.box.little.littlebox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class MainActivity extends AppCompatActivity {

    public static TextView txtView, txtView2, txtView3;
    static String url = "https://api.myjson.com/bins";


    static RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(url).build();
    final static restInterface restInt = restAdapter.create(restInterface.class);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtView = (TextView) findViewById(R.id.textView);
        txtView2 = (TextView) findViewById(R.id.textView2);
        txtView3 = (TextView) findViewById(R.id.textView3);

        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(url).build();
        final restInterface restInt = restAdapter.create(restInterface.class);

        Button pickTime = (Button) findViewById(R.id.button);
        Button getDetails = (Button) findViewById(R.id.button2);
        Button pickFromTime = (Button) findViewById(R.id.button3);
        Button setNewTime = (Button) findViewById(R.id.button4);

        getDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restInt.getUser(new Callback<POJO>() {
                    @Override
                    public void success(POJO pojo, Response response) {
                        txtView3.setText("Username: " + pojo.getUser());
                        txtView2.setText("From: " + pojo.getFrom());
                        txtView.setText("To: "+ pojo.getTo());
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        String err = error.getMessage();
                    }
                });

            }
        });

        pickTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, pick.class));
            }
        });

        pickFromTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, pickFrom.class));
            }
        });

        setNewTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                POJO pojo = new POJO();
                pojo.setUser("John Doe");
                pojo.setTo(txtView2.getText().toString());
                pojo.setFrom(txtView.getText().toString());

                MainActivity.restInt.createUser(pojo, new Callback<POJO>() {
                    @Override
                    public void success(POJO pojo, Response response) {
                        MainActivity.txtView3.setText("New uploaded");
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        MainActivity.txtView3.setText(error.getMessage());
                    }
                });
            }
        });
    }
}
