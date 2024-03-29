package com.xin.home.daily;

import com.xin.base.activity.IBasePagingView;
import com.xin.common.contract.BaseCustomViewModel;

import java.util.ArrayList;


/**
 * 应用模块: daily
 * <p>
 * 类描述: UI 更新
 * <p>
 *
 * @author zxj
 * @since 2020-02-14
 */
public interface IDailyView  extends IBasePagingView {

    /**
     * 数据加载完成
     *
     * @param viewModels data
     */
    void onDataLoadFinish(ArrayList<BaseCustomViewModel> viewModels,
                          boolean isFirstPage);

}
