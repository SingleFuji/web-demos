package com.jo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jo.exception.JoException;
import com.jo.po.App;
import com.jo.po.ResultInfo;
import com.jo.service.AppService;

/**
 * redis例子 排行榜
 * 
 * @author mango_jo
 *
 */
@Controller
@RequestMapping("/app")
public class AppController {

	private static final Logger logger = LoggerFactory.getLogger(AppController.class);
	
	@Resource
	private AppService appService;
	
	@RequestMapping(value = "/init", method = RequestMethod.GET)
	@ResponseBody
	public ResultInfo initAppInfo(ModelMap model) {
		ResultInfo result = new ResultInfo();
		try {
			List<App> appList = appService.initRankList();
			result.setData(appList);
		} catch (JoException e) {
			e.printStackTrace();
		}
//		return "appRankList";
		return result;

	}
	
	@RequestMapping(value = "/appRankList", method = RequestMethod.GET)
	public String redictRankListPage(){
		return "appRankList";
	}
}
