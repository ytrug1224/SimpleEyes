package com.xin.follow;


import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.android.material.tabs.TabLayout;
import com.xin.base.fragment.MvvmLazyFragment;
import com.xin.base.viewmodel.IMvvmBaseViewModel;
import com.xin.common.router.RouterFragmentPath;
import com.xin.follow.adapter.FollowFragmentPageAdapter;
import com.xin.follow.daily.DailyFragment;
import com.xin.follow.databinding.FollowFragmentFollowBinding;
import com.xin.follow.discover.DisCoverFragment;
import com.xin.follow.nominate.NominateFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 应用模块: chat
 * <p>
 * 类描述: 首页-fragment
 * <p>
 *
 * @author zxj
 * @since 2020-01-27
 */
@Route(path = RouterFragmentPath.Follow.PAGER_FOLLOW)
public class FollowFragment extends MvvmLazyFragment<FollowFragmentFollowBinding, IMvvmBaseViewModel> {

    private FollowFragmentPageAdapter pageAdapter;

    @Override
    protected void onFragmentFirstVisible() {
        super.onFragmentFirstVisible();
        initView();
        List<Fragment> fragments = new ArrayList<>();
        fragments.add(DisCoverFragment.newInstance());
        fragments.add(NominateFragment.newInstance());
        fragments.add(DailyFragment.newInstance());
        pageAdapter.setData(fragments);
        viewDataBinding.vpFollowContent.setCurrentItem(1);

    }

    private void initView() {
        pageAdapter = new FollowFragmentPageAdapter(getChildFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewDataBinding.vpFollowContent.setAdapter(pageAdapter);
        viewDataBinding.tabLayout.setupWithViewPager(viewDataBinding.vpFollowContent);
        viewDataBinding.vpFollowContent.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(viewDataBinding.tabLayout));
        viewDataBinding.tabLayout
                .addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        viewDataBinding.vpFollowContent.setCurrentItem(tab.getPosition());
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                });
        viewDataBinding.ivNetSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                VideoHeaderBean videoHeaderBean = new VideoHeaderBean("1","1","1",0,9,"1","1","1","1");
//                LiveDatabus.getInstance().withSticky("player",VideoHeaderBean.class).setValue(videoHeaderBean);
//                startActivity(new Intent(getContext(), VideoInfoAndPlayerActivity.class));
            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.follow_fragment_follow;
    }

    @Override
    public int getBindingVariable() {
        return 0;
    }

    @Override
    protected IMvvmBaseViewModel getViewModel() {
        return null;
    }

    @Override
    protected void onRetryBtnClick() {

    }


}
