package com.xin.follow.nominate;

import java.util.ArrayList;

import com.xin.base.fragment.MvvmLazyFragment;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.follow.R;
import com.xin.follow.nominate.adapter.ProviderNominateAdapter;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.xin.follow.databinding.FollowFragmentNominateBinding;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;

/**
 * 应用模块: 首页
 * <p>
 * 类描述: 首页-推荐
 * <p>
 *
 * @author zxj
 * @since 2020-02-09
 */
public class NominateFragment
    extends MvvmLazyFragment<FollowFragmentNominateBinding, NominateViewModel>
    implements INominateView
{
    private ProviderNominateAdapter adapter;
    
    public static NominateFragment newInstance()
    {
        NominateFragment fragment = new NominateFragment();
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
        viewDataBinding.rvNominateView.setHasFixedSize(true);
        viewDataBinding.rvNominateView
            .setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProviderNominateAdapter();
        adapter.addHeaderView(getHeaderView());
        viewDataBinding.rvNominateView.setAdapter(adapter);
        viewDataBinding.refreshLayout
            .setRefreshHeader(new ClassicsHeader(getContext()));
        viewDataBinding.refreshLayout
            .setRefreshFooter(new ClassicsFooter(getContext()));
        viewDataBinding.refreshLayout.setOnRefreshListener(refreshLayout -> {
            viewModel.tryToRefresh();
        });
        viewDataBinding.refreshLayout.setOnLoadMoreListener(refreshLayout -> {
            viewModel.loadMore();
        });
        setLoadSir(viewDataBinding.refreshLayout);
        showLoading();
        viewModel.initModel();
        
    }

    /**
     * 配置头部banner
     * */
    private View getHeaderView()
    {
        ViewDataBinding binding = DataBindingUtil.inflate(getLayoutInflater(),
            R.layout.follow_item_banner_view,
            viewDataBinding.rvNominateView,
            false);
        View view = binding.getRoot();
        return view;
    }
    
    @Override
    public int getLayoutId()
    {
        return R.layout.follow_fragment_nominate;
    }
    
    @Override
    public int getBindingVariable()
    {
        return 0;
    }
    
    @Override
    protected NominateViewModel getViewModel()
    {
        
        return ViewModelProviders.of(this).get(NominateViewModel.class);
    }
    
    @Override
    protected void onRetryBtnClick()
    {
        
    }
    
    @Override
    public void onLoadMoreFailure(String message)
    {
        viewDataBinding.refreshLayout.finishLoadMore(false);
    }
    
    @Override
    public void onLoadMoreEmpty()
    {
        viewDataBinding.refreshLayout.finishLoadMoreWithNoMoreData();
    }
    
    @Override
    public void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels,
        boolean isFirstPage)
    {
        if (isFirstPage)
        {
            adapter.setNewData(viewModels);
            showContent();
            viewDataBinding.refreshLayout.finishRefresh(true);
        }
        else
        {
            adapter.addData(viewModels);
            showContent();
            viewDataBinding.refreshLayout.finishLoadMore(true);
        }
        
    }
}
