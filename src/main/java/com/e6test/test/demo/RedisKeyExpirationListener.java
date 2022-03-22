package com.e6test.test.demo;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

/**
 * redis key 过期
 * @author zzz
 *
 */
@Component
public class RedisKeyExpirationListener extends KeyExpirationEventMessageListener {
    public RedisKeyExpirationListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);

    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        String expireKey = message.toString();
        System.out.println("失效的key" + expireKey);
    }
}
