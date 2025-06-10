package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ZhihuanjiaoyiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ZhihuanjiaoyiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ZhihuanjiaoyiView;


/**
 * 置换交易
 *
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
public interface ZhihuanjiaoyiService extends IService<ZhihuanjiaoyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ZhihuanjiaoyiVO> selectListVO(Wrapper<ZhihuanjiaoyiEntity> wrapper);
   	
   	ZhihuanjiaoyiVO selectVO(@Param("ew") Wrapper<ZhihuanjiaoyiEntity> wrapper);
   	
   	List<ZhihuanjiaoyiView> selectListView(Wrapper<ZhihuanjiaoyiEntity> wrapper);
   	
   	ZhihuanjiaoyiView selectView(@Param("ew") Wrapper<ZhihuanjiaoyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ZhihuanjiaoyiEntity> wrapper);
   	
}

