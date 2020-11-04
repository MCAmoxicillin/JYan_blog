package com.jyan.controller;

import com.jyan.config.WebSecurityConfig;
import com.jyan.entity.Article;
import com.jyan.entity.Category;
import com.jyan.entity.User;
import com.jyan.service.impl.ArticleServiceImpl;
import com.jyan.service.impl.CategoryServiceImpl;
import com.jyan.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
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
@RequestMapping("/admin")
public class UserController {
    @Autowired
    UserServiceImpl userService;
    @Autowired
    ArticleServiceImpl articleService;
    @Autowired
    CategoryServiceImpl categoryService;
    private SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyy-MM-dd HH:mm");

    /**
     * 登录验证
     * @param response
     * @param user
     * @param model
     * @return
     */
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String Login(HttpServletResponse response, User user, Model model){
        if(userService.login(user.getUsername(), user.getPassword())){
            Cookie cookie=new Cookie(WebSecurityConfig.SESSION_KEY, user.getNetName());
            cookie.setMaxAge(10);
            response.addCookie(cookie);
            model.addAttribute(cookie);
            System.out.println("添加"+cookie.getName());
            return "redirect:/admin";
        }else {
            model.addAttribute("error","用户名或密码错误");
            System.out.println("登录失败");
            return "admin/login";
        }
    }

    /**
     * 后台首页
     * @param model
     * @return
     */
    @RequestMapping("")
    public String admin(Model model){
        List<Article> articles=articleService.list();
        model.addAttribute("articles",articles);
        return "admin/index";
    }

    /**
     * 登录
     * @return
     */
    @RequestMapping("/login")
    public String login(){
        return "/admin/login";

    }

    /**
     * 删除博客
     * @param id
     * @return
     */
    @RequestMapping("/deleted/{id}")
    public String deleted(@PathVariable("id") int id){
        articleService.deletedById(id);
        return "redirect:/admin";
    }

    /**
     * 编写博客
     * @param model
     * @return
     */
    @RequestMapping("/write")
    public String write(Model model){
        List<Category> categories=categoryService.list();
        model.addAttribute("categories",categories);
        model.addAttribute("article",new Article());
        return "admin/write";
    }

    /**
     * 保存博客
     * @param article
     * @return
     */
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(Article article){
        String name=categoryService.selectCgnFromeA(article).getName();
        Category category=categoryService.selectByName(name);
        article.setCategoryId(category.getId());
        if(article.getContent().length()>40){
            article.setSummary(article.getContent().substring(0,40));
        }else{
            article.setSummary(article.getContent());
        }
        articleService.saveArticle(article);
        return "redirect:/admin";
    }

    /**
     * 修改博客内容
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/update/{id}")
    public String update(@PathVariable("id")int id,Model model){
        Article article=articleService.getById(id);
        model.addAttribute("target",article);
        List<Category> categories=categoryService.list();
        model.addAttribute("categories",categories);
        model.addAttribute("article",new Article());
        return "admin/update";
    }


}

