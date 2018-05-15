package com.example.admin.marchtest.HttpUtil;



import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class Okhttp {
    public static void conn (String str,okhttp3.Callback callback){
        OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new  Request.Builder()
                .url(str)

                .build();
        okHttpClient.newCall(request).enqueue(callback);

    }
}
