package com.entity.view;

import com.entity.ZhihuanjiaoyiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 置换交易
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
@TableName("zhihuanjiaoyi")
public class ZhihuanjiaoyiView  extends ZhihuanjiaoyiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ZhihuanjiaoyiView(){
	}
 
 	public ZhihuanjiaoyiView(ZhihuanjiaoyiEntity zhihuanjiaoyiEntity){
 	try {
			BeanUtils.copyProperties(this, zhihuanjiaoyiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
