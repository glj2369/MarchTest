package com.example.admin.marchtest;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ServerTest extends Fragment implements View.OnClickListener {


    private View view;
    /**
     * 发送请求
     */
    private Button mRequest;
    /**
     * 请求结果
     */
    private WebView mShowService;

    public ServerTest() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_server_test, container, false);
        initView(view);
        mShowService.getSettings().setJavaScriptEnabled(true);//开启js脚本

        return view;
    }

    private void initView(View view) {
        mRequest = (Button) view.findViewById(R.id.request);
        mRequest.setOnClickListener(this);
        mShowService = (WebView) view.findViewById(R.id.show_service);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.request:
                OkHttpClient okHttpClient = new OkHttpClient();
                String url = "http://192.168.1.106:8080/transportservice/type/jason/action/GetCarSpeed.do";
                JSONObject js=new JSONObject();
                try {
                    js.put("CarId",2);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                RequestBody requestBody = FormBody.create(MediaType.parse("application/json;charset=utf-8"), js.toString());


                Request request = new Request.Builder()
                        .url(url)
                        .header("accept", "*/*")
                        .header("connection", "Keep-Alive")
                        .header("Content-Type", "text/html; charset=UTF-8")
                        .post(requestBody)
                        .build();
                okHttpClient.newCall(request).enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                Toast.makeText(getActivity(), "请求失败！！！", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        final String s = response.body().string();
                        getActivity().runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                mShowService.loadData(s,  "text/html", "utf-8");
                            }
                        });

                    }
                });
                break;
        }
    }
}
