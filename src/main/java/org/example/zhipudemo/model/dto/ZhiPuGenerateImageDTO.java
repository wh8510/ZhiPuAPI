package org.example.zhipudemo.model.dto;

import lombok.Data;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/5$ 21:12$
 * @Params: $
 * @Return $
 */
@Data
public class ZhiPuGenerateImageDTO {
    /**
     * 编号
     */
    public String id;
    /**
     * 文字描述信息
     */
    public String message;
    /**
     * 图片大小
     */
    public String size;
}
