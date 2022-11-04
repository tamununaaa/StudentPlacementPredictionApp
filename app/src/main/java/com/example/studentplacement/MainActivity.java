package com.example.studentplacement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewAnimator;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText cgpa, iq, prof;
    Button btn;
    TextView tv;
    String url = "https://studentplacementpredapp.herokuapp.com/predict";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cgpa = findViewById(R.id.cgpa);
        iq = findViewById(R.id.iq);
        prof = findViewById(R.id.profile);
        btn = findViewById(R.id.button);
        tv = findViewById(R.id.result);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cgpa.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this,"Enter CGPA",Toast.LENGTH_SHORT).show();
                else if(iq.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this,"Enter IQ",Toast.LENGTH_SHORT).show();
                else if(prof.getText().toString().equals(""))
                    Toast.makeText(MainActivity.this,"Enter Profile Score",Toast.LENGTH_SHORT).show();
                // hit the API -> Volley
                else{
                StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {

                                try {
                                    JSONObject jsonObject = new JSONObject(response);
                                    String data = jsonObject.getString("placement");
                                    if(data.equals("1")){
                                        tv.setText("Will be placed!");
                                    }else{
                                        tv.setText("Won't be placed!");
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }

                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }){

                    @Override
                    protected Map<String,String> getParams(){
                        Map<String,String> params = new HashMap<String,String>();
                        params.put("cgpa",cgpa.getText().toString());
                        params.put("iq",iq.getText().toString());
                        params.put("profile_score",prof.getText().toString());

                        return params;
                    }

                };


                RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
                queue.add(stringRequest);
            }}
        });
    }
}