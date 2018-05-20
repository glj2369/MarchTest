package com.example.mpchart215test.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mpchart215test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SpinnerFragment extends Fragment {


    private View inflate;
    private View view;
    private Spinner mSpinner;
    private String s[];

    public SpinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        inflate = inflater.inflate(R.layout.fragment_spinner, container, false);
        initView(inflate);
        ArrayAdapter arrayAdapter = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_dropdown_item, s);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setSelection(0, false);
        mSpinner.setAdapter(arrayAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {

                    case 0:
                        Toast.makeText(getActivity(), mSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(getActivity(), mSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(getActivity(), mSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(getActivity(), mSpinner.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return inflate;
    }

    private void initView(View inflate) {
        mSpinner = (Spinner) inflate.findViewById(R.id.spinner);
        s = new String[]{"秦时明月", "天行九歌", "武庚记", "斗罗大陆",};
    }
}
