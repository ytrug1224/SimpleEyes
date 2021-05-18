package com.xin.community.recommend;


import com.xin.base.model.BasePagingModel;
import com.xin.base.model.IPagingModelListener;
import com.xin.base.viewmodel.MvmBaseViewModel;
import com.xin.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-16
 */
public class RecommendViewModel
    extends MvmBaseViewModel<IRecommendView, RecommendModel>
    implements IPagingModelListener<ArrayList<BaseCustomViewModel>>
{
    
    @Override
    protected void initModel()
    {
        model = new RecommendModel();
        model.register(this);
        model.getCacheDataAndLoad();
    }

    @Override
    public void detachUi() {
        super.detachUi();
        if (model != null){
            model.unRegister(this);
        }
    }

    public void tryRefresh()
    {
        model.refresh();
    }
    
    public void loadMore()
    {
        model.loadMore();
    }
    
    @Override
    public void onLoadFinish(BasePagingModel model,
                             ArrayList<BaseCustomViewModel> data, boolean isEmpty,
                             boolean isFirstPage)
    {
        if (getPageView() != null)
        {
            if (isEmpty)
            {
                if (isFirstPage)
                {
                    getPageView().showEmpty();
                }
                else
                {
                    getPageView().onLoadMoreEmpty();
                }
            }
            else
            {
                getPageView().onDataLoadFinish(data, isFirstPage);
            }
        }
    }
    
    @Override
    public void onLoadFail(BasePagingModel model, String prompt,
        boolean isFirstPage)
    {
        if (getPageView() != null)
        {
            if (isFirstPage)
            {
                getPageView().showFailure(prompt);
            }
            else
            {
                getPageView().onLoadMoreFailure(prompt);
            }
        }
    }
}
