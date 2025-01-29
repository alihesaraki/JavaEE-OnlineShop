package com.mftplus.demo.controller.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mftplus.demo.model.entity.Message;
import jakarta.websocket.EncodeException;
import jakarta.websocket.Encoder;

//casting obj to text!
public class MessageEncoder implements Encoder.Text<Message> {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public String encode(Message message) throws EncodeException {
        try {
            return mapper.writeValueAsString(message);
        } catch (Exception e) {
            throw new EncodeException(message, "Message Encode Failed !", e);
        }
    }
}
