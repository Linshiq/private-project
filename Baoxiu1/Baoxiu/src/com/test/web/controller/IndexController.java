package com.test.web.controller;
/* controller控制器 , @RequestMapping检索变化值*/
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.dao.BaoxiuMapper;
import com.test.web.entity.Baoxiu;
import com.test.web.entity.BaoxiuExample;

@Controller
@RequestMapping(value = "/")
public class IndexController {
	@Autowired
	BaoxiuMapper baoxiuMapper;
	
	@RequestMapping(value = "baoxiu")
	public String index(Model model) {
		return "/repairEntre";
	}
	
	@RequestMapping(value = "login")
	public String login(Model model) {
		List<Baoxiu> list = baoxiuMapper.selectByExample(new BaoxiuExample());
		model.addAttribute("list", list);
		return "/login";
	}
	
	@RequestMapping(value = "tongzhi")
	public String tongzhi(Model model) {
		return "/tongzhi";
	}
	
	@RequestMapping(value = "insert")
	public String insert(Model model, Baoxiu baoxiu) {
		UUID uuid = UUID.randomUUID();
		baoxiu.setId(uuid.toString());
		baoxiu.setUrl("/url?id="+uuid.toString());
		baoxiu.setState("0");
		baoxiu.setDelFlag("0");
		baoxiu.setTime(new Date());
		baoxiuMapper.insert(baoxiu);
		return "redirect:/";
	}
	
	@RequestMapping(value = "list")
	public String list(Model model) {
		List<Baoxiu> list = baoxiuMapper.selectByExample(new BaoxiuExample());
		model.addAttribute("list", list);
		return "/repairResult";
	}
	
	@RequestMapping(value = "url")
	public String url(Model model, Baoxiu baoxiu) {
		Baoxiu baoxiu2 = baoxiuMapper.selectByPrimaryKey(baoxiu.getId());
		model.addAttribute("baoxiu", baoxiu2);
		return "/repairCustoms";
	}
	
	@RequestMapping(value = "index")
	public String index(Model model, Baoxiu baoxiu) {
		Baoxiu baoxiu2 = baoxiuMapper.selectByPrimaryKey(baoxiu.getId());
		model.addAttribute("baoxiu", baoxiu2);
		return "/index";
	}
	
	@RequestMapping(value = "cancel")
	//@ResponseBody
	public String del(Model model, Baoxiu baoxiu) throws JsonProcessingException {
		baoxiu.setDelFlag("1");
		baoxiuMapper.updateByPrimaryKeySelective(baoxiu);
		return "redirect:/list";
	}
	
	@RequestMapping(value = "updateAccept")
	public String updateAccept(Model model, Baoxiu baoxiu) {
		baoxiu.setState("1");
		baoxiuMapper.updateByPrimaryKeySelective(baoxiu);
		return "/accept.jsp?id="+baoxiu.getId();
	}
	
	@RequestMapping(value = "updateFinish")
	public String updateFinish(Model model, Baoxiu baoxiu) {
		baoxiu.setState("2");
		BaoxiuExample be = new BaoxiuExample();
		baoxiuMapper.updateByPrimaryKeySelective(baoxiu);
		return "/finish";
	}
}
