package com.xin.home.nominate;

import java.util.ArrayList;

import com.xin.base.activity.IBasePagingView;
import com.xin.common.contract.BaseCustomViewModel;

/**
 * 应用模块: 首页
 * <p>
 * 类描述: 定制界面 Ui 刷新行为
 * <p>
 *
 * @author zxj
 * @since 2020-02-11
 */
public interface INominateView extends IBasePagingView
{
    
    /**
     * 数据加载完成
     * 
     * @param viewModels data
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels,
                          boolean isFirstPage);
    
}
