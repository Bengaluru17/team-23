package com.example.bidisha.kshamata_23;
import java.io.*;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.apache.http.NameValuePair;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;
public class MainActivity extends AppCompatActivity {
    Button login;
    String response;
    EditText username,pwd;
    String str1,str2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("MainActivity","On 1");
        setContentView(R.layout.activity_main);
        username=(EditText) findViewById(R.id.username);
        pwd=(EditText) findViewById(R.id.password);




          //  str1="Hello";
           // str2="World";

//        HashMap<String,String> mp = new HashMap<String,String>();
//        mp.put("usn",usn);
//        mp.put("pwd",pwd);
        login=(Button)findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
         //       Intent phrasesIntent = new Intent(MainActivity.this, DataEntry.class);
                // Start the new activity
           //     MainActivity.this.startActivity(phrasesIntent);
                str1=username.getText().toString();
                str2=pwd.getText().toString();
                Log.i("MainActivity",str1);
                Log.i("MainActivity",str2);
                new SendPostRequest().execute(str1,str2);
            }
        });


    }

    public class SendPostRequest extends AsyncTask<String, Void, String> {

        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));

        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("http://13.228.23.222:8000/kshamata/login/"); // here is your URL path

                JSONObject postDataParams = new JSONObject();
                postDataParams.put("username",arg0[0]);
                postDataParams.put("password",arg0[1]);

                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);
                Log.i("Inner Class","After Http Connection");
                OutputStream os = conn.getOutputStream();
                Log.i("Inner Class","After Output Stream");
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();
                Log.i("Inner Class","After writing to the stream");

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {
                    Log.i("Inner Class","Request Sent");
                    BufferedReader in=new BufferedReader(new
                            InputStreamReader(
                            conn.getInputStream()));

                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    Log.i("Inner Class","Request Not Sent");
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
//                Toast.makeText(getApplicationContext(), "HEYYY",
//                        Toast.LENGTH_LONG).show();
                Log.i("Inner Class","There is an exception");
                e.printStackTrace();
                return new String("Exception: " + e.getMessage());
            }

        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();
           // int res=Integer.parseInt(result);
                int res=10;
            if(res != 404) {

                getAnotherClass(res);
            }
            else{
                Toast.makeText(getApplicationContext(), "Incorrect username or password",
                        Toast.LENGTH_LONG).show();

            }


        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;
        Log.i("getPostDataString","Error is here");
        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }
    public void getAnotherClass(int r){
        Log.i("MainActivity","Intent Recieved");
        Intent DataEnt = new Intent(this, DataEntry.class);
        DataEnt.putExtra("u_id",r);
        startActivity(DataEnt);
    }
}


