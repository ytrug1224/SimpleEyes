package com.xin.follow.nominate.adapter.provider;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.follow.R;
import com.xin.follow.databinding.FollowItemTitleLeftRightViewBinding;
import com.xin.follow.nominate.bean.viewmodel.TitleViewModel;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-14
 */
public class TitleProvider extends BaseItemProvider<BaseCustomViewModel> {
    @Override
    public int getItemViewType() {
        return NominateItemType.TITLE_VIEW;
    }

    @Override
    public int getLayoutId() {
        return R.layout.follow_item_title_left_right_view;
    }

    @Override
    public void onViewHolderCreated(BaseViewHolder viewHolder, int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    public void convert(@NotNull BaseViewHolder baseViewHolder,
                        @Nullable BaseCustomViewModel baseCustomViewModel) {
        if (baseCustomViewModel == null) {
            return;
        }

        FollowItemTitleLeftRightViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel((TitleViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
