package org.example.zhipudemo.ZhiPu;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/9$ 01:47$
 * @Params: $
 * @Return $
 */
@Component
public class ZhiPuRequest {
    @Value("${ZhiPu.apiKey}")
    private String apiKey;
    public String PostRequest(String url,String jsonBody) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(61, TimeUnit.SECONDS)  // 连接超时61秒
                .readTimeout(61, TimeUnit.SECONDS)     // 读取超时61秒
                .writeTimeout(61, TimeUnit.SECONDS)    // 写入超时61秒
                .build();
        RequestBody body = RequestBody.create(MediaType.parse("application/json"), jsonBody);
        System.out.println(body);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .header("Content-Type", "application/json")
                .header("Authorization", apiKey)
                .build();
        System.out.println(request);
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String errorBody = response.body() != null ? response.body().string() : "无错误信息";
                throw new IOException("请求失败，状态码: " + response.code() + "，错误信息: " + errorBody);
            }
            String responseData = response.body().string();
            System.out.println("Response: " + responseData);
            return responseData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String GetRequest(String url) {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(61, TimeUnit.SECONDS)  // 连接超时61秒
                .readTimeout(61, TimeUnit.SECONDS)     // 读取超时61秒
                .writeTimeout(61, TimeUnit.SECONDS)    // 写入超时61秒
                .build();
        Request request = new Request.Builder()
                .url(url)
                .get()
                .header("Content-Type", "application/json")
                .header("Authorization", apiKey)
                .build();
        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) {
                String errorBody = response.body() != null ? response.body().string() : "无错误信息";
                throw new IOException("请求失败，状态码: " + response.code() + "，错误信息: " + errorBody);
            }
            String responseData = response.body().string();
            return responseData;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public String  Get(String url) {
        String responseData = "";
        boolean isSuccess = false;
        while (!isSuccess) {
            // 发送GET请求
            responseData = GetRequest(url);
            // 解析返回的JSON数据
            JsonObject json = JsonParser.parseString(responseData).getAsJsonObject();
            // 获取task_status字段的值
            String taskStatus = json.get("task_status").getAsString();

            // 如果task_status为SUCCESS，则停止循环
            if ("SUCCESS".equals(taskStatus)) {
                System.out.println("任务完成，状态: SUCCESS");
                isSuccess = true;
            } else {
                // 如果task_status不是SUCCESS，等待5秒钟后再请求
                System.out.println("任务正在处理中，等待5秒钟后重试...");
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("线程中断，停止请求.");
                    break;
                }
            }
        }
        return responseData;
    }
}
