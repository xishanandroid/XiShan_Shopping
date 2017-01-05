package com.example.yishi.xishan.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yishi.xishan.R;
import com.example.yishi.xishan.fragment.CategoryFragment;
import com.example.yishi.xishan.fragment.HomeFragment;
import com.example.yishi.xishan.fragment.PersonFragment;
import com.example.yishi.xishan.fragment.SearchFragment;
import com.example.yishi.xishan.fragment.ShoppingFragmnet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends BaseActivity {


    @BindView(R.id.main_fragment)
    FrameLayout mainFragment;
    @BindView(R.id.main_home_image)
    CheckedTextView mainHomeImage;
    @BindView(R.id.main_home_text)
    TextView mainHomeText;
    @BindView(R.id.main_category_image)
    CheckedTextView mainCategoryImage;
    @BindView(R.id.main_category_text)
    TextView mainCategoryText;
    @BindView(R.id.main_search_image)
    CheckedTextView mainSearchImage;
    @BindView(R.id.main_search_text)
    TextView mainSearchText;
    @BindView(R.id.main_shopping_image)
    CheckedTextView mainShoppingImage;
    @BindView(R.id.main_shopping_text)
    TextView mainShoppingText;
    @BindView(R.id.main_person_image)
    CheckedTextView mainPersonImage;
    @BindView(R.id.main_person_text)
    TextView mainPersonText;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    @BindView(R.id.main_home)
    LinearLayout mainHome;
    @BindView(R.id.main_category)
    LinearLayout mainCategory;
    @BindView(R.id.search)
    LinearLayout search;
    @BindView(R.id.shopping)
    LinearLayout shopping;
    @BindView(R.id.person)
    LinearLayout person;


    private FragmentManager fm;
    private FragmentTransaction ft;
    private List<Fragment> fragments; //首页的5个Fragment界面存放的集合
    private CheckedTextView[] checkedTextViews; //首页下面5个按钮图片存放的数组
    private TextView[] textViews; //首页下面5个按钮text存放的数组


    @Override
    public int getContentViewResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initViews() {
        fm = this.getSupportFragmentManager();
        fragments = getFragments();
        checkedTextViews = new CheckedTextView[]{mainHomeImage, mainCategoryImage, mainSearchImage, mainShoppingImage, mainPersonImage};
        textViews = new TextView[]{mainHomeText, mainCategoryText, mainSearchText, mainShoppingText, mainPersonText};
        setCurrentFragment(0);
    }

    @Override
    protected void initDatas() {

    }

    /**
     * 点击切换fragment
     *
     * @param index
     */
    private Fragment currentFrag = null;
    private int currentIndex = -1;
    private HomeFragment homeFragment;
    private CategoryFragment categoryFragment;
    private SearchFragment searchFragment;
    private ShoppingFragmnet shoppingFragmnet;
    private PersonFragment personFragment;

    private void setCurrentFragment(int index) {
        ft = fm.beginTransaction();
        if (currentIndex != -1) {
            checkedTextViews[currentIndex].setChecked(false);
            textViews[currentIndex].setTextColor(Color.BLACK);
        }
        checkedTextViews[index].setChecked(true);
        textViews[index].setTextColor(Color.rgb(0, 160, 81));
        if (currentIndex == index) {
            return;
        } else {
            currentIndex = index;
        }
        if (currentFrag != null) {
            ft.hide(currentFrag);
        }
        switch (index) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    ft.add(R.id.main_fragment, fragments.get(0));
                } else {
                    ft.show(fragments.get(0));
                }
                currentFrag = fragments.get(0);
                break;
            case 1:
                if (categoryFragment == null) {
                    categoryFragment = new CategoryFragment();
                    ft.add(R.id.main_fragment, fragments.get(1));
                } else {
                    ft.show(fragments.get(1));
                }
                currentFrag = fragments.get(1);
                break;
            case 2:
                if (searchFragment == null) {
                    searchFragment = new SearchFragment();
                    ft.add(R.id.main_fragment, fragments.get(2));
                } else {
                    ft.show(fragments.get(2));
                }
                currentFrag = fragments.get(2);
                break;
            case 3:
                if (shoppingFragmnet == null) {
                    shoppingFragmnet = new ShoppingFragmnet();
                    ft.add(R.id.main_fragment, fragments.get(3));
                } else {
                    ft.show(fragments.get(3));
                }
                currentFrag = fragments.get(3);
                break;
            case 4:
                if (personFragment == null) {
                    personFragment = new PersonFragment();
                    ft.add(R.id.main_fragment, fragments.get(4));
                } else {
                    ft.show(fragments.get(4));
                }
                currentFrag = fragments.get(4);
                break;
        }
        ft.commit();
    }

    /**
     * 将首页的5个Fragment存放入集合并返回
     *
     * @return
     */
    private List<Fragment> getFragments() {
        this.fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new CategoryFragment());
        fragments.add(new SearchFragment());
        fragments.add(new ShoppingFragmnet());
        fragments.add(new PersonFragment());
        return fragments;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    /**
     * 点击切换fragment
     * @param view
     */
    @OnClick({R.id.main_home, R.id.main_category, R.id.search, R.id.shopping, R.id.person})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.main_home:
                setCurrentFragment(0);
                break;
            case R.id.main_category:
                setCurrentFragment(1);
                break;
            case R.id.search:
                setCurrentFragment(2);
                break;
            case R.id.shopping:
                setCurrentFragment(3);
                break;
            case R.id.person:
                setCurrentFragment(4);
                break;
        }
    }
}
