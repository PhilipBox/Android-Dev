package com.ssafy.faceshipclient;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ssafy.faceshipclient.DTO.Store;

import java.util.ArrayList;
import java.util.List;


public class MenuActivity extends AppCompatActivity {
	public static final int REQUEST_CODE_CUSTOMER = 201;
	public static final int REQUEST_CODE_REVENUE = 202;
	public static final int REQUEST_CODE_STORE = 203;

	static List<Store> storeList = new ArrayList<>();

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

		// 리사이클 뷰 읽기
		RecyclerView recyclerView = findViewById(R.id.recyclerView);
		LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
		recyclerView.setLayoutManager(layoutManager);
		StoreAdapter adapter = new StoreAdapter();

		MyApplication myApp = new MyApplication();
		storeList = myApp.getStoreList();

		// 전달된 인텐트를 받는다.
        // username은 name
		// userphone은 phone
		Intent receivedIntent = getIntent();
        final String username = receivedIntent.getStringExtra("username");
        final String userphone = receivedIntent.getStringExtra("userphone");


		System.out.println("사이즈 " + storeList.size());
		for(Store s : storeList){
			System.out.println(s.toString());
			adapter.addItem(s);
		}
		recyclerView.setAdapter(adapter);


		Toast.makeText(this, "!username : " + username + ", !userphone : " + userphone, Toast.LENGTH_LONG).show();


//        Button menu03Button = (Button) findViewById(R.id.menu03Button);
//        menu03Button.setOnClickListener(new OnClickListener() {
//        	public void onClick(View v) {
//        		Intent intent = new Intent(getApplicationContext(), StoreActivity.class);
//    			intent.putExtra("titleMsg", "상품관리 화면");
//
//   				startActivityForResult(intent, REQUEST_CODE_PRODUCT);
//        	}
//        });

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
		super.onActivityResult(requestCode, resultCode, intent);

		if (intent != null) {
			if (requestCode == REQUEST_CODE_CUSTOMER) {
				String message = intent.getStringExtra("message");
	
				if (message != null) {
					Toast toast = Toast.makeText(getBaseContext(), "고객관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
					toast.show();
				}
			} else if (requestCode == REQUEST_CODE_REVENUE) {
				String message = intent.getStringExtra("message");

				if (message != null) {
					Toast toast = Toast.makeText(getBaseContext(), "매출관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
					toast.show();
				}
			} else if (requestCode == REQUEST_CODE_STORE) {
				String message = intent.getStringExtra("message");
	
				if (message != null) {
					Toast toast = Toast.makeText(getBaseContext(), "상품관리 응답, result code : " + resultCode + ", message : " + message, Toast.LENGTH_LONG);
					toast.show();
				}
			}
		}
		
	}

}
