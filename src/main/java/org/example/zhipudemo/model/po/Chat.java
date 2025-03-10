package org.example.zhipudemo.model.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/9$ 21:40$
 * @Params: $
 * @Return $
 */
@Data
public class Chat {
    private Integer id;
    private String videoMeg;
    private String imageMeg;
    private String question;
    private String answer;
    private Integer roomId;
    private Date createTime;
}
