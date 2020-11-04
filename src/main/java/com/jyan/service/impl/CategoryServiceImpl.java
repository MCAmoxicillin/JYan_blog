package com.jyan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jyan.entity.Article;
import com.jyan.entity.Category;
import com.jyan.mapper.CategoryMapper;
import com.jyan.service.ICategoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 江延
 * @since 2020-10-30
 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
    @Autowired
    private CategoryMapper categoryMapper;
    /**
     * 查找所有的标签类型
     */
    @Override
    public List<Category> list() {
        List<Category> categories=categoryMapper.selectList(null);
        return categories;
    }
    /**
     * 根据id查name
     */
    public Category selectById(int id){
        Category category=categoryMapper.selectById(id);
        return category;
    }
    /**
     * 根据namen查
     */
    public Category selectByName(String name){
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("name",name);
        Category category=categoryMapper.selectOne(wrapper);
        return category;
    }

    /**
     * 根据a表中的cgnid查
     * @param article
     * @return
     */
    public Category selectCgnFromeA(Article article){
        Category category=categoryMapper.selectById(article.getCategoryId());
        return category;
    }
}
