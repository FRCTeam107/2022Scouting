package com.example.vande.scouting2022;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.vande.scouting2022.R;

import java.util.HashMap;
import java.util.Map;

public class AnalysisActivity extends AppCompatActivity {

    TextView get_request_text;
    Button get_request_button;

    private static final String BASE_ADDRESS = "https://www.thebluealliance.com/api/v3/teams/2019/1";
    private static final String TBA_KEY = "P2hFBSlkMbnWHZ8kL0z4sWs8Bx59J8dJOpAj5CdG059qK25kPVLjFgQRQ3VHyNah";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);
        get_request_button = findViewById(R.id.get_data);
        get_request_text = findViewById(R.id.get_response_data);


        get_request_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestWithSomeHttpHeaders();
            }
        });
    }

    public void requestWithSomeHttpHeaders() {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = BASE_ADDRESS;
        StringRequest getRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>()
                {
                    @Override
                    public void onResponse(String response) {
                        // response
                        get_request_text.setText("Response : " +response);
                        Log.d("Response", response);
                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("ERROR","error => "+error.toString());
                    }
                }
        ) {
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String>  params = new HashMap<String, String>();
                params.put("X-TBA-Auth-Key", TBA_KEY);

                return params;
            }
        };
        queue.add(getRequest);

    }
}
