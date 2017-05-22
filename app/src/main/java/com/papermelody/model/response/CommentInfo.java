package com.papermelody.model.response;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

/**
 * Created by HgS_1217_ on 2017/5/22.
 */

public class CommentInfo {
    /**
     * 接收服务器端的comment json数据
     */

    @SerializedName("musicID")
    private String musicID;
    @SerializedName("author")
    private String author;
    @SerializedName("createTime")
    private Date createTime;
    @SerializedName("comment")
    private String comment;

    public String getMusicID() {
        return musicID;
    }

    public String getComment() {
        return comment;
    }

    public String getAuthor() {
        return author;
    }

    public Date getCreateTime() {
        return createTime;
    }
}
