package com.example.hechengbin.adapplication;

import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import okhttp3.Response;

/**
 * Created by hechengbin on 2017/5/26.
 */

public abstract class ADCallBack extends Callback<ADBean> {
    @Override
    public ADBean parseNetworkResponse(Response response, int id) throws Exception {
        String string = response.body().string();
        ADBean user = new Gson().fromJson(string, ADBean.class);
        return user;
    }


}
