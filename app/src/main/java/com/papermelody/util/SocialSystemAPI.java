package com.papermelody.util;

import com.papermelody.model.response.HttpResponse;
import com.papermelody.model.response.OnlineMusicListResponse;
import com.papermelody.model.response.UserResponse;

import java.util.Date;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by HgS_1217_ on 2017/4/10.
 */

public interface SocialSystemAPI {
    /**
     * 社交系统API，提供与服务器互相交互的接口
     */

    // 登录
    @FormUrlEncoded
    @POST("login")
    Observable<UserResponse> login(@Field("name") String username,
                                   @Field("pw") String password);

    // 注册
    @FormUrlEncoded
    @POST("register")
    Observable<UserResponse> register(@Field("name") String username,
                                      @Field("pw") String password);

    // 上传作品
    @FormUrlEncoded
    @POST("uploadmusic")
    Observable<HttpResponse> uploadMusic(@Field("name") String name,
                                         @Field("author") String author,
                                         @Field("date") Date date,
                                         @Field("link") String link);

    // 音乐圈作品获取
    @GET("onlinemusics")
    Observable<OnlineMusicListResponse> getOnlineMusicList();
}