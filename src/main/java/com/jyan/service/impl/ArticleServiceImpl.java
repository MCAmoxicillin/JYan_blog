package com.jyan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jyan.entity.Article;
import com.jyan.entity.Category;
import com.jyan.mapper.ArticleMapper;
import com.jyan.mapper.CategoryMapper;
import com.jyan.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 江延
 * @since 2020-10-30
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private CategoryMapper categoryMapper;
    //根据id查询article
    public Article getById(Long id){
        Article article=articleMapper.selectById(id);
        return article;
    }
    /**
     * 查询所有文章
     * @return
     */
    public List<Article> list(){
        List<Article> articles=articleMapper.selectList(null);
        return articles;
    }
    /**
     * 根据标签分类查询文章
     * @return
     */
    public List<Article> selectByCategory(int category){
        QueryWrapper wrapper=new QueryWrapper<>();
        wrapper.eq("categoryId",category);
        List<Article> articles=articleMapper.selectMaps(wrapper);
        return articles;
    }

    /**
     * 根据标题查找文章
     * @param title
     * @return
     */
    public Article selectByTitle(String title){
        QueryWrapper wrapper=new QueryWrapper<>();
        wrapper.eq("title",title);
        Article articles=articleMapper.selectOne(wrapper);
        return articles;
    }

    /**
     * 删除博客文章
     * @param id
     */
    public void deletedById(int id){
        articleMapper.deleteById(id);
    }

    /**
     * 保存博客文章
     * @param article
     */
    public void saveArticle(Article article){
        articleMapper.insert(article);
    }

    /**
     * 更具分类标签name查找文章
     * @param key
     * @return
     */
    public List<Article> seleABCname(String key){
        List<Article> articles = articleMapper.selectAByCN(key);
        return articles;
    }


}
