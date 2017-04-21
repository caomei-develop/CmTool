package com.caomei.cn.cmtool.ui.activity;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.base.BaseActivity;
import com.caomei.cn.cmtool.ui.fragment.NewsFragment;
import com.caomei.cn.cmtool.ui.fragment.NovelFragment;
import com.caomei.cn.cmtool.ui.fragment.PicturesFragment;
import com.caomei.cn.cmtool.ui.fragment.VideoFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    /**
     * 新闻。图片。视频。小说底部导航
     */
    private NewsFragment mNewsFragment;
    private PicturesFragment mPicturesFragment;
    private VideoFragment mVideoFragment;
    private NovelFragment mNovelFragment;
    private ImageView mXwImg,mTpImg,mSpImg,mXsImg;
    private TextView mXwTxt,mTpTxt,mSpTxt,mXsTxt;

    private FragmentManager fManager;

    private LinearLayout mXwlayout,mTpLayout,mSpLayout,mXsLayout;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void init() {
        super.init();
        fManager = getSupportFragmentManager();
        initview();
        mListener();
        setTabSelection(0);
    }

    private void initview() {
        mXwlayout = (LinearLayout) findViewById(R.id.Xw_layout);
        mTpLayout = (LinearLayout) findViewById(R.id.Tp_layout);
        mSpLayout = (LinearLayout) findViewById(R.id.Sp_layout);
        mXsLayout = (LinearLayout) findViewById(R.id.Xs_layout);
        mXwImg = (ImageView) findViewById(R.id.Xw_img);
        mTpImg = (ImageView) findViewById(R.id.Tp_img);
        mSpImg = (ImageView) findViewById(R.id.Sp_img);
        mXsImg = (ImageView) findViewById(R.id.Xs_img);
        mXwTxt = (TextView) findViewById(R.id.Xw_txt);
        mTpTxt = (TextView) findViewById(R.id.Tp_txt);
        mSpTxt = (TextView) findViewById(R.id.Sp_txt);
        mXsTxt = (TextView) findViewById(R.id.Xs_txt);


    }
    private void mListener() {
        mXwlayout.setOnClickListener(this);
        mTpLayout.setOnClickListener(this);
        mSpLayout.setOnClickListener(this);
        mXsLayout.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.Xw_layout:
                setTabSelection(0);
                break;
            case R.id.Tp_layout:
                setTabSelection(1);
                break;
            case R.id.Sp_layout:
                setTabSelection(2);
                break;
            case R.id.Xs_layout:
                setTabSelection(3);
                break;
        }

    }

    private void setTabSelection(int i) {
        FragmentTransaction transaction = fManager.beginTransaction();
        clearChioce();
        hideFragments(transaction);
        switch (i){
            case 0:
                mXwTxt.setTextColor(this.getResources().getColor(R.color.fmgtab));
                mXwImg.setImageResource(R.mipmap.xw);
                if (mNewsFragment == null) {
                    mNewsFragment = new NewsFragment();
                    transaction.add(R.id.mFragment_context, mNewsFragment);
                } else {
                    transaction.show(mNewsFragment);
                }
                break;
            case 1:
                mTpTxt.setTextColor(this.getResources().getColor(R.color.fmgtab));
                mTpImg.setImageResource(R.mipmap.tp);
                if (mPicturesFragment == null) {
                    mPicturesFragment = new PicturesFragment();
                    transaction.add(R.id.mFragment_context, mPicturesFragment);
                } else {
                    transaction.show(mPicturesFragment);
                }
                break;
            case 2:
                mSpTxt.setTextColor(this.getResources().getColor(R.color.fmgtab));
                mSpImg.setImageResource(R.mipmap.sp);
                if (mVideoFragment == null) {
                    mVideoFragment = new VideoFragment();
                    transaction.add(R.id.mFragment_context, mVideoFragment);
                } else {
                    transaction.show(mVideoFragment);
                }
                break;
            case 3:
                mXsTxt.setTextColor(this.getResources().getColor(R.color.fmgtab));
                mXsImg.setImageResource(R.mipmap.xs);
                if (mNovelFragment == null) {
                    mNovelFragment = new NovelFragment();
                    transaction.add(R.id.mFragment_context, mNovelFragment);
                } else {
                    transaction.show(mNovelFragment);
                }
                break;
        }
        transaction.commit();

    }

    private void clearChioce() {
        mXsTxt.setTextColor(this.getResources().getColor(R.color.txt));
        mXsImg.setImageResource(R.mipmap.xw2);
        mTpTxt.setTextColor(this.getResources().getColor(R.color.txt));
        mTpImg.setImageResource(R.mipmap.tp2);
        mSpTxt.setTextColor(this.getResources().getColor(R.color.txt));
        mSpImg.setImageResource(R.mipmap.sp2);
        mXsTxt.setTextColor(this.getResources().getColor(R.color.txt));
        mXwImg.setImageResource(R.mipmap.xs2);

    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mNewsFragment != null) {
            transaction.hide(mNewsFragment);
        }
        if (mPicturesFragment != null) {
            transaction.hide(mPicturesFragment);
        }
        if (mVideoFragment != null) {
            transaction.hide(mVideoFragment);
        }
        if (mNovelFragment != null) {
            transaction.hide(mNovelFragment);
        }
    }
    /**
     * menu 菜单选项
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    /**
     *菜单选项 item
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_settings:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
