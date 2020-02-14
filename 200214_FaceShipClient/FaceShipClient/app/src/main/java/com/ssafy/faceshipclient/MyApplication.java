package com.ssafy.faceshipclient;

import android.app.Application;

import com.ssafy.faceshipclient.DTO.Store;

import java.util.ArrayList;
import java.util.List;

public class MyApplication extends Application {

    private List<Store> storeList = new ArrayList<>();
    {
        storeList.add(new Store(1,1,"고양이카페", "031-111-1111", "많은 고양이를 볼 수 있는 카페", R.drawable.cat,0));
        storeList.add(new Store(2,2,"너구리카페", "031-222-2222", "많은 너구리를 볼 수 있는 카페", R.drawable.cat2 , 3));
        storeList.add(new Store(3,3,"호연이카페", "031-333-3333", "많은 호연이를 볼 수 있는 카페", R.drawable.cafe , 5));
        storeList.add(new Store(3,3,"치치네 토스트", "031-555-5555", "코로나 맛 수제 토스트", R.drawable.toast , 7));
        storeList.add(new Store(3,3,"치치네 토스트", "031-555-5555", "코로나 맛 수제 토스트", R.drawable.toast , 9));
        storeList.add(new Store(3,3,"치치네 토스트", "031-555-5555", "코로나 맛 수제 토스트", R.drawable.toast , 10));
    }

    public List<Store> getStoreList(){
        return storeList;
    }

}
