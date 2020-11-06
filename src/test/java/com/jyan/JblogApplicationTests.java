package com.jyan;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jyan.entity.Article;
import com.jyan.entity.Category;
import com.jyan.entity.User;
import com.jyan.mapper.ArticleMapper;
import com.jyan.mapper.CategoryMapper;
import com.jyan.mapper.UserMapper;
import net.minidev.json.JSONUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class JblogApplicationTests {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    @Test
    public void sss(){
        List<Article> articles = articleMapper.selectAByCN("生活");
        articles.forEach(System.out::println);
    }
    //根据id查询article
    @Test
    public void getuser(){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("username","jiangyan");
        User user=userMapper.selectOne(wrapper);
        if("123456".equals(user.getPassword())){
            System.out.println("哈哈哈");
        }else {
            System.out.println("额");
        }
    }
    @Test
    public void getById(){
        Article article=articleMapper.selectById(1);
        System.out.println(article);
    }
    /**
     * 查询所有列表
     * @return
     */
    @Test
    public void list(){
        List<Article> articles=articleMapper.selectList(null);
        articles.forEach(System.out::println);
    }

    @Test
    void contextLoads() {
        List<Article> articles=articleMapper.selectList(null);
        articles.forEach(System.out::println);


    }
    @Test
    public void se(){
        Article article=articleMapper.selectById(1);
        Category category=categoryMapper.selectById(article.getCategoryId());
        System.out.println(category);
        System.out.println(article);
    }
    @Test
    public void inser(){
        Article article = new Article(2L,"江延","啊这",3,"一个人",null);
        articleMapper.insert(article);
    }

}
