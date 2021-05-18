package com.xin.follow.discover.adapter.provider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.follow.R;
import com.xin.follow.databinding.FollowItemContentBannerViewBinding;
import com.xin.follow.discover.bean.viewmodel.ContentBannerViewModel;

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
public class ContentBannerProvider extends BaseItemProvider<BaseCustomViewModel>
{
    @Override
    public int getItemViewType()
    {
        return IDisCoverItemType.CONTENT_BANNER_VIEW;
    }
    
    @Override
    public int getLayoutId()
    {
        return R.layout.follow_item_content_banner_view;
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
        FollowItemContentBannerViewBinding binding = baseViewHolder.getBinding();
        if (binding != null)
        {
            binding.setViewModel((ContentBannerViewModel)baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
