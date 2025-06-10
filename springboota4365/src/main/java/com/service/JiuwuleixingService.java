package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiuwuleixingEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.JiuwuleixingVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.JiuwuleixingView;


/**
 * 旧物类型
 *
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public interface JiuwuleixingService extends IService<JiuwuleixingEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiuwuleixingVO> selectListVO(Wrapper<JiuwuleixingEntity> wrapper);
   	
   	JiuwuleixingVO selectVO(@Param("ew") Wrapper<JiuwuleixingEntity> wrapper);
   	
   	List<JiuwuleixingView> selectListView(Wrapper<JiuwuleixingEntity> wrapper);
   	
   	JiuwuleixingView selectView(@Param("ew") Wrapper<JiuwuleixingEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiuwuleixingEntity> wrapper);
   	
}

