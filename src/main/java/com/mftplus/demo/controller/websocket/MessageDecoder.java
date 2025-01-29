package com.mftplus.demo.controller.websocket;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mftplus.demo.model.entity.Message;
import jakarta.websocket.DecodeException;
import jakarta.websocket.Decoder;

public class MessageDecoder implements Decoder.Text<Message> {
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public Message decode(String stringMessage) throws DecodeException {
        try {
            return mapper.readValue(stringMessage, Message.class);
        } catch (Exception e) {
            throw new DecodeException(stringMessage, "Message Decode Failed !", e);
        }
    }

    @Override
    public boolean willDecode(String stringMessage) {
        try {
            mapper.readValue(stringMessage, Message.class);
            return true;
        } catch (Exception e) {
            return false;
          }
    }
}
