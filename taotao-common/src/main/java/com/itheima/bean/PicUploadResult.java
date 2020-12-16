package com.itheima.bean;

/*
 *  @创建时间:  2020/12/16 8:42
 *  @描述：    TODO
 */
public class PicUploadResult {

    private Integer error;// 0上传成功，1代表上传失败

    private String width;// 图片的宽
    private String height;// 图片的高
    private String url;// 图片的上传地址


    public PicUploadResult() {
    }

    public PicUploadResult(Integer error, String width, String height, String url) {
        this.error = error;
        this.width = width;
        this.height = height;
        this.url = url;
    }


    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PicUploadResult{" +
                "error=" + error +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
