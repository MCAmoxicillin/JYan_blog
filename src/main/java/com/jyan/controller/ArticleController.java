package com.jyan.controller;


import com.jyan.entity.Article;
import com.jyan.service.impl.ArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.tautua.markdownpapers.Markdown;
import org.tautua.markdownpapers.parser.ParseException;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 江延
 * @since 2020-10-30
 */
@Controller
@RequestMapping("/article")
public class ArticleController {
    @Autowired
    ArticleServiceImpl articleService;

    /**
     * article首页
     * @param model
     * @return
     */
    @RequestMapping("")
    public String get(Model model){
        List<Article> articles=articleService.list();
        model.addAttribute("articles",articles);
        return "front/index";
    }

    /**
     * 阅读文章
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/detail/{id}")
    public String detail(@PathVariable("id") int id ,Model model){
        System.out.println(id);
        Article article=articleService.getById(id);
        Markdown markdown=new Markdown();
        try{
            StringWriter out=new StringWriter();
            markdown.transform(new StringReader(article.getContent()),out);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        model.addAttribute("article",article);
        return "front/detail";
    }

    /**
     * 根据文章标题来搜索文章
     * @param Key
     * @param model
     * @return
     */
    @RequestMapping("/search")
    public String search(String Key,Model model){
        Article article=articleService.selectByTitle(Key);
        model.addAttribute("article",article);
        return "front/detail";
    }

    /**
     * 根据分类来查询文章
     * @param name
     * @param model
     * @return
     */
    @RequestMapping("/column/{name}/{category}")
    public String column(@PathVariable("name") String name,Model model){
        model.addAttribute("articles",articleService.seleABCname(name));
        model.addAttribute("displayName",name);
        return "front/columnPage";
    }
}

