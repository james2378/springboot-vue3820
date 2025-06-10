package com.dao;

import com.entity.JiuwuxinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiuwuxinxiVO;
import com.entity.view.JiuwuxinxiView;


/**
 * 旧物信息
 * 
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public interface JiuwuxinxiDao extends BaseMapper<JiuwuxinxiEntity> {
	
	List<JiuwuxinxiVO> selectListVO(@Param("ew") Wrapper<JiuwuxinxiEntity> wrapper);
	
	JiuwuxinxiVO selectVO(@Param("ew") Wrapper<JiuwuxinxiEntity> wrapper);
	
	List<JiuwuxinxiView> selectListView(@Param("ew") Wrapper<JiuwuxinxiEntity> wrapper);

	List<JiuwuxinxiView> selectListView(Pagination page,@Param("ew") Wrapper<JiuwuxinxiEntity> wrapper);
	
	JiuwuxinxiView selectView(@Param("ew") Wrapper<JiuwuxinxiEntity> wrapper);
	
}
