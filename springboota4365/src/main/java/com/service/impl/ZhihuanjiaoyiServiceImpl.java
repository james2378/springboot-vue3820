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


import com.dao.ZhihuanjiaoyiDao;
import com.entity.ZhihuanjiaoyiEntity;
import com.service.ZhihuanjiaoyiService;
import com.entity.vo.ZhihuanjiaoyiVO;
import com.entity.view.ZhihuanjiaoyiView;

@Service("zhihuanjiaoyiService")
public class ZhihuanjiaoyiServiceImpl extends ServiceImpl<ZhihuanjiaoyiDao, ZhihuanjiaoyiEntity> implements ZhihuanjiaoyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhihuanjiaoyiEntity> page = this.selectPage(
                new Query<ZhihuanjiaoyiEntity>(params).getPage(),
                new EntityWrapper<ZhihuanjiaoyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhihuanjiaoyiEntity> wrapper) {
		  Page<ZhihuanjiaoyiView> page =new Query<ZhihuanjiaoyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<ZhihuanjiaoyiVO> selectListVO(Wrapper<ZhihuanjiaoyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhihuanjiaoyiVO selectVO(Wrapper<ZhihuanjiaoyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhihuanjiaoyiView> selectListView(Wrapper<ZhihuanjiaoyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhihuanjiaoyiView selectView(Wrapper<ZhihuanjiaoyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
