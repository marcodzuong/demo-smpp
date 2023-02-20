package com.example.smpp.service;

import com.github.mikesafonov.smpp.api.SenderManager;
import com.github.mikesafonov.smpp.core.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Marco.Duong
 */
@Service
public class SmppService {

    private final SenderManager senderManager;

    @Autowired
    public SmppService(SenderManager senderManager){
        this.senderManager = senderManager;
    }

    public void sendMessage(String from, String to, String text) {
        Message message = Message.simple(text)
                .from(from)
                .to(to)
                .build();
        senderManager.getClient().send(message);
    }
}
