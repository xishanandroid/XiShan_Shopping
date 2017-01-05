package com.example.yishi.xishan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.yishi.xishan.R;
import com.example.yishi.xishan.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2017/1/5.
 */
public class SearchFragment extends BaseFragment {

    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.title_right)
    ImageView titleRight;

    @Override
    protected int getContentViewResID() {
        return R.layout.searchfragment;
    }

    @Override
    protected void initViews() {
        titleText.setText("搜索");
        titleBack.setVisibility(View.GONE);
    }

    @Override
    protected void initDatas() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @OnClick(R.id.title_back)
    public void onClick() {
        startActivity(new Intent(this.getActivity(), MainActivity.class));
        this.getActivity().finish();
    }
}
