package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussjiuwuxinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussjiuwuxinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussjiuwuxinxiView;


/**
 * 旧物信息评论表
 *
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public interface DiscussjiuwuxinxiService extends IService<DiscussjiuwuxinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussjiuwuxinxiVO> selectListVO(Wrapper<DiscussjiuwuxinxiEntity> wrapper);
   	
   	DiscussjiuwuxinxiVO selectVO(@Param("ew") Wrapper<DiscussjiuwuxinxiEntity> wrapper);
   	
   	List<DiscussjiuwuxinxiView> selectListView(Wrapper<DiscussjiuwuxinxiEntity> wrapper);
   	
   	DiscussjiuwuxinxiView selectView(@Param("ew") Wrapper<DiscussjiuwuxinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussjiuwuxinxiEntity> wrapper);
   	
}

