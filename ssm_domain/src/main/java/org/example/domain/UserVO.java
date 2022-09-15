package org.example.domain;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;


/**
 * @author
 */
@Data
public class UserVO {
    private Integer id;
    private String status;
    private Date updateTime;
    private Integer currentPage;
    private Integer pageSize;
    /**
     * 多条件查询
     **/
    private String username;
    /**
     * 是否删除
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startCreateTime;
    /**
     * 注册结束时间
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endCreateTime;

    private List<Integer> roleIdList;

}
