package com.example.admin.marchtest.march;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.admin.marchtest.MainActivity;
import com.example.admin.marchtest.R;

import java.io.Serializable;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment implements View.OnClickListener {


    private View view;
    private ImageView mPicture1;
    private MainActivity mainActivity;

    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_picture, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mPicture1 = (ImageView) view.findViewById(R.id.picture_1);
        mPicture1.setOnClickListener(this);
        mainActivity  = (MainActivity) getActivity();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.picture_1:

                Intent intent=new Intent(getActivity(),PictureActivity.class);
                startActivity(intent);

                break;
        }
    }
}
