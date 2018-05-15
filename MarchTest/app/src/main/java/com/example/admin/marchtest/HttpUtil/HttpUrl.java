package com.example.admin.marchtest.HttpUtil;

import android.support.annotation.NonNull;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpUrl {
    public interface ResultHttpLisenter {
        void response(String result);
    }

    @NonNull
    public static void postHttpUrl(final String urlString, final String jsonStr, final ResultHttpLisenter lisenter) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String posthttp = null;
                try {
                    posthttp = posthttp(urlString, jsonStr);
                    lisenter.response(posthttp);
                } catch (IOException e) {
                    e.printStackTrace();
                    lisenter.response(e.toString());
                }
            }
        }).start();
    }

    public static String posthttp(String urlString, String jsonStr) throws IOException {
            URL mUrl  = new URL(urlString);
            HttpURLConnection mConnection = (HttpURLConnection) mUrl.openConnection();
            mConnection.addRequestProperty("accept", "*/*");
            mConnection.setRequestProperty("connection", "Keep-Alive");
            mConnection.addRequestProperty("Content-Type", "text/html;charset=utf-8");
            mConnection.setConnectTimeout(3000);
            mConnection.setReadTimeout(3000);
            mConnection.setDoOutput(true);
            mConnection.setDoInput(true);
            mConnection.setRequestMethod("POST");

            OutputStream os = mConnection.getOutputStream();
            OutputStreamWriter writer = new OutputStreamWriter(os);
            writer.write(jsonStr);
            writer.flush();
            writer.close();
            os.close();

            InputStream in = mConnection.getInputStream();
            BufferedReader mReader = new BufferedReader(new InputStreamReader(in));
            StringBuilder result = new StringBuilder();
            String line;
            while ((line = mReader.readLine()) != null) {
                result.append(line);
            }
            if (in != null) {
                in.close();
            }
            if (mReader != null) {
                mReader.close();
            }
            return result.toString();

    }

    public static void postJsonUrl(final String urlString, final String jsonStr, final ResultHttpLisenter lisenter) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL(urlString);
                    OkHttpClient client = new OkHttpClient();

                    RequestBody requestBody = RequestBody.create(MediaType.parse("application/json;charset=utf-8"), jsonStr);
                    Request request = new Request.Builder()
                            .url(url)
                            .method("POST", requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String result = response.body().toString();
                    lisenter.response(result);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }
}
