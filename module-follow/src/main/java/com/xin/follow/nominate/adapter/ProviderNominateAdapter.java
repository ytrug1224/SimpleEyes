package com.xin.follow.nominate.adapter;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.follow.nominate.adapter.provider.FollowCardProvider;
import com.xin.follow.nominate.adapter.provider.NominateItemType;
import com.xin.follow.nominate.adapter.provider.SingleTitleProvider;
import com.xin.follow.nominate.adapter.provider.TitleProvider;
import com.xin.follow.nominate.adapter.provider.VideoCardProvider;
import com.xin.follow.nominate.bean.viewmodel.FollowCardViewModel;
import com.xin.follow.nominate.bean.viewmodel.SingleTitleViewModel;
import com.xin.follow.nominate.bean.viewmodel.TitleViewModel;
import com.xin.follow.nominate.bean.viewmodel.VideoCardViewModel;

import java.util.List;

import org.jetbrains.annotations.NotNull;


/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-14
 */
public class ProviderNominateAdapter
    extends BaseProviderMultiAdapter<BaseCustomViewModel>
{
    
    public ProviderNominateAdapter()
    {
        super();
        // 注册Provide
        addItemProvider(new TitleProvider());
        addItemProvider(new FollowCardProvider());
        addItemProvider(new SingleTitleProvider());
        addItemProvider(new VideoCardProvider());
        
    }
    
    @Override
    protected int getItemType(@NotNull List<? extends BaseCustomViewModel> data,
        int position)
    {
        if (data.get(position) instanceof TitleViewModel)
        {
            return NominateItemType.TITLE_VIEW;
        }
        else if (data.get(position) instanceof FollowCardViewModel)
        {
            return NominateItemType.FOLLOW_CARD_VIEW;
        }
        else

        if (data.get(position) instanceof SingleTitleViewModel)
        {
            return NominateItemType.SINGLE_TITLE_VIEW;
        }
        else if (data.get(position) instanceof VideoCardViewModel)
        {
            return NominateItemType.VIDEO_CARD_VIEW;
        }

        return -1;
    }
}
