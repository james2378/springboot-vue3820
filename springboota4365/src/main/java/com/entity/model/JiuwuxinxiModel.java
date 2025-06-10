package com.entity.model;

import com.entity.JiuwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 旧物信息
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public class JiuwuxinxiModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
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
