package com.entity.view;

import com.entity.DiscussjiuwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 旧物信息评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
@TableName("discussjiuwuxinxi")
public class DiscussjiuwuxinxiView  extends DiscussjiuwuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussjiuwuxinxiView(){
	}
 
 	public DiscussjiuwuxinxiView(DiscussjiuwuxinxiEntity discussjiuwuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, discussjiuwuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
