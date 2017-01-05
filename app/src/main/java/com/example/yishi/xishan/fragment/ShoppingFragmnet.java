package com.example.yishi.xishan.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yishi.xishan.R;
import com.example.yishi.xishan.activity.MainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Yishi on 2017/1/5.
 */
public class ShoppingFragmnet extends BaseFragment {
    @BindView(R.id.title_back)
    ImageView titleBack;
    @BindView(R.id.title_text)
    TextView titleText;
    @BindView(R.id.title_right)
    ImageView titleRight;
    @BindView(R.id.title_ll)
    LinearLayout titleLl;

    @Override
    protected int getContentViewResID() {
        return R.layout.shopping_fragment;
    }

    @Override
    protected void initViews() {
        titleText.setText("购物车");
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

    @OnClick({R.id.title_back, R.id.title_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                startActivity(new Intent(this.getActivity(), MainActivity.class));
                this.getActivity().finish();
                break;
            case R.id.title_right:
                break;
        }
    }
}
