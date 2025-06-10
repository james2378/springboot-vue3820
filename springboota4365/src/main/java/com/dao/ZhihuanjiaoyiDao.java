package com.dao;

import com.entity.ZhihuanjiaoyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ZhihuanjiaoyiVO;
import com.entity.view.ZhihuanjiaoyiView;


/**
 * 置换交易
 * 
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public interface ZhihuanjiaoyiDao extends BaseMapper<ZhihuanjiaoyiEntity> {
	
	List<ZhihuanjiaoyiVO> selectListVO(@Param("ew") Wrapper<ZhihuanjiaoyiEntity> wrapper);
	
	ZhihuanjiaoyiVO selectVO(@Param("ew") Wrapper<ZhihuanjiaoyiEntity> wrapper);
	
	List<ZhihuanjiaoyiView> selectListView(@Param("ew") Wrapper<ZhihuanjiaoyiEntity> wrapper);

	List<ZhihuanjiaoyiView> selectListView(Pagination page,@Param("ew") Wrapper<ZhihuanjiaoyiEntity> wrapper);
	
	ZhihuanjiaoyiView selectView(@Param("ew") Wrapper<ZhihuanjiaoyiEntity> wrapper);
	
}
