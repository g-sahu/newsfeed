package com.gsahu.newsfeed.controller;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gsahu.newsfeed.model.Article;
import com.gsahu.newsfeed.service.NewsFeedService;

@Controller
public class HomeController {
	@Autowired
	private NewsFeedService newsFeedService;
	private static final Logger logger = LogManager.getLogger(HomeController.class);
	
	@RequestMapping(value="/getNewsFeed", method=RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
	public ModelAndView showNewsFeed() {		
		List<Article> articles = newsFeedService.fetchArticles();
		ModelAndView modelAndView = (articles != null) ? new ModelAndView("newsfeed", "articles", articles) : new ModelAndView("error"); 
		return modelAndView;
	}

	@RequestMapping(value="/home", method=RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
	public String showHome() {
		logger.info("Showing home page");
		return "home";
	}
	
	@RequestMapping(value="/apply", method=RequestMethod.GET, produces=MediaType.TEXT_HTML_VALUE)
	public String showApplyPage() {
		logger.info("Showing apply page");
		return "apply";
	}
}