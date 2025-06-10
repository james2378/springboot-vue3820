package com.entity.view;

import com.entity.JiuwuxinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 旧物信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
@TableName("jiuwuxinxi")
public class JiuwuxinxiView  extends JiuwuxinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiuwuxinxiView(){
	}
 
 	public JiuwuxinxiView(JiuwuxinxiEntity jiuwuxinxiEntity){
 	try {
			BeanUtils.copyProperties(this, jiuwuxinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
