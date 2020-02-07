package org.techtown.request;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
//    EditText editText;
    TextView textView;

    static List<User>  userList = new ArrayList<>();
    static RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // URL을 입력하는 곳
//        editText = findViewById(R.id.editText);
        // JSON 결과가 출력되는 곳
        textView = findViewById(R.id.textView);


        // 버튼코드 아래에 위치함. 큐는 필수.
        // 만약 버튼 없이 이전에 인텐트 정보를 받아서 바로 실행한다면, 아래 코드가 makeRequest 위에 존재해야 함.
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }
        makeRequest();


        // 리사이클 뷰 읽기
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        MyAdapter adapter = new MyAdapter();



//        // 입력된 URL을 요청하는 버튼
//        Button button = findViewById(R.id.button);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // 버튼을 누르면 아래 makeRequest 함수를 실행한다.
//                makeRequest();
//            }
//        });



        System.out.println("JSON 객체화는 끝났음.");


        System.out.println("사이즈 " + userList.size());
        for(User u : userList){
            System.out.println(u.toString());
            adapter.addItem(u);
        }
        recyclerView.setAdapter(adapter);


    }//end onCreate method


    public void makeRequest() {
        // 입력한 URL을 가져온다.
//        String url = editText.getText().toString();
//        String url = "http://13.125.124.224:8080/user/list";
        String url = "http://192.168.100.44:8090/user/list";
        StringRequest request = new StringRequest(
                Request.Method.GET,url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        println("응답 -> " + response);
                        processResponse(response);
                        return;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        println("에러 -> " + error.getMessage());
                        return;
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                return params;
            }
        };

        request.setShouldCache(false);
        requestQueue.add(request);
        println("요청 보냄.");
        return;
    }

    public void println(String data) {
        textView.append(data + "\n");
    }

    public void processResponse(String response) {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONArray userArray = jsonObject.getJSONArray("user");

            for(int i=0; i<userArray.length(); i++){
                JSONObject userObject = userArray.getJSONObject(i);

                User user = new User();

                user.setuID(userObject.getInt("uID"));
                user.setisOwner(userObject.getBoolean("isOwner"));
                user.setuName(userObject.getString("uName"));
                user.setuPhone(userObject.getString("uPhone"));
                user.setuImage(userObject.getString("uImage"));

                userList.add(user);
            }

            for(User u : userList){
                System.out.println("이름: "+ u.getuName() +"/ 전화번호: "+u.getuPhone());
                System.out.println("uID: "+ u.getuID() + "/ 점주: " + u.getisOwner() +"/ 이미지경로: "+u.getuImage());
            }

            println("유저정보의 수 : " + userList.size());
        }
        catch (JSONException e){

        }
    }

}
