package com.itheima.bean;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/*
 *  @创建时间:  2020/12/10 9:06
 *  @描述：    TODO
 */

@Table(name = "tb_item_jd")
public class Item implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(name = "sell_point")
    private String sellPoint;

    @Column
    private Long price;

    @Column
    private Integer num;

    @Column
    private String barcode;

    @Column
    private String image;

    @Column
    private Long cid;

    @Column
    private Integer status;

    private Date created;

    private Date updated;

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    // 添加get方法，支持前端页面的展示
    public String[] getImages() {
        // 判断有图片地址
        /*if (StringUtils.isNotBlank(this.getImage())) {
            String[] images = StringUtils.split(this.getImage(), ",");
            return images;
        }*/

        if (!this.getImage().isEmpty()) {
            String[] images = this.getImage().split(",");
            return images;
        }
        // 如果没有图片，直接返回空
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Item [id=" + id + ", title=" + title + ", sellPoint=" + sellPoint + ", price=" + price + ", num=" + num
                + ", barcode=" + barcode + ", image=" + image + ", cid=" + cid + ", status=" + status + "]";
    }

}
