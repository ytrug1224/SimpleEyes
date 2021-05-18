package com.xin.follow.discover.adapter;

import androidx.databinding.DataBindingUtil;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xin.follow.databinding.FollowItemCategoryItemCardViewBinding;
import com.xin.follow.discover.bean.SquareCard;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * 应用模块:
 * <p>
 * 类描述: 热门分类 adapter
 * <p>
 *
 * @author zxj
 * @since 2020-02-15
 */
public class CategoryItemAdapter
        extends BaseQuickAdapter<SquareCard, BaseViewHolder> {

    public CategoryItemAdapter(int layoutResId) {
        super(layoutResId);
    }

    @Override
    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder,
                                           int viewType) {
        DataBindingUtil.bind(viewHolder.itemView);
    }

    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder,
                           @Nullable SquareCard squareCard) {
        if (squareCard == null) {
            return;
        }
        FollowItemCategoryItemCardViewBinding binding = baseViewHolder.getBinding();
        if (binding != null) {
            binding.setViewModel(squareCard);
            binding.executePendingBindings();
        }
    }
}
