package org.example.domain;

import lombok.*;

/**
 * 响应结果封装对象
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseResult {
    private Boolean success;
    private Integer state;
    private String message;
    // 响应前端的具体数据
    private Object content;
}
