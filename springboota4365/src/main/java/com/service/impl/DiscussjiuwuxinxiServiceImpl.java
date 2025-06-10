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


import com.dao.DiscussjiuwuxinxiDao;
import com.entity.DiscussjiuwuxinxiEntity;
import com.service.DiscussjiuwuxinxiService;
import com.entity.vo.DiscussjiuwuxinxiVO;
import com.entity.view.DiscussjiuwuxinxiView;

@Service("discussjiuwuxinxiService")
public class DiscussjiuwuxinxiServiceImpl extends ServiceImpl<DiscussjiuwuxinxiDao, DiscussjiuwuxinxiEntity> implements DiscussjiuwuxinxiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiuwuxinxiEntity> page = this.selectPage(
                new Query<DiscussjiuwuxinxiEntity>(params).getPage(),
                new EntityWrapper<DiscussjiuwuxinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiuwuxinxiEntity> wrapper) {
		  Page<DiscussjiuwuxinxiView> page =new Query<DiscussjiuwuxinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjiuwuxinxiVO> selectListVO(Wrapper<DiscussjiuwuxinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiuwuxinxiVO selectVO(Wrapper<DiscussjiuwuxinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiuwuxinxiView> selectListView(Wrapper<DiscussjiuwuxinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiuwuxinxiView selectView(Wrapper<DiscussjiuwuxinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
