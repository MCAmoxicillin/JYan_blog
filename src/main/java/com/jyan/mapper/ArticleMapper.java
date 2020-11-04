package com.jyan.mapper;

import com.jyan.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 江延
 * @since 2020-10-30
 */
@Repository
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
    List<Article> selectAByCN(String key);

}
