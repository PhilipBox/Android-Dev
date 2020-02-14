package com.ssafy.faceshipclient;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ssafy.faceshipclient.DTO.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    public static final int REQUEST_CODE_MENU = 101;

    EditText usernameInput;
    EditText userphoneInput;

    static RequestQueue requestQueue;
    static ArrayList<User> userlist = new ArrayList<User>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logined_main);

        Button loginButton = (Button) findViewById(R.id.loginButton);

        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(getApplicationContext());
        }

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String username = usernameInput.getText().toString();
                String userphone = userphoneInput.getText().toString();

                makeRequest();

                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                intent.putExtra("username", username);
                intent.putExtra("userphone", userphone);
                intent.putExtra("userlist", userlist);


                startActivityForResult(intent, REQUEST_CODE_MENU);
            }
        });

        usernameInput = (EditText) findViewById(R.id.nameInput);
        userphoneInput = (EditText) findViewById(R.id.phoneInput);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);

        if (requestCode == REQUEST_CODE_MENU) {
            if (intent != null) {
                String menu = intent.getStringExtra("menu");
                String message = intent.getStringExtra("message");

                System.out.println("사이즈 " + userlist.size());
                for(User u : userlist){
                    System.out.println(u.toString());
                }

                Toast toast = Toast.makeText(getBaseContext(), "result code : " + resultCode + ", menu : " + menu + ", message : " + message, Toast.LENGTH_LONG);
                toast.show();
            }
        }

    }

    public void makeRequest() {
        // 입력한 URL을 가져온다.
//        String url = editText.getText().toString();
//        String url = "http://13.125.124.224:8080/user/list";
        String url = "http://192.168.100.44:8090/user/list";
        StringRequest request = new StringRequest(
                Request.Method.GET,url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                System.out.println("응답 -> " + response);
                processResponse(response);
                return;
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        System.out.println("에러 -> " + error.getMessage());
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
        System.out.println("요청 보냄.");
        return;
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

                userlist.add(user);
            }

            for(User u : userlist){
                System.out.println("이름: "+ u.getuName() +"/ 전화번호: "+u.getuPhone());
                System.out.println("uID: "+ u.getuID() + "/ 점주: " + u.getisOwner() +"/ 이미지경로: "+u.getuImage());
            }

            System.out.println("----------유저정보의 수 : " + userlist.size());
        }
        catch (JSONException e){
        }
    }

}
