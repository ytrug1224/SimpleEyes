package com.xin.player;

import com.xin.base.model.BaseModel;
import com.xin.base.model.IModelListener;
import com.xin.base.viewmodel.MvmBaseViewModel;
import com.xin.common.contract.BaseCustomViewModel;

import java.util.ArrayList;

/**
 * 应用模块:
 * <p>
 * 类描述:
 * <p>
 *
 * @author zxj
 * @since 2020-02-20
 */
public class VideoPlayerViewModel
    extends MvmBaseViewModel<IVideoPlayerView, VideoPlayerModel>
    implements IModelListener<ArrayList<BaseCustomViewModel>>
{
    @Override
    protected void initModel()
    {
        model = new VideoPlayerModel();
        model.register(this);
    }

    public void loadData(int videoId){
        model.videoId = videoId;
        model.load();
    }
    
    @Override
    public void onLoadFinish(BaseModel model,
                             ArrayList<BaseCustomViewModel> data)
    {
        if (getPageView() != null) {
            if (data != null && data.size() > 0){
                getPageView().onDataLoadFinish(data);
            }else {
                getPageView().showEmpty();
            }
        }
    }
    
    @Override
    public void onLoadFail(BaseModel model, String prompt)
    {
        if (getPageView() != null){
            getPageView().showFailure(prompt);
        }
    }
    
    @Override
    public void detachUi()
    {
        super.detachUi();
        if (model != null)
        {
            model.unRegister(this);
        }
    }
    
}
