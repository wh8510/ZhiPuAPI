package org.example.zhipudemo.service.Impl;
import org.example.zhipudemo.ZhiPu.ZhiPuImageAndMessageApi;
import org.example.zhipudemo.ZhiPu.ZhiPuVideoApi;
import org.example.zhipudemo.mapper.ZhiPuMapper;
import org.example.zhipudemo.model.dto.ZhiPuGenerateImageDTO;
import org.example.zhipudemo.model.dto.ZhiPuGenerateMessageDTO;
import org.example.zhipudemo.model.dto.ZhiPuGenerateVideoDTO;
import org.example.zhipudemo.model.po.Chat;
import org.example.zhipudemo.model.po.History;
import org.example.zhipudemo.model.vo.ZhiPuGenerateImageVO;
import org.example.zhipudemo.model.vo.ZhiPuGenerateMessageVO;
import org.example.zhipudemo.model.vo.ZhiPuGenerateVideoVO;
import org.example.zhipudemo.service.ZhiPuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/5$ 21:02$
 * @Params: $
 * @Return $
 */
@Service
@Transactional
public class ZhiPuServiceImpl implements ZhiPuService {
    @Autowired
    public ZhiPuMapper zhiPuMapper;
    @Autowired
    public ZhiPuImageAndMessageApi zhiPuImageAndMessageApi;
    @Autowired
    public ZhiPuVideoApi zhiPuVideoApi;
    /**
     * 用户-文生图
     *
     * @param zhiPuGenerateImageDTO 传递的信息
     * @return url地址
     */
    @Override
    public ZhiPuGenerateImageVO getGenerateImageUrl(ZhiPuGenerateImageDTO zhiPuGenerateImageDTO) throws IOException {
        ZhiPuGenerateImageVO zhiPuGenerateImageVO = new ZhiPuGenerateImageVO();
        zhiPuGenerateImageVO.setUrl(zhiPuImageAndMessageApi.GenerateImage(zhiPuGenerateImageDTO));
        return zhiPuGenerateImageVO;
    }
    /**
     * 用户-图生文
     *
     * @param zhiPuGenerateMessageDTO 传递的信息
     * @return 结果
     */
    @Override
    public ZhiPuGenerateMessageVO getGenerateMessage(ZhiPuGenerateMessageDTO zhiPuGenerateMessageDTO) throws IOException {
        ZhiPuGenerateMessageVO zhiPuGenerateMessageVO = new ZhiPuGenerateMessageVO();
        zhiPuGenerateMessageVO.setMsg(zhiPuImageAndMessageApi.GenerateMessage(zhiPuGenerateMessageDTO));
        return zhiPuGenerateMessageVO;
    }
    /**
     * 用户-文生视频
     *
     * @param zhiPuGenerateVideoDTO 传递的信息
     * @return 结果
     */
    @Override
    public ZhiPuGenerateVideoVO generateVideo(ZhiPuGenerateVideoDTO zhiPuGenerateVideoDTO) {
        ZhiPuGenerateVideoVO zhiPuGenerateVideoVO = new ZhiPuGenerateVideoVO();
        zhiPuGenerateVideoVO.setVideo(zhiPuVideoApi.GenerateVideo(zhiPuGenerateVideoDTO));
        return zhiPuGenerateVideoVO;
    }
    /**
     * 用户-多轮图片理解对话
     *
     * @param zhiPuGenerateMessageDTO 传递的信息
     * @return 结果
     */
    @Override
    public ZhiPuGenerateMessageVO getGenerateMessageRepeatedly(ZhiPuGenerateMessageDTO zhiPuGenerateMessageDTO) throws IOException {
        Chat chat = new Chat();
        chat.setVideoMeg(zhiPuGenerateMessageDTO.getVideoMeg());
        chat.setImageMeg(zhiPuGenerateMessageDTO.getImageMeg());
        chat.setQuestion(zhiPuGenerateMessageDTO.getMessage());
        chat.setRoomId(zhiPuGenerateMessageDTO.getRoomId());
        chat.setCreateTime(new Date());
        List<History> historyList = zhiPuMapper.getHistory(zhiPuGenerateMessageDTO.getRoomId());
        ZhiPuGenerateMessageVO zhiPuGenerateMessageVO = new ZhiPuGenerateMessageVO();
        zhiPuGenerateMessageVO.setMsg(zhiPuImageAndMessageApi.GenerateMessageRepeatedly(zhiPuGenerateMessageDTO,historyList));
        chat.setAnswer(zhiPuGenerateMessageVO.getMsg());
        zhiPuMapper.insert(chat);
        return zhiPuGenerateMessageVO;
    }
//    /**
//     * 用户-图生文(文件调用)
//     *
//     * @param imageFile 传递的文件
//     * @return 结果
//     */
//    @Override
//    public ZhiPuGenerateMessageVO getGenerateMessageByFile(MultipartFile imageFile,String message) throws IOException {
//        ZhiPuGenerateMessageVO zhiPuGenerateMessageVO = new ZhiPuGenerateMessageVO();
//        zhiPuGenerateMessageVO.setMsg(zhiPuApi.GenerateMessage(new ZhiPuGenerateMessageDTO(),imageFile));
//        return zhiPuGenerateMessageVO;
//    }
}
