package com.xh.service.impl;

import com.xh.service.MessageService;
import org.springframework.stereotype.Service;

/**
 * @author Xiong Hao
 */
@Service
public class MessageServiceImpl implements MessageService {

    public String message() {
        return "message...";
    }
}
