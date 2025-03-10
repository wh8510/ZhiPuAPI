package org.example.zhipudemo.ZhiPu;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.example.zhipudemo.model.dto.ZhiPuGenerateVideoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/7$ 20:38$
 * @Params: $
 * @Return $
 */
@Component
public class ZhiPuVideoApi {
    @Autowired
    public ZhiPuRequest zhiPuRequest;
    @Value("${ZhiPu.videoModel}")
    private String videoModel;
    @Value("${ZhiPu.videoUrl}")
    private String videoUrl;
    @Value("${ZhiPu.getVideoUrl}")
    private String getVideoUrl;
    /**
     * 用户-文生视频
     *
     * @param zhiPuGenerateVideoDTO 传递的信息
     * @return 结果
     */
    public String GenerateVideo(ZhiPuGenerateVideoDTO zhiPuGenerateVideoDTO) {
//         发送请求并获取响应
        String response = generateVideo(zhiPuGenerateVideoDTO);
        System.out.println(response);
//         解析响应，假设返回的是 JSON 格式
        JsonObject json = JsonParser.parseString(response).getAsJsonObject();
        System.out.println(json);
        String VideoUrl = json.getAsJsonArray("video_result").get(0).getAsJsonObject().get("url").getAsString();
        System.out.println("Generated Video URL: " + VideoUrl);
        return VideoUrl;
    }

    private String generateVideo(ZhiPuGenerateVideoDTO zhiPuGenerateVideoDTO) {
//        拼装发送的POST请求的json
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("model", videoModel);
        if (!zhiPuGenerateVideoDTO.getImage().isEmpty()&&!zhiPuGenerateVideoDTO.getPrompt().isEmpty()) {
            jsonObject.put("image_url", zhiPuGenerateVideoDTO.getImage());
            jsonObject.put("prompt", zhiPuGenerateVideoDTO.getPrompt());
        }else if(!zhiPuGenerateVideoDTO.getPrompt().isEmpty()){
            jsonObject.put("prompt", zhiPuGenerateVideoDTO.getPrompt());
        }else throw new RuntimeException("缺少输入！");
        jsonObject.put("quality", zhiPuGenerateVideoDTO.getQuality());
        jsonObject.put("with_audio", zhiPuGenerateVideoDTO.getWithAudio());
        jsonObject.put("size", zhiPuGenerateVideoDTO.getSize());
        jsonObject.put("fps", zhiPuGenerateVideoDTO.getFps());
        String jsonBody = String.valueOf(jsonObject);
        String responseData =  zhiPuRequest.PostRequest(videoUrl, jsonBody);
        JsonObject json = JsonParser.parseString(responseData).getAsJsonObject();
        String id = json.get("id").getAsString();
        return zhiPuRequest.Get(getVideoUrl+id);
    }
}
