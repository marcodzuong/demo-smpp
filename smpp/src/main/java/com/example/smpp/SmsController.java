package com.example.smpp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Marco.Duong
 */
@RestController
@RequestMapping("/test")
public class SmsController {
    private final SmsService smsService;

    public SmsController(SmsService smsService) {
        this.smsService = smsService;
    }

    @GetMapping("/send-sms")
    public Object sendSms() {
        try {
            smsService.sendSms("sourceAddress", "destAddress", "message");
            return ResponseEntity.ok("SMS sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error sending SMS: " + e.getMessage());
        }
    }
}

