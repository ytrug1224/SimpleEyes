package com.xin.mvvmcomponent;

import android.content.Context;

import com.github.moduth.blockcanary.BlockCanaryContext;

import java.util.ArrayList;

public class AppBlockContext extends BlockCanaryContext {
    public AppBlockContext() {
        super();
    }

    @Override
    public Context provideContext() {
        return super.provideContext();
    }

    @Override
    public String provideUid() {
        return super.provideUid();
    }

    @Override
    public String provideNetworkType() {
        return super.provideNetworkType();
    }

    @Override
    public int provideMonitorDuration() {
        return super.provideMonitorDuration();
    }

    @Override
    public int provideBlockThreshold() {
        return super.provideBlockThreshold();
    }
}