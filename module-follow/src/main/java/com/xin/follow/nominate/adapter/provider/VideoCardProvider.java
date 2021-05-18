package com.xin.follow.nominate.adapter.provider;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import com.alibaba.android.arouter.launcher.ARouter;
import com.chad.library.adapter.base.provider.BaseItemProvider;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.common.contract.VideoHeaderBean;
import com.xin.common.router.RouterActivityPath;
import com.xin.follow.R;
import com.xin.follow.databinding.FollowItemVideoCardViewBinding;
import com.xin.follow.nominate.bean.viewmodel.VideoCardViewModel;


import androidx.databinding.DataBindingUtil;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-14
 */
public class VideoCardProvider extends BaseItemProvider<BaseCustomViewModel>
{
    @Override
    public int getItemViewType()
    {
        return NominateItemType.VIDEO_CARD_VIEW;
    }
    
    @Override
    public int getLayoutId()
    {
        return R.layout.follow_item_video_card_view;
    }
    
    @Override
    public void onViewHolderCreated(BaseViewHolder viewHolder, int viewType)
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
        
        FollowItemVideoCardViewBinding binding = baseViewHolder.getBinding();
        if (binding != null)
        {
            VideoCardViewModel cardViewModel = (VideoCardViewModel)baseCustomViewModel;
            binding.ivVideoCover.setOnClickListener(v -> {
                //TODO
                VideoHeaderBean headerBean = new VideoHeaderBean(
                        cardViewModel.title, cardViewModel.description,
                        cardViewModel.video_description,
                        cardViewModel.collectionCount, cardViewModel.shareCount,
                        cardViewModel.authorUrl, cardViewModel.nickName,
                        cardViewModel.userDescription, cardViewModel.playerUrl,
                        cardViewModel.blurredUrl, cardViewModel.videoId);
                ARouter.getInstance()
                        .build(RouterActivityPath.Video.PAGER_VIDEO)
                        .withParcelable("videoInfo", headerBean)
                        .navigation();
            });
            binding.setViewModel(cardViewModel);
            binding.executePendingBindings();
        }
    }
}
