package org.example.zhipudemo.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.example.zhipudemo.model.dto.ZhiPuGenerateImageDTO;
import org.example.zhipudemo.model.dto.ZhiPuGenerateMessageDTO;
import org.example.zhipudemo.model.dto.ZhiPuGenerateVideoDTO;
import org.example.zhipudemo.model.vo.ZhiPuGenerateImageVO;
import org.example.zhipudemo.model.vo.ZhiPuGenerateMessageVO;
import org.example.zhipudemo.model.vo.ZhiPuGenerateVideoVO;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/5$ 21:01$
 * @Params: $
 * @Return $
 */
public interface ZhiPuService {
    /**
     * 用户-文生图
     *
     * @param zhiPuGenerateImageDTO 传递的信息
     * @return url地址
     */
    ZhiPuGenerateImageVO getGenerateImageUrl(ZhiPuGenerateImageDTO zhiPuGenerateImageDTO) throws IOException;
    /**
     * 用户-图生文
     *
     * @param zhiPuGenerateMessageDTO 传递的信息
     * @return 结果
     */
    ZhiPuGenerateMessageVO getGenerateMessage(ZhiPuGenerateMessageDTO zhiPuGenerateMessageDTO) throws IOException;
    /**
     * 用户-文生视频
     *
     * @param zhiPuGenerateVideoDTO 传递的信息
     * @return 结果
     */
    ZhiPuGenerateVideoVO generateVideo(ZhiPuGenerateVideoDTO zhiPuGenerateVideoDTO);
    /**
     * 用户-多轮图片理解对话
     *
     * @param zhiPuGenerateMessageDTO 传递的信息
     * @return 结果
     */
    ZhiPuGenerateMessageVO getGenerateMessageRepeatedly(ZhiPuGenerateMessageDTO zhiPuGenerateMessageDTO) throws IOException;
//    /**
//     * 用户-图生文(文件调用)
//     *
//     * @param imageFile 传递的文件
//     * @return 结果
//     */
//    ZhiPuGenerateMessageVO getGenerateMessageByFile(MultipartFile imageFile,String message) throws IOException;
}
