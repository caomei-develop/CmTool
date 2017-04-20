package com.caomei.cn.cmtool.ui.activity;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.caomei.cn.cmtool.R;
import com.caomei.cn.cmtool.adapter.Aadapter;
import com.caomei.cn.cmtool.api.Api;
import com.caomei.cn.cmtool.base.BaseActivity;
import com.caomei.cn.cmtool.bean.returns.Abean;
import com.caomei.cn.cmtool.presenter.BasePresenter;
import com.caomei.cn.cmtool.presenter.MainPresenterImp;

import java.util.ArrayList;

public class MainActivity extends BaseActivity{
    private static final String BTURL = Api.BASEURL;
    private RecyclerView  Arv;
    private Toolbar mTbar;
    private Aadapter mAadapter ;
    private BasePresenter mBasePresenter;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }
    @Override
    protected void init() {
        super.init();
        initview();
        setSupportActionBar(mTbar);
        mBasePresenter = new MainPresenterImp(this);
        mBasePresenter.doGet(BTURL);
    }
    private void initview() {
    }


    public void getFlList(int sta,ArrayList<Abean.FlListEntity> fl_list) {
        if (fl_list !=null){

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
