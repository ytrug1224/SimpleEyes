package com.xin.more.message;

import java.util.List;

import com.xin.base.activity.IBasePagingView;
import com.xin.common.contract.BaseCustomViewModel;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-23
 */
public interface IMessageView extends IBasePagingView {
    /**
     * @param data 数据
     * @param isFirstPage 是否是第一页
     * */
    void onDataLoaded(List<BaseCustomViewModel> data, boolean isFirstPage);
}
