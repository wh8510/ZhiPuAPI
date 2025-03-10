package org.example.zhipudemo.ZhiPu;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author: 张文化
 * @Description: $
 * @DateTime: 2025/3/9$ 02:26$
 * @Params: $
 * @Return $
 */
@SpringBootTest
class ZhiPuRequestTest {
    @Autowired
    public ZhiPuRequest zhiPuRequest;
    @Test
    void getRequest() {
        String json = zhiPuRequest.GetRequest("https://open.bigmodel.cn/api/paas/v4/async-result/13941741178002032-8909452841645776757");
        System.out.println(json);
    }
}