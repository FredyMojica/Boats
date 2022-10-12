package com.boats.service;

import com.boats.model.MessageModel;
import com.boats.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public List<MessageModel> getAllMessages(){
        return messageRepository.getAllMessages();
    }

    public Optional<MessageModel> getMessage(Integer id) {
        return messageRepository.getMessage(id);
    }

    public MessageModel saveMessage(MessageModel messageModel) {
        return messageRepository.saveMessage(messageModel);
    }

    public void deleteMessage (Integer id) {
        messageRepository.deleteMessage(id);
    }

    public MessageModel updateMessage(MessageModel messageModel) {
        return messageRepository.updateMessage(messageModel);
    }
}
