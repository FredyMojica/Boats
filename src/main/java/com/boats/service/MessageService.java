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
        if (messageModel.getId() ==null){
            return  messageRepository.saveMessage(messageModel);
        }else{
            Optional<MessageModel> optionalMessageModel=messageRepository.getMessage(messageModel.getId());
            if (optionalMessageModel.isEmpty()){
                return messageRepository.saveMessage(messageModel);
            }else {
                return messageModel;
            }
        }
    }

    public MessageModel updateMessage(MessageModel messageModel){
        if (messageModel.getId()!=null){
            Optional<MessageModel> optionalMessageModel=messageRepository.getMessage(messageModel.getId());
            if (!optionalMessageModel.isEmpty()){
                if (messageModel.getMessageText()!=null){
                    optionalMessageModel.get().setMessageText(messageModel.getMessageText());
                }
                messageRepository.saveMessage(optionalMessageModel.get());
                return optionalMessageModel.get();
            }else {
                return messageModel;
            }
        }else {
            return messageModel;
        }
    }

    public boolean deleteMessage(Integer id){
        Boolean aBoolean=getMessage(id).map(messageModel -> {
            messageRepository.deleteMessage(messageModel);
            return true;
        }).orElse(false);
        return aBoolean;
    }


}
