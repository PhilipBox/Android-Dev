//package com.ssafy.faceshipclient;
//
//import android.app.Activity;
//import android.content.Intent;
//import android.os.Bundle;
//import android.view.GestureDetector;
//import android.view.View;
//import android.view.View.OnClickListener;
//import android.widget.Button;
//import android.widget.EditText;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.android.volley.AuthFailureError;
//import com.android.volley.Request;
//import com.android.volley.RequestQueue;
//import com.android.volley.Response;
//import com.android.volley.VolleyError;
//import com.android.volley.toolbox.StringRequest;
//import com.android.volley.toolbox.Volley;
//import com.ssafy.faceshipclient.DTO.User;
//
//import org.json.JSONArray;
//import org.json.JSONException;
//import org.json.JSONObject;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static java.sql.DriverManager.println;
//
//
//public class CustomerActivity extends AppCompatActivity {
//	TextView titleText;
//
//    TextView textView;
//
//    static List<User> userList = new ArrayList<>();
//
//    static RequestQueue requestQueue;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_customer);
//
//        titleText = (TextView) findViewById(R.id.titleText);
//
//        // process received intent
//        Intent receivedIntent = getIntent();
//        String infoMsg = receivedIntent.getStringExtra("infoMsg");
//        String username = receivedIntent.getStringExtra("username");
//        String userphone = receivedIntent.getStringExtra("userphone");
//
//
//        Toast.makeText(this, "내정보화면 받은메시지 : " + infoMsg + "/ username :" + username + "  / userphone : " + userphone, Toast.LENGTH_LONG).show();
//
//        if (titleText != null) {
//        	titleText.setText(infoMsg);
//        }
//
//
//        Button backButton = (Button) findViewById(R.id.backButton);
//        backButton.setOnClickListener(new OnClickListener() {
//        	public void onClick(View v) {
//        		Intent resultIntent = new Intent();
//                resultIntent.putExtra("message", "result message is OK!");
//
//                setResult(Activity.RESULT_OK, resultIntent);
//                finish();
//        	}
//        });
//
//        // Rest API call의 결과를 보여주기 위한 텍스트 뷰
//        textView = findViewById(R.id.resultView);
//
//        printtest();
//
//        if (requestQueue == null) {
//            requestQueue = Volley.newRequestQueue(getApplicationContext());
//        }
//
//
//        sendRequest(username, userphone);
//    }//end onCreate
//
//    public void printtest(){
//        System.out.println("실행됨!");
//    }
//
//
//    //
//    public void sendRequest(String username, String userphone){
//        String url = "http://192.168.100.44:8090/user/info/"+username+"/"+userphone+"";
//
//
//        StringRequest request = new StringRequest(
//                Request.Method.GET,
//                url,
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//                        println("응답 -> " + response);
//
//                        //받은 정보를 처리한다.
//                        processResponse(response);
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        println("에러 -> " + error.getMessage());
//                    }
//                }
//        ) {
//            @Override
//            protected Map<String, String> getParams() throws AuthFailureError {
//                Map<String,String> params = new HashMap<String,String>();
//
//                return params;
//            }
//        };
//
//        request.setShouldCache(false);
//        requestQueue.add(request);
//        println("요청 보냄.");
//    }
//
//    public void processResponse(String response) {
//        try {
////            Gson gson = new Gson();
//
//            JSONObject jsonObject = new JSONObject(response);
//            JSONArray userArray = jsonObject.getJSONArray("user");
//
//            for(int i=0; i<userArray.length(); i++){
//                JSONObject userObject = userArray.getJSONObject(i);
//
//                User user = new User();
//
//                user.setuID(userObject.getInt("uID"));
//                user.setisOwner(userObject.getBoolean("isOwner"));
//                user.setuName(userObject.getString("uName"));
//                user.setuPhone(userObject.getString("uPhone"));
//                user.setuImage(userObject.getString("uImage"));
//
//                userList.add(user);
//            }
//
//            for(User u : userList){
//                System.out.println("이름: "+ u.getuName() +"/ 전화번호: "+u.getuPhone());
//                System.out.println("uID: "+ u.getuID() + "/ 점주: " + u.getisOwner() +"/ 이미지경로: "+u.getuImage());
//            }
//
//
////            MovieList movieList = gson.fromJson(response, MovieList.class);
//
//            println("유저정보의 수 : " + userList.size());
//        }
//        catch (JSONException e){
//
//        }
//    }
//
//    public void println(String data) {
//        textView.append(data + "\n");
//    }
//
//}
