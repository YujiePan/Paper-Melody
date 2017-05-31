package com.papermelody.model.response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by HgS_1217_ on 2017/5/30.
 */

public class UploadImgResponse extends HttpResponse {
    /**
     * 上传图片的响应
     */

    @SerializedName("imgName")
    private String imgName;

    public String getImgName() {
        return imgName;
    }
}
