package com.xin.home.discover.adapter.provider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.home.R;
import com.xin.home.databinding.HomeItemTitleLeftRightViewBinding;
import com.xin.home.nominate.bean.viewmodel.TitleViewModel;

import androidx.databinding.DataBindingUtil;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-15
 */
public class TitleProvider extends BaseItemProvider<BaseCustomViewModel>
{
    @Override
    public int getItemViewType()
    {
        return IDisCoverItemType.TITLE_VIEW;
    }
    
    @Override
    public int getLayoutId()
    {
        return R.layout.home_item_title_left_right_view;
    }
    
    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder,
        int viewType)
    {
        DataBindingUtil.bind(viewHolder.itemView);
    }
    
    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder,
        @Nullable BaseCustomViewModel baseCustomViewModel)
    {
        if (baseCustomViewModel == null)
        {
            return;
        }
        HomeItemTitleLeftRightViewBinding binding = baseViewHolder.getBinding();
        if (binding != null)
        {
            binding.setViewModel((TitleViewModel)baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
