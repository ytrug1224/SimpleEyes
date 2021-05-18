package com.xin.follow.discover.adapter.provider;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.common.router.RouterFragmentPath;
import com.xin.follow.R;
import com.xin.follow.databinding.FollowItemTopBannerViewBinding;
import com.xin.follow.discover.bean.viewmodel.TopBannerViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 应用模块:
 * <p>
 * 类描述: 顶部广告Banner
 * <p>
 *
 * @author zxj
 * @since 2020-02-15
 */
public class TopBannerProvider extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType() {
        return IDisCoverItemType.TOP_BANNER_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.follow_item_top_banner_view;
    }

    @Override
    public void onViewHolderCreated(@NotNull BaseViewHolder viewHolder,
                                    int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder,
                        @Nullable BaseCustomViewModel baseCustomViewModel) {
        if (baseCustomViewModel == null) {
            return;
        }
        FollowItemTopBannerViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((TopBannerViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
