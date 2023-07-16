package com.mahasin.products;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);



        String url ="https://dummyjson.com/products";
        JsonObjectRequest jsonObjectRequest=new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {


                try {
                    JSONArray jsonArray=response.getJSONArray("products");

                    for (int x=0;x<jsonArray.length();x++){
                        JSONObject jsonObject=jsonArray.getJSONObject(x);

                        String id=jsonObject.getString("id");
                        String title=jsonObject.getString("title");
                        String description=jsonObject.getString("description");
                        String price=jsonObject.getString("price");
                        String discountPercentage=jsonObject.getString("discountPercentage");
                        String rating=jsonObject.getString("rating");
                        String stock=jsonObject.getString("stock");
                        String brand=jsonObject.getString("brand");
                        String category=jsonObject.getString("category");
                        String thumbnailt=jsonObject.getString("thumbnail");

                        textView.append("\n"+id+"\n");
                        textView.append(title+"\n");
                        textView.append(description+"\n");
                        textView.append(price+"\n");
                        textView.append(discountPercentage+"\n");
                        textView.append(rating+"\n");
                        textView.append(stock+"\n");
                        textView.append(brand+"\n");
                        textView.append(category+"\n");
                        textView.append(thumbnailt+"\n\n");








                    }



                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(jsonObjectRequest);



    }
}