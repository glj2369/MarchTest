package com.example.admin.marchtest.march;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.marchtest.R;
import com.example.admin.marchtest.RoadLight;
import com.example.admin.marchtest.adapter.LightAdapter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class RGBLightFragment extends Fragment implements View.OnClickListener {

    private List<RoadLight> roadLights = new ArrayList<>();
    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private Spinner mLightSpinner;
    /**
     * 查询
     */
    private Button mQuery;
    private ListView mLightList;
    private LightAdapter adapter;

    public RGBLightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_rgblight, container, false);
        // Inflate the layout for this fragment
        initView(view);
        String[] sp = {"路口升序", "路口降序", "红灯升序", "红灯降序", "绿灯升序", "绿灯降序", "黄灯升序", "黄灯降序"};
        ArrayAdapter<String> spa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, sp);
        spa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mLightSpinner.setAdapter(spa);
        mLightSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getActivity(), position, Toast.LENGTH_SHORT).show();
                switch (position) {
                    case 0:
                        up("road");
                        adapter.notifyDataSetChanged();
                        break;
                    case 1:
                        down("road");
                        adapter.notifyDataSetChanged();
                        break;
                    case 2:
                        up("red");
                        adapter.notifyDataSetChanged();
                        break;
                    case 3:
                        down("red");
                        adapter.notifyDataSetChanged();
                        break;
                    case 4:
                        up("green");
                        adapter.notifyDataSetChanged();
                        break;
                    case 5:
                        down("green");
                        adapter.notifyDataSetChanged();
                        break;
                    case 6:
                        up("yellow");
                        adapter.notifyDataSetChanged();
                        break;
                    case 7:
                        down("yellow");
                        adapter.notifyDataSetChanged();
                        break;
                    default:
                        break;


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        Ran();
        up("road");
        adapter = new LightAdapter(getContext(), R.layout.light_listitem_layout, roadLights);
        //View view = View.inflate(getActivity(), R.layout.list_head, null);
        //mLightList.addHeaderView(view);
        mLightList.setAdapter(adapter);

        return this.view;
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mLightSpinner = (Spinner) view.findViewById(R.id.light_spinner);
        mQuery = (Button) view.findViewById(R.id.query);
        mQuery.setOnClickListener(this);
        mLightList = (ListView) view.findViewById(R.id.light_list);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.query:

                roadLights.clear();

                Ran();
                if (mLightSpinner.getSelectedItemPosition() == 0) {
                    up("road");

                } else if (mLightSpinner.getSelectedItemPosition() == 1) {
                    down("road");
                } else if (mLightSpinner.getSelectedItemPosition() == 2) {
                    up("red");
                } else if (mLightSpinner.getSelectedItemPosition() == 3) {
                    down("red");
                } else if (mLightSpinner.getSelectedItemPosition() == 4) {
                    up("green");
                } else if (mLightSpinner.getSelectedItemPosition() == 5) {
                    down("green");
                } else if (mLightSpinner.getSelectedItemPosition() == 6) {
                    up("yellow");
                } else if (mLightSpinner.getSelectedItemPosition() == 7) {
                    down("yellow");
                }

                adapter.notifyDataSetChanged();

                break;
        }
    }

    private void Ran() {
        Random random = new Random();
        for (int i = 3; i > 0; i--) {
            roadLights.add(new RoadLight(i + "", random.nextInt(10) + 1 + "", random.nextInt(10) + 1 + "", random.nextInt(10) + 1 + ""));
        }


    }

    private void up(final String s) {
        Collections.sort(roadLights, new Comparator<RoadLight>() {
            @Override
            public int compare(RoadLight o1, RoadLight o2) {
                if ("red".equals(s)) {
                    int s1 = Integer.parseInt(o1.getRed());
                    int s2 = Integer.parseInt(o2.getRed());
                    /*if (s1 > s2) {
                        //Toast.makeText(getActivity(), "nnnn", Toast.LENGTH_SHORT).show();
                        return 1;
                    }*/
                    return s1 - s2;
                } else if ("yellow".equals(s)) {
                    int s1 = Integer.parseInt(o1.getYellow());
                    int s2 = Integer.parseInt(o2.getYellow());
                    if (s1 > s2) {
                        return 1;
                    }
                    return -1;
                } else if ("green".equals(s)) {
                    int s1 = Integer.parseInt(o1.getGreen());
                    int s2 = Integer.parseInt(o2.getGreen());
                    if (s1 > s2) {
                        return 1;
                    }
                    return -1;
                } else if ("road".equals(s)) {
                    int s1 = Integer.parseInt(o1.getRoad());
                    int s2 = Integer.parseInt(o2.getRoad());
                    if (s1 > s2) {
                        return 1;
                    }
                    return -1;
                }

                return -1;
            }
        });
    }

    private void down(final String s) {
        Collections.sort(roadLights, new Comparator<RoadLight>() {
            @Override
            public int compare(RoadLight o1, RoadLight o2) {
                if ("red".equals(s)) {
                    int s1 = Integer.parseInt(o1.getRed());
                    int s2 = Integer.parseInt(o2.getRed());
                    if (s1 < s2) {
                        // Toast.makeText(getActivity(), s1+""+s2, Toast.LENGTH_SHORT).show();
                        return 1;
                    }
                    return -1;
                } else if ("yellow".equals(s)) {
                    int s1 = Integer.parseInt(o1.getYellow());
                    int s2 = Integer.parseInt(o2.getYellow());
                    if (s1 < s2) {
                        return 1;
                    }
                    return -1;
                } else if ("green".equals(s)) {
                    int s1 = Integer.parseInt(o1.getGreen());
                    int s2 = Integer.parseInt(o2.getGreen());
                    if (s1 < s2) {
                        return 1;
                    }
                    return -1;
                } else if ("road".equals(s)) {
                    int s1 = Integer.parseInt(o1.getRoad());
                    int s2 = Integer.parseInt(o2.getRoad());
                    if (s1 < s2) {
                        return 1;
                    }
                    return -1;
                }

                return -1;
            }
        });
    }
}
