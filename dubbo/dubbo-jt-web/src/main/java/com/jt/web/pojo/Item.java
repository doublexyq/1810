package com.jt.web.pojo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.solr.client.solrj.beans.Field;

import com.jt.common.po.BasePojo;

public class Item extends BasePojo{
	@Field("id")
	private Long id;
	@Field("title")
	private String title;	//商品标题
	@Field("sellPoint")
	private String sellPoint;//商品卖点
	@Field("price")	
	private Long price;		 //商品的价格    1  0.00000000001 + .0999999999999= 0.99999999999999 精度问题   2 计算速度.  int > long > dubbo
	@Field("num")
	private Integer num;	 //商品的数量
	private String barcode;	 //二维码
	@Field("image")
	private String image;	 //图片信息 在数据库中保存多张图片地址 中间使用","号分割
	private Long cid;		 //商品分类id
	private Integer status;	 //商品的状态  1正常，2下架，3删除
	
	//item.images[0]
	public String[] getImages(){
		
		//商品图片上传之后 1.jpg,2.jpg
		return image.split(",");
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
	
	
}
