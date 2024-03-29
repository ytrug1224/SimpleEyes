package com.xin.follow.discover;

import java.util.ArrayList;

import com.xin.base.fragment.MvvmLazyFragment;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.follow.R;
import com.xin.follow.discover.adapter.ProviderDisCoverAdapter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.xin.follow.databinding.FollowFragmentFindMoreBinding;

import android.view.LayoutInflater;
import android.view.View;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * 应用模块:
 * <p>
 * 类描述: 发现
 * <p>
 *
 * @author zxj
 * @since 2020-02-09
 */
public class DisCoverFragment extends MvvmLazyFragment<FollowFragmentFindMoreBinding, DisCoverViewModel>
    implements IDisCoverView
{
    
    private ProviderDisCoverAdapter adapter;
    
    public static DisCoverFragment newInstance()
    {
        DisCoverFragment fragment = new DisCoverFragment();
        return fragment;
    }
    
    @Override
    protected void onFragmentFirstVisible()
    {
        super.onFragmentFirstVisible();
        initView();
    }
    
    private void initView()
    {
        // 确定Item的改变不会影响RecyclerView的宽高
        viewDataBinding.rvDiscoverView.setHasFixedSize(true);
        viewDataBinding.rvDiscoverView
            .setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProviderDisCoverAdapter();
        adapter.addFooterView(getFooterView());
        viewDataBinding.rvDiscoverView.setAdapter(adapter);
        viewDataBinding.refreshLayout
            .setRefreshHeader(new ClassicsHeader(getContext()));
        viewDataBinding.refreshLayout.setOnRefreshListener(refreshLayout -> {
            viewModel.tryToRefresh();
        });
        setLoadSir(viewDataBinding.refreshLayout);
        showLoading();
        viewModel.initModel();
    }
    
    private View getFooterView()
    {
        return LayoutInflater.from(getContext())
            .inflate(R.layout.follow_item_foote_view,
                viewDataBinding.rvDiscoverView,
                false);
    }
    
    @Override
    public int getLayoutId()
    {
        return R.layout.follow_fragment_find_more;
    }
    
    @Override
    public int getBindingVariable()
    {
        return 0;
    }
    
    @Override
    protected DisCoverViewModel getViewModel()
    {
        return ViewModelProviders.of(this).get(DisCoverViewModel.class);
    }
    
    @Override
    protected void onRetryBtnClick()
    {
        
    }
    
    @Override
    public void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels,
        boolean isEmpty)
    {
        if (isEmpty)
        {
            viewDataBinding.refreshLayout.finishRefresh(false);
        }
        else
        {
            viewDataBinding.refreshLayout.finishRefresh(true);
        }
        adapter.setNewData(viewModels);
        showContent();
    }
}
