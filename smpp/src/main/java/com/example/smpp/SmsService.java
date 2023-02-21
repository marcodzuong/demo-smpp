package com.example.smpp;

import com.cloudhopper.smpp.SmppSession;
import com.cloudhopper.smpp.pdu.SubmitSm;
import com.cloudhopper.smpp.type.Address;
import com.cloudhopper.smpp.util.SmppUtil;
import org.springframework.stereotype.Service;

/**
 * @author Marco.Duong
 */
@Service
public class SmsService {
    private final SmppSession smppSession;

    public SmsService(SmppSession smppSession) {
        this.smppSession = smppSession;
    }

    public void sendSms(String sourceAddress, String destAddress, String message) throws Exception {
        SubmitSm submit = new SubmitSm();
        submit.setSourceAddress(new Address((byte) 0x03, (byte) 0x00, sourceAddress));
        submit.setDestAddress(new Address((byte) 0x01, (byte) 0x01, destAddress));
        submit.setShortMessage(message.getBytes());
        smppSession.submit(submit, 10000);
    }
}

