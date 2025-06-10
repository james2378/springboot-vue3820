package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 旧物信息
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
@TableName("jiuwuxinxi")
public class JiuwuxinxiEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public JiuwuxinxiEntity() {
		
	}
	
	public JiuwuxinxiEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
	@TableId
	private Long id;
	/**
	 * 卖家名
	 */
					
	private String maijiaming;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 旧物名称
	 */
					
	private String jiuwumingcheng;
	
	/**
	 * 旧物类型
	 */
					
	private String jiuwuleixing;
	
	/**
	 * 旧物图片
	 */
					
	private String jiuwutupian;
	
	/**
	 * 置换需求
	 */
					
	private String zhihuanxuqiu;
	
	/**
	 * 旧物详情
	 */
					
	private String jiuwuxiangqing;
	
	/**
	 * 赞
	 */
					
	private Integer thumbsupnum;
	
	/**
	 * 踩
	 */
					
	private Integer crazilynum;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：卖家名
	 */
	public void setMaijiaming(String maijiaming) {
		this.maijiaming = maijiaming;
	}
	/**
	 * 获取：卖家名
	 */
	public String getMaijiaming() {
		return maijiaming;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：旧物名称
	 */
	public void setJiuwumingcheng(String jiuwumingcheng) {
		this.jiuwumingcheng = jiuwumingcheng;
	}
	/**
	 * 获取：旧物名称
	 */
	public String getJiuwumingcheng() {
		return jiuwumingcheng;
	}
	/**
	 * 设置：旧物类型
	 */
	public void setJiuwuleixing(String jiuwuleixing) {
		this.jiuwuleixing = jiuwuleixing;
	}
	/**
	 * 获取：旧物类型
	 */
	public String getJiuwuleixing() {
		return jiuwuleixing;
	}
	/**
	 * 设置：旧物图片
	 */
	public void setJiuwutupian(String jiuwutupian) {
		this.jiuwutupian = jiuwutupian;
	}
	/**
	 * 获取：旧物图片
	 */
	public String getJiuwutupian() {
		return jiuwutupian;
	}
	/**
	 * 设置：置换需求
	 */
	public void setZhihuanxuqiu(String zhihuanxuqiu) {
		this.zhihuanxuqiu = zhihuanxuqiu;
	}
	/**
	 * 获取：置换需求
	 */
	public String getZhihuanxuqiu() {
		return zhihuanxuqiu;
	}
	/**
	 * 设置：旧物详情
	 */
	public void setJiuwuxiangqing(String jiuwuxiangqing) {
		this.jiuwuxiangqing = jiuwuxiangqing;
	}
	/**
	 * 获取：旧物详情
	 */
	public String getJiuwuxiangqing() {
		return jiuwuxiangqing;
	}
	/**
	 * 设置：赞
	 */
	public void setThumbsupnum(Integer thumbsupnum) {
		this.thumbsupnum = thumbsupnum;
	}
	/**
	 * 获取：赞
	 */
	public Integer getThumbsupnum() {
		return thumbsupnum;
	}
	/**
	 * 设置：踩
	 */
	public void setCrazilynum(Integer crazilynum) {
		this.crazilynum = crazilynum;
	}
	/**
	 * 获取：踩
	 */
	public Integer getCrazilynum() {
		return crazilynum;
	}

}
