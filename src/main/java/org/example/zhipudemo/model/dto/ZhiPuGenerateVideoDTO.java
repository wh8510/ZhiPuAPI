package org.example.zhipudemo.model.dto;

import lombok.Data;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/7$ 19:59$
 * @Params: $
 * @Return $
 */
@Data
public class ZhiPuGenerateVideoDTO {
    /**
     * 编号
     */
    public String id;
    /**
     * 文本描述信息
     */
    public String prompt;
    /**
     * 输出模式
     */
    public String quality;
    /**
     * AI音效
     */
    public Boolean withAudio;
    /**
     * 图片信息
     */
    public String image;
    /**
     * 视频大小
     */
    public String size;
    /**
     * 视频帧数
     */
    public Integer fps;

}
