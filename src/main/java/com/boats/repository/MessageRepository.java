package com.boats.repository;

import com.boats.model.MessageModel;
import com.boats.repository.crudrepository.MessageCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageRepository {

    @Autowired
    private MessageCrudRepository messageCrudRepository;

    public List<MessageModel> getAllMessages() {
        return (List<MessageModel>) messageCrudRepository.findAll();
    }

    public Optional<MessageModel> getMessage(Integer id) {
        return messageCrudRepository.findById(id);
    }

    public MessageModel saveMessage(MessageModel messageModel) {
        return messageCrudRepository.save(messageModel);
    }

    public void deleteMessage(Integer id) {
        messageCrudRepository.deleteById(id);
    }

    /*El de actualizar no es necesario
    public MessageModel updateMessage(MessageModel messageModel) {
        return messageCrudRepository.save(messageModel);
    }*/

}
