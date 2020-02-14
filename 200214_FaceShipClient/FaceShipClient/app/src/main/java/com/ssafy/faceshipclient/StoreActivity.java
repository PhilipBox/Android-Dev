package com.ssafy.faceshipclient;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ssafy.faceshipclient.DTO.Store;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;


public class StoreActivity extends AppCompatActivity {

	TextView titleText;

	ImageView store_picture;
	TextView store_name;
	TextView store_desc;
	TextView coupon_cnt;
    ImageView MyCoupon;

	static List<Store> storeList = new ArrayList<>();
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_store);



        titleText = (TextView) findViewById(R.id.titleText);

        store_picture = findViewById(R.id.store_picture);
        store_name = findViewById(R.id.store_name);
        store_desc = findViewById(R.id.store_desc);
        MyCoupon = findViewById(R.id.coupon);
        coupon_cnt = findViewById(R.id.coupon_cnt);


        MyApplication myApp = new MyApplication();
        storeList = myApp.getStoreList();


        // process received intent
        Intent receivedIntent = getIntent();
        Store store = (Store) receivedIntent.getSerializableExtra("store");
        int myCoupon = receivedIntent.getExtras().getInt("coupon");

        store_picture.setImageResource(store.getImage());
        store_name.setText(store.getsName());
        store_desc.setText(store.getsDesc());
        coupon_cnt.setText(Integer.toString(myCoupon)+" 개");

        switch (store.getCoupon()){
            case 0 :
                MyCoupon.setImageResource(R.drawable.cp0);
                break;
            case 1 :
                MyCoupon.setImageResource(R.drawable.cp1);
                break;
            case 2 :
                MyCoupon.setImageResource(R.drawable.cp2);
                break;
            case 3 :
                MyCoupon.setImageResource(R.drawable.cp3);
                break;
            case 4 :
                MyCoupon.setImageResource(R.drawable.cp4);
                break;
            case 5 :
                MyCoupon.setImageResource(R.drawable.cp5);
                break;
            case 6 :
                MyCoupon.setImageResource(R.drawable.cp6);
                break;
            case 7 :
                MyCoupon.setImageResource(R.drawable.cp7);
                break;
            case 8 :
                MyCoupon.setImageResource(R.drawable.cp8);
                break;
            case 9 :
                MyCoupon.setImageResource(R.drawable.cp9);
                break;
            default:
                MyCoupon.setImageResource(R.drawable.cp10);
                break;
        }







        Toast.makeText(this, "Msg : " + store.toString(), Toast.LENGTH_LONG).show();

        Button backButton = (Button) findViewById(R.id.backButton);
        backButton.setOnClickListener(new OnClickListener() {
        	public void onClick(View v) {
        		Intent resultIntent = new Intent();
                resultIntent.putExtra("message", "result message is OK!");

                setResult(Activity.RESULT_OK, resultIntent);
                finish();
        	}
        });

    }

}
