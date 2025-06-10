package com.entity.model;

import com.entity.ZhihuanjiaoyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 置换交易
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public class ZhihuanjiaoyiModel  implements Serializable {
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
	 * 旧物图片
	 */
	
	private String jiuwutupian;
		
	/**
	 * 置换物
	 */
	
	private String zhihuanwu;
		
	/**
	 * 物品图片
	 */
	
	private String wupintupian;
		
	/**
	 * 物品详情
	 */
	
	private String wupinxiangqing;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
				
	
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
	 * 设置：置换物
	 */
	 
	public void setZhihuanwu(String zhihuanwu) {
		this.zhihuanwu = zhihuanwu;
	}
	
	/**
	 * 获取：置换物
	 */
	public String getZhihuanwu() {
		return zhihuanwu;
	}
				
	
	/**
	 * 设置：物品图片
	 */
	 
	public void setWupintupian(String wupintupian) {
		this.wupintupian = wupintupian;
	}
	
	/**
	 * 获取：物品图片
	 */
	public String getWupintupian() {
		return wupintupian;
	}
				
	
	/**
	 * 设置：物品详情
	 */
	 
	public void setWupinxiangqing(String wupinxiangqing) {
		this.wupinxiangqing = wupinxiangqing;
	}
	
	/**
	 * 获取：物品详情
	 */
	public String getWupinxiangqing() {
		return wupinxiangqing;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
			
}
