package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.JiuwuleixingEntity;
import com.entity.view.JiuwuleixingView;

import com.service.JiuwuleixingService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 旧物类型
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
@RestController
@RequestMapping("/jiuwuleixing")
public class JiuwuleixingController {
    @Autowired
    private JiuwuleixingService jiuwuleixingService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiuwuleixingEntity jiuwuleixing, HttpServletRequest request){
        EntityWrapper<JiuwuleixingEntity> ew = new EntityWrapper<JiuwuleixingEntity>();
		PageUtils page = jiuwuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuwuleixing), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiuwuleixingEntity jiuwuleixing, HttpServletRequest request){
        EntityWrapper<JiuwuleixingEntity> ew = new EntityWrapper<JiuwuleixingEntity>();
		PageUtils page = jiuwuleixingService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuwuleixing), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiuwuleixingEntity jiuwuleixing){
       	EntityWrapper<JiuwuleixingEntity> ew = new EntityWrapper<JiuwuleixingEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiuwuleixing, "jiuwuleixing")); 
        return R.ok().put("data", jiuwuleixingService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiuwuleixingEntity jiuwuleixing){
        EntityWrapper< JiuwuleixingEntity> ew = new EntityWrapper< JiuwuleixingEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiuwuleixing, "jiuwuleixing")); 
		JiuwuleixingView jiuwuleixingView =  jiuwuleixingService.selectView(ew);
		return R.ok("查询旧物类型成功").put("data", jiuwuleixingView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiuwuleixingEntity jiuwuleixing = jiuwuleixingService.selectById(id);
        return R.ok().put("data", jiuwuleixing);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiuwuleixingEntity jiuwuleixing = jiuwuleixingService.selectById(id);
        return R.ok().put("data", jiuwuleixing);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiuwuleixingEntity jiuwuleixing, HttpServletRequest request){
    	jiuwuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuwuleixing);
        jiuwuleixingService.insert(jiuwuleixing);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiuwuleixingEntity jiuwuleixing, HttpServletRequest request){
    	jiuwuleixing.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuwuleixing);
        jiuwuleixingService.insert(jiuwuleixing);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiuwuleixingEntity jiuwuleixing, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiuwuleixing);
        jiuwuleixingService.updateById(jiuwuleixing);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiuwuleixingService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<JiuwuleixingEntity> wrapper = new EntityWrapper<JiuwuleixingEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}


		int count = jiuwuleixingService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
