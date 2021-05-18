package com.xin.player.adapter;

import java.util.List;

import org.jetbrains.annotations.NotNull;

import com.chad.library.adapter.base.BaseProviderMultiAdapter;
import com.xin.common.contract.BaseCustomViewModel;
import com.xin.player.adapter.provider.IVideoItemType;
import com.xin.player.adapter.provider.NominateViewProvider;
import com.xin.player.adapter.provider.ReplyViewProvider;
import com.xin.player.adapter.provider.TitleViewProvider;
import com.xin.player.bean.viewmodel.ReplyViewModel;
import com.xin.player.bean.viewmodel.VideoCardViewModel;
import com.xin.player.bean.viewmodel.VideoTextViewModel;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-20
 */
public class ProviderVideoPagerAdapter
    extends BaseProviderMultiAdapter<BaseCustomViewModel>
{
    
    public ProviderVideoPagerAdapter()
    {
        super();
        addItemProvider(new TitleViewProvider());
        addItemProvider(new NominateViewProvider());
        addItemProvider(new ReplyViewProvider());
    }
    
    @Override
    protected int getItemType(@NotNull List<? extends BaseCustomViewModel> data,
        int position)
    {

        if (data.get(position) instanceof VideoTextViewModel)
        {

            return IVideoItemType.TITLE_VIEW;
        }
        else if (data.get(position) instanceof VideoCardViewModel)
        {

            return IVideoItemType.NOMINATE_VIEW;

        }
        else if (data.get(position) instanceof ReplyViewModel)
        {

            return IVideoItemType.REPLY_VIEW;
        }
        return 0;
    }
}
