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

import com.entity.JiuwuxinxiEntity;
import com.entity.view.JiuwuxinxiView;

import com.service.JiuwuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 旧物信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-03-03 15:21:53
 */
@RestController
@RequestMapping("/jiuwuxinxi")
public class JiuwuxinxiController {
    @Autowired
    private JiuwuxinxiService jiuwuxinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,JiuwuxinxiEntity jiuwuxinxi, HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			jiuwuxinxi.setMaijiaming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<JiuwuxinxiEntity> ew = new EntityWrapper<JiuwuxinxiEntity>();
		PageUtils page = jiuwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuwuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,JiuwuxinxiEntity jiuwuxinxi, HttpServletRequest request){
        EntityWrapper<JiuwuxinxiEntity> ew = new EntityWrapper<JiuwuxinxiEntity>();
		PageUtils page = jiuwuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, jiuwuxinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( JiuwuxinxiEntity jiuwuxinxi){
       	EntityWrapper<JiuwuxinxiEntity> ew = new EntityWrapper<JiuwuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( jiuwuxinxi, "jiuwuxinxi")); 
        return R.ok().put("data", jiuwuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(JiuwuxinxiEntity jiuwuxinxi){
        EntityWrapper< JiuwuxinxiEntity> ew = new EntityWrapper< JiuwuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( jiuwuxinxi, "jiuwuxinxi")); 
		JiuwuxinxiView jiuwuxinxiView =  jiuwuxinxiService.selectView(ew);
		return R.ok("查询旧物信息成功").put("data", jiuwuxinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        JiuwuxinxiEntity jiuwuxinxi = jiuwuxinxiService.selectById(id);
        return R.ok().put("data", jiuwuxinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        JiuwuxinxiEntity jiuwuxinxi = jiuwuxinxiService.selectById(id);
        return R.ok().put("data", jiuwuxinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R vote(@PathVariable("id") String id,String type){
        JiuwuxinxiEntity jiuwuxinxi = jiuwuxinxiService.selectById(id);
        if(type.equals("1")) {
        	jiuwuxinxi.setThumbsupnum(jiuwuxinxi.getThumbsupnum()+1);
        } else {
        	jiuwuxinxi.setCrazilynum(jiuwuxinxi.getCrazilynum()+1);
        }
        jiuwuxinxiService.updateById(jiuwuxinxi);
        return R.ok("投票成功");
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody JiuwuxinxiEntity jiuwuxinxi, HttpServletRequest request){
    	jiuwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuwuxinxi);
        jiuwuxinxiService.insert(jiuwuxinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody JiuwuxinxiEntity jiuwuxinxi, HttpServletRequest request){
    	jiuwuxinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(jiuwuxinxi);
        jiuwuxinxiService.insert(jiuwuxinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody JiuwuxinxiEntity jiuwuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(jiuwuxinxi);
        jiuwuxinxiService.updateById(jiuwuxinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        jiuwuxinxiService.deleteBatchIds(Arrays.asList(ids));
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
		
		Wrapper<JiuwuxinxiEntity> wrapper = new EntityWrapper<JiuwuxinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("maijia")) {
			wrapper.eq("maijiaming", (String)request.getSession().getAttribute("username"));
		}

		int count = jiuwuxinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
