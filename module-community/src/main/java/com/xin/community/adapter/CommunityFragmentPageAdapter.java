package com.xin.community.adapter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-16
 */
public class CommunityFragmentPageAdapter extends FragmentPagerAdapter {
    private String[] tables = {"推荐","关注"};
    private List<Fragment> fragments;

    public CommunityFragmentPageAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    public void setData(List<Fragment> data){
       if (fragments == null){
           fragments = new ArrayList<>();
       }
       fragments.addAll(data);
       notifyDataSetChanged();
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        if (fragments != null && fragments.size() >0){
            return fragments.size();
        }
        return 0;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tables[position];
    }
}
