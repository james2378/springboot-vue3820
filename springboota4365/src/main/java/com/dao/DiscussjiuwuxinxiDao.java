package com.dao;

import com.entity.DiscussjiuwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussjiuwuxinxiVO;
import com.entity.view.DiscussjiuwuxinxiView;


/**
 * 旧物信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public interface DiscussjiuwuxinxiDao extends BaseMapper<DiscussjiuwuxinxiEntity> {
	
	List<DiscussjiuwuxinxiVO> selectListVO(@Param("ew") Wrapper<DiscussjiuwuxinxiEntity> wrapper);
	
	DiscussjiuwuxinxiVO selectVO(@Param("ew") Wrapper<DiscussjiuwuxinxiEntity> wrapper);
	
	List<DiscussjiuwuxinxiView> selectListView(@Param("ew") Wrapper<DiscussjiuwuxinxiEntity> wrapper);

	List<DiscussjiuwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussjiuwuxinxiEntity> wrapper);
	
	DiscussjiuwuxinxiView selectView(@Param("ew") Wrapper<DiscussjiuwuxinxiEntity> wrapper);
	
}
