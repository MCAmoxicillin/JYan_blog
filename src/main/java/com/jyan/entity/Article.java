package com.jyan.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * <p>
 * 
 * </p>
 *
 * @author 江延
 * @since 2020-10-30
 */
@Data
@NoArgsConstructor

@ApiModel(value="Article对象", description= "article")
public class Article implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "文章标题")
    private String title;

    @ApiModelProperty(value = "文章内容")
    private String content;

    @ApiModelProperty(value = "分类标签")
    private Integer categoryId;


    @ApiModelProperty(value = "内容概括")
    private String summary;

    @ApiModelProperty(value = "上传时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createdTime;

    public Article(Long id, String title, String content, Integer categoryId, String summary,Date createdTime) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.categoryId = categoryId;
        this.summary = summary;
        this.createdTime=createdTime;
    }
}
