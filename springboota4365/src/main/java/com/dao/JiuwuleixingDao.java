package com.dao;

import com.entity.JiuwuleixingEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.JiuwuleixingVO;
import com.entity.view.JiuwuleixingView;


/**
 * 旧物类型
 * 
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public interface JiuwuleixingDao extends BaseMapper<JiuwuleixingEntity> {
	
	List<JiuwuleixingVO> selectListVO(@Param("ew") Wrapper<JiuwuleixingEntity> wrapper);
	
	JiuwuleixingVO selectVO(@Param("ew") Wrapper<JiuwuleixingEntity> wrapper);
	
	List<JiuwuleixingView> selectListView(@Param("ew") Wrapper<JiuwuleixingEntity> wrapper);

	List<JiuwuleixingView> selectListView(Pagination page,@Param("ew") Wrapper<JiuwuleixingEntity> wrapper);
	
	JiuwuleixingView selectView(@Param("ew") Wrapper<JiuwuleixingEntity> wrapper);
	
}
