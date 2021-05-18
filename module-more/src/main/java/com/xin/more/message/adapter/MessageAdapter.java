package com.xin.more.message.adapter;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.more.R;
import com.xin.more.databinding.MoreItemMessageViewBinding;
import com.xin.more.message.bean.MessageViewModel;

import androidx.databinding.DataBindingUtil;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-23
 */
public class MessageAdapter
    extends BaseQuickAdapter<BaseCustomViewModel, BaseViewHolder>
{
    public MessageAdapter()
    {
        super(R.layout.more_item_message_view);
    }
    
    @Override
    protected void onItemViewHolderCreated(@NotNull BaseViewHolder viewHolder,
        int viewType)
    {
        DataBindingUtil.bind(viewHolder.itemView);
    }
    
    @Override
    protected void convert(@NotNull BaseViewHolder baseViewHolder,
        @Nullable BaseCustomViewModel baseCustomViewModel)
    {
        if (baseCustomViewModel == null)
        {
            return;
        }

        MoreItemMessageViewBinding binding = baseViewHolder.getBinding();
        if (binding != null){
            binding.setViewModel((MessageViewModel) baseCustomViewModel);
            binding.executePendingBindings();
        }
    }
}
