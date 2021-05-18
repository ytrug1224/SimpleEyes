package com.xin.follow.discover.adapter.provider;

import androidx.databinding.DataBindingUtil;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.common.router.RouterActivityPath;
import com.xin.follow.R;
import com.xin.follow.databinding.FollowItemBriefCardViewBinding;
import com.xin.follow.discover.bean.viewmodel.BriefCardViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-15
 */
public class ThemeProvider extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType() {
        return IDisCoverItemType.THEME_CARD_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.follow_item_brief_card_view;
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
        FollowItemBriefCardViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.btnAction.setOnClickListener(v -> {
                ARouter.getInstance()
                        .build(RouterActivityPath.User.PAGER_ATTENTION)
                        .navigation();
            });
            binding.setViewModel((BriefCardViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
