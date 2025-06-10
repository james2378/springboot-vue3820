package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiuwuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiuwuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuwuxinxiView;


/**
 * 旧物信息
 *
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public interface JiuwuxinxiService extends IService<JiuwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiuwuxinxiVO> selectListVO(Wrapper<JiuwuxinxiEntity> wrapper);
   	
   	JiuwuxinxiVO selectVO(@Param("ew") Wrapper<JiuwuxinxiEntity> wrapper);
   	
   	List<JiuwuxinxiView> selectListView(Wrapper<JiuwuxinxiEntity> wrapper);
   	
   	JiuwuxinxiView selectView(@Param("ew") Wrapper<JiuwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiuwuxinxiEntity> wrapper);
   	
}

