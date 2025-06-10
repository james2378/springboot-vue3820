package com.entity.view;

import com.entity.JiuwuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 旧物类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
@TableName("jiuwuleixing")
public class JiuwuleixingView  extends JiuwuleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public JiuwuleixingView(){
	}
 
 	public JiuwuleixingView(JiuwuleixingEntity jiuwuleixingEntity){
 	try {
			BeanUtils.copyProperties(this, jiuwuleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
