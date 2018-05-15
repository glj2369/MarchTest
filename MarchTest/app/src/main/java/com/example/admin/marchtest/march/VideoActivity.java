package com.example.admin.marchtest.march;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.admin.marchtest.R;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;

public class VideoActivity extends AppCompatActivity {

    private VideoView mVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_video);
        initView();
        requestPermission();

    }

    private void PlayerVideo() {

        //File file = new File(Environment.getExternalStorageDirectory() + "/wgj.mp4");
        //Log.d("VideoActivity", file.toString());

           // Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
            MediaController mediaController = new MediaController(this);
            //mVideoPlayer.setVideoPath(file.getAbsolutePath());


            mVideoPlayer.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/raw/"+R.raw.hf));
            mVideoPlayer.setMediaController(mediaController);
            // 设置MediaController与VideView建立关联
            mediaController.setMediaPlayer(mVideoPlayer);

            // 让VideoView获取焦点
            mVideoPlayer.requestFocus();
            mVideoPlayer.start();


        //Toast.makeText(this, file.toString(), Toast.LENGTH_SHORT).show();
        // Uri uri = Uri.parse(file + "wgj.mp4");
        //mVideoPlayer.setVideoURI(uri);

        mVideoPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.start();
                Toast.makeText(VideoActivity.this, "开始播放！", Toast.LENGTH_SHORT).show();
            }
        });
        mVideoPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(VideoActivity.this, "播放完成", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void requestPermission() {
        //判断当前Activity是否已经获得了该权限
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {


            //进行权限请求
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    1);
        } else {
            PlayerVideo();

        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case 1: {
                // 如果请求被拒绝，那么通常grantResults数组为空
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //申请成功，进行相应操作
                    PlayerVideo();

                } else {
                    //申请失败，可以继续向用户解释。
                    Toast.makeText(this, "权限请求失败！！", Toast.LENGTH_SHORT).show();
                }
                return;
            }
        }
    }

    private void initView() {
        mVideoPlayer = (VideoView) findViewById(R.id.video_player);
    }
}
