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


import com.dao.JiuwuxinxiDao;
import com.entity.JiuwuxinxiEntity;
import com.service.JiuwuxinxiService;
import com.entity.vo.JiuwuxinxiVO;
import com.entity.view.JiuwuxinxiView;

@Service("jiuwuxinxiService")
public class JiuwuxinxiServiceImpl extends ServiceImpl<JiuwuxinxiDao, JiuwuxinxiEntity> implements JiuwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiuwuxinxiEntity> page = this.selectPage(
                new Query<JiuwuxinxiEntity>(params).getPage(),
                new EntityWrapper<JiuwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiuwuxinxiEntity> wrapper) {
		  Page<JiuwuxinxiView> page =new Query<JiuwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<JiuwuxinxiVO> selectListVO(Wrapper<JiuwuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public JiuwuxinxiVO selectVO(Wrapper<JiuwuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<JiuwuxinxiView> selectListView(Wrapper<JiuwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiuwuxinxiView selectView(Wrapper<JiuwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
