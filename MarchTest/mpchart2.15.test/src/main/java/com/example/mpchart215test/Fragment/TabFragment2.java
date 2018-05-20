package com.example.mpchart215test.Fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.GetChars;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.mpchart215test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment2 extends Fragment {


    private View view;

    public TabFragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab_fragment2, container, false);
       /* AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("标题")
                .setMessage("提示。。。")
                .setCancelable(true)
                .setNeutralButton("按钮1", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "按钮1", Toast.LENGTH_SHORT).show();
                    }
                })
                .setPositiveButton("按钮2", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "按钮2", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("按钮3", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "按钮3", Toast.LENGTH_SHORT).show();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();*/


        AlertDialog.Builder builder = new AlertDialog.Builder(getContext())
                .setTitle("title")
                .setMessage("hello")
                .setCancelable(true)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(), "hello", Toast.LENGTH_SHORT).show();
                    }
                });
        builder.create().show();

        return view;
    }

}
