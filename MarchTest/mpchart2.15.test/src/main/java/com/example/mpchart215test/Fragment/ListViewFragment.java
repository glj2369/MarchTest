package com.example.mpchart215test.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;

import com.example.mpchart215test.Adapter.ListViewAdapter;
import com.example.mpchart215test.Class.List_class;
import com.example.mpchart215test.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListViewFragment extends Fragment implements View.OnClickListener {
    private List<List_class> list = new ArrayList<>();
    private View view;
    private ListView mListview;
    private Switch mListSwitch;
    private ListViewAdapter listViewAdapter;
    /**
     * 反转
     */
    private Button mFz;

    public ListViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_list_view, container, false);
        initView(view);
        for (int i = 0; i < 8; i++) {
            list.add(new List_class(new Random().nextInt(20) + 1, +new Random().nextInt(20) + 1 + " 秦时明月汉时关"));
        }
        listViewAdapter = new ListViewAdapter(getContext(), R.layout.list_item, list);
        mListview.setAdapter(listViewAdapter);
        mListSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    sx();
                    listViewAdapter.notifyDataSetChanged();

                } else {
                    jx();
                    listViewAdapter.notifyDataSetChanged();
                }
            }
        });
        return view;
    }

    private void jx() {
        Collections.sort(list, new Comparator<List_class>() {
            @Override
            public int compare(List_class o1, List_class o2) {

                return -o1.getT2().compareTo(o2.getT2());
            }
        });
    }

    private void sx() {
        Collections.sort(list, new Comparator<List_class>() {
            @Override
            public int compare(List_class o1, List_class o2) {

                return o1.getT2().compareTo(o2.getT2());
            }
        });
    }

    private void initView(View view) {
        mListview = (ListView) view.findViewById(R.id.listview);
        mListSwitch = (Switch) view.findViewById(R.id.list_switch);
        mFz = (Button) view.findViewById(R.id.fz);
        mFz.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.fz:
                fz();
                break;
        }
    }

    private void fz() {
        Collections.reverse(list);
        listViewAdapter.notifyDataSetChanged();
    }

}
