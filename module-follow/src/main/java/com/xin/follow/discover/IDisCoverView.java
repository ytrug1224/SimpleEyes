package com.xin.follow.discover;

import com.xin.base.activity.IBaseView;
import com.xin.common.contract.BaseCustomViewModel;

import java.util.ArrayList;


/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-15
 */
public interface IDisCoverView extends IBaseView
{
    
    /**
     * 数据加载完成
     *
     * @param viewModels data
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels,
                          boolean isEmpty);
    
}
