package org.example.zhipudemo.controller;

import org.example.zhipudemo.common.model.BaseResponse;
import org.example.zhipudemo.model.dto.ZhiPuGenerateImageDTO;
import org.example.zhipudemo.model.dto.ZhiPuGenerateMessageDTO;
import org.example.zhipudemo.model.dto.ZhiPuGenerateVideoDTO;
import org.example.zhipudemo.model.vo.ZhiPuGenerateImageVO;
import org.example.zhipudemo.model.vo.ZhiPuGenerateMessageVO;
import org.example.zhipudemo.model.vo.ZhiPuGenerateVideoVO;
import org.example.zhipudemo.service.ZhiPuService;
import org.example.zhipudemo.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/5$ 21:01$
 * @Params: $
 * @Return $
 */
@RestController
@RequestMapping("/ZhiPu")
public class ZhiPuController {
    @Autowired
    public ZhiPuService zhiPuService;
    /**
     * 用户-文生图
     *
     * @param zhiPuGenerateImageDTO 传递的信息
     * @return 结果
     */
    @GetMapping("/generateImage")
    public BaseResponse<ZhiPuGenerateImageVO> generateImage(@RequestBody ZhiPuGenerateImageDTO zhiPuGenerateImageDTO) throws IOException {
        ZhiPuGenerateImageVO zhiPuGenerateImageVO = zhiPuService.getGenerateImageUrl(zhiPuGenerateImageDTO);
        return ResultUtil.success(zhiPuGenerateImageVO);
    }
    /**
     * 用户-图、视频生文(url或者base64通用)
     *
     * @param zhiPuGenerateMessageDTO 传递的信息
     * @return 结果
     */
    @GetMapping("/generateMessage")
    public BaseResponse<ZhiPuGenerateMessageVO> generateMessage(@RequestBody ZhiPuGenerateMessageDTO zhiPuGenerateMessageDTO) throws IOException {
        ZhiPuGenerateMessageVO zhiPuGenerateMessageVO = zhiPuService.getGenerateMessage(zhiPuGenerateMessageDTO);
        return ResultUtil.success(zhiPuGenerateMessageVO);
    }
//    /**
//     * 用户-图生文(文件调用)
//     *
//     * @param imageFile 传递的文件
//     * @return 结果
//     */
//    @GetMapping("/generateMessage/file")
//    public BaseResponse<ZhiPuGenerateMessageVO> generateMessage(MultipartFile imageFile,String message) throws IOException {
//        ZhiPuGenerateMessageVO zhiPuGenerateMessageVO = zhiPuService.getGenerateMessageByFile(imageFile,message);
//        return ResultUtil.success(zhiPuGenerateMessageVO);
//    }
    /**
     * 用户-文生视频
     *
     * @param zhiPuGenerateVideoDTO 传递的信息
     * @return 结果
     */
    @GetMapping("/generateVideo")
    public BaseResponse<ZhiPuGenerateVideoVO> generateVideo(@RequestBody ZhiPuGenerateVideoDTO zhiPuGenerateVideoDTO) throws IOException {
        ZhiPuGenerateVideoVO zhiPuGenerateVideoVO = zhiPuService.generateVideo(zhiPuGenerateVideoDTO);
        return ResultUtil.success(zhiPuGenerateVideoVO);
    }
    /**
     * 用户-多轮图片理解对话
     *
     * @param zhiPuGenerateMessageDTO 传递的信息
     * @return 结果
     */
    @GetMapping("/generateImageRepeatedly")
    public  BaseResponse<ZhiPuGenerateMessageVO> generateImage(@RequestBody ZhiPuGenerateMessageDTO zhiPuGenerateMessageDTO) throws IOException {
        ZhiPuGenerateMessageVO zhiPuGenerateMessageVO = zhiPuService.getGenerateMessageRepeatedly(zhiPuGenerateMessageDTO);
        return ResultUtil.success(zhiPuGenerateMessageVO);
    }
}