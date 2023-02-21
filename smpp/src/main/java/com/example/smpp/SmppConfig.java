package com.example.smpp;

import com.cloudhopper.smpp.SmppSession;
import com.cloudhopper.smpp.SmppSessionConfiguration;
import com.cloudhopper.smpp.impl.DefaultSmppClient;
import com.cloudhopper.smpp.type.SmppChannelException;
import com.cloudhopper.smpp.type.SmppTimeoutException;
import com.cloudhopper.smpp.type.UnrecoverablePduException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Marco.Duong
 */
@Configuration
public class SmppConfig {
    @Value("${smpp.host}")
    private String host;

    @Value("${smpp.port}")
    private int port;

    @Value("${smpp.systemId}")
    private String systemId;

    @Value("${smpp.password}")
    private String password;

    @Value("${smpp.systemType}")
    private String systemType;

    @Bean
    public SmppSession smppSession() throws Exception {
        try {
            System.out.println("smppSession Run");
            SmppSessionConfiguration config = new SmppSessionConfiguration();
            config.setWindowSize(5);
            config.setName("smppSession");
            config.setHost(host);
            config.setPort(port);
            config.setConnectTimeout(10000);
            config.setSystemId(systemId);
            config.setPassword(password);
            config.setSystemType(systemType);

            return new DefaultSmppClient().bind(config);
        } catch (Exception e) {
            return  null;
        }
    }
}

