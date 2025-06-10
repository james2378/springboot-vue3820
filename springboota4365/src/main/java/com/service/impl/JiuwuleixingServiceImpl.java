package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.JiuwuleixingDao;
import com.entity.JiuwuleixingEntity;
import com.service.JiuwuleixingService;
import com.entity.vo.JiuwuleixingVO;
import com.entity.view.JiuwuleixingView;

@Service("jiuwuleixingService")
public class JiuwuleixingServiceImpl extends ServiceImpl<JiuwuleixingDao, JiuwuleixingEntity> implements JiuwuleixingService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuwuleixingEntity> page = this.selectPage(
                new Query<JiuwuleixingEntity>(params).getPage(),
                new EntityWrapper<JiuwuleixingEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuwuleixingEntity> wrapper) {
		  Page<JiuwuleixingView> page =new Query<JiuwuleixingView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiuwuleixingVO> selectListVO(Wrapper<JiuwuleixingEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiuwuleixingVO selectVO(Wrapper<JiuwuleixingEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiuwuleixingView> selectListView(Wrapper<JiuwuleixingEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuwuleixingView selectView(Wrapper<JiuwuleixingEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
