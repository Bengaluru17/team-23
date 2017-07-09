//import com.example.bidisha.kshamata_23.R;

package com.example.bidisha.kshamata_23;

import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Bidisha on 08-07-2017.
 */

public class DataEntry extends AppCompatActivity
{
    static final int CAM_REQUEST=1;
    Button bcam;
    EditText name,dob,id,ph_no,email,back,dure,skills,skillLevel,curSal,curLoc,loc,jobS,jobR,cemp,save,expect;
    RadioGroup rg;
    String nm,db,idNo,pn,eml,bk,de,sk,skL,cS,u_id,lo,js,jres,ce,sv,exp;
    String checkStore;
    String lat,lon;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.dataent);
        Log.i("DataEntry","Inside DataEntry");
        Bundle extras=getIntent().getExtras();
        int u=extras.getInt("u_id");
        u_id=String.valueOf(u);
        name=(EditText) findViewById(R.id.nameET);
        dob=(EditText) findViewById(R.id.dobEt);
        id=(EditText) findViewById(R.id.idcardEt);
        ph_no=(EditText) findViewById(R.id.phoneEt);
        email=(EditText) findViewById(R.id.emailEt);
        back=(EditText) findViewById(R.id.backEt);
        dure =(EditText) findViewById(R.id.durstayEt);
        skills=(EditText) findViewById(R.id.skillEt);
        skillLevel=(EditText) findViewById(R.id.skilllevelEt);
        curSal=(EditText) findViewById(R.id.cursalEt);
        loc=(EditText) findViewById(R.id.getLoc);
        jobS=(EditText) findViewById(R.id.jobsatisEt);
        jobR=(EditText) findViewById(R.id.jobresEt);
        cemp=(EditText) findViewById(R.id.curEmpEt);
        save=(EditText)findViewById(R.id.saveEt);
        expect=(EditText)findViewById(R.id.expecEt);
      //  curLoc=(EditText) findViewById(R.id.);
        rg=(RadioGroup)findViewById(R.id.radiog);
        Button sub=(Button)findViewById(R.id.sub);

       /* Button getL=(Button)findViewById(R.id.getLoc);
        getL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //LocationManager locationManager =
                  //      (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
                LocationManager locationManager = (LocationManager) this.getSystemService(Context.LOCATION_SERVICE);
                // Define a listener that responds to location updates
                LocationListener locationListener = new LocationListener() {
                    public void onLocationChanged(Location location) {
                        // Called when a new location is found by the network location provider.
                        lat = Double.toString(location.getLatitude());
                        lon = Double.toString(location.getLongitude());


            }

                    @Override
                    public void onStatusChanged(String s, int i, Bundle bundle) {

                    }

                    @Override
                    public void onProviderEnabled(String s) {

                    }

                    @Override
                    public void onProviderDisabled(String s) {

                    }
                });*/
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nm=name.getText().toString();
                db=dob.getText().toString();
                idNo=id.getText().toString();
                pn=ph_no.getText().toString();
                eml=email.getText().toString();
                bk=back.getText().toString();
                de=dure.getText().toString();
                sk=skills.getText().toString();
                skL=skillLevel.getText().toString();
                cS=curSal.getText().toString();
                lo=loc.getText().toString();
                js=jobS.getText().toString();
                jres=jobR.getText().toString();
                ce=cemp.getText().toString();
                sv=save.getText().toString();
                exp=expect.getText().toString();
         //       cL=curLoc.getText().toString();
//                Log.i("MainActivity",str1);
//                Log.i("MainActivity",str2);
                new DataEntry.SendPostRequest().execute(nm,db,idNo,pn,eml,checkStore,bk,de,sk,skL,cS,lo,u_id,js,jres,ce,sv,exp);

            }
        });
    }
    public void radioCheck(View view){
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.vcYes:
                if (checked)
                    checkStore="true";
                break;
            case R.id.vcNo:
                if (checked)
                    checkStore="false";
                break;
        }
    }
    public void getMap(){

    }
    public class SendPostRequest extends AsyncTask<String, Void, String> {

        BufferedReader in =new BufferedReader(new InputStreamReader(System.in));

        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try {

                URL url = new URL("http://13.228.23.222:8000/kshamata/post_data/"); // here is your URL path

                JSONObject postDataParams = new JSONObject();
                postDataParams.put("name",arg0[0]);
                postDataParams.put("dob",arg0[1]);
                postDataParams.put("id",arg0[2]);
                postDataParams.put("phn",arg0[3]);
                postDataParams.put("email",arg0[4]);
                postDataParams.put("vc",arg0[5]);
                postDataParams.put("bg",arg0[6]);
                postDataParams.put("dureOfStay",arg0[7]);
                postDataParams.put("skills",arg0[8]);
                postDataParams.put("skillsLevel",arg0[9]);
                postDataParams.put("curSal",arg0[10]);
                postDataParams.put("curLoc",arg0[11]);
                postDataParams.put("u_id",arg0[12]);
                postDataParams.put("jobsatis",arg0[13]);
                postDataParams.put("jobres",arg0[14]);
                postDataParams.put("curEmp",arg0[15]);
                postDataParams.put("save",arg0[16]);
                postDataParams.put("expect",arg0[17]);
                Log.e("params",postDataParams.toString());

                HttpURLConnection conn= (HttpURLConnection)url.openConnection();
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
                Log.i("Response Code",String.valueOf(responseCode));
                Log.i("Response Code",String.valueOf(HttpsURLConnection.HTTP_OK));
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
             Toast.makeText(getApplicationContext(), "Entry is successful",
                Toast.LENGTH_LONG).show();

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
}
