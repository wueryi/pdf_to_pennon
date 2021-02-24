package com.pennonedu.student_sign_api.component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pennonedu.student_sign_api.entity.FlowFileAccount;
import com.pennonedu.student_sign_api.service.SealService;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;
import org.springframework.stereotype.Component;

/**
 * @author jishuai
 */
@Component
public class SealPositionMqListener implements MessageListener {
    @Override
    public void onMessage(Message message, byte[] bytes) {
        System.out.println("从消息通道={" + new String(bytes) + "}监听到消息");
        ObjectMapper mapper = new ObjectMapper();
        try {
            FlowFileAccount flowFileAccount = mapper.readValue(message.getBody(), FlowFileAccount.class);
            SealService sealService = SpringContextHolder.getBean("SealService");
            sealService.handle(flowFileAccount);
        }catch (Exception exception){
            exception.printStackTrace();
        }
    }
}
