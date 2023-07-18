package ir.brahimi.brahimichater.service.impl;

import ir.brahimi.brahimichater.io.entity.MessageEntity;
import ir.brahimi.brahimichater.io.repository.MessageRepository;
import ir.brahimi.brahimichater.service.MessageService;
import ir.brahimi.brahimichater.shared.dto.ChannelDto;
import ir.brahimi.brahimichater.shared.dto.GroupDto;
import ir.brahimi.brahimichater.shared.dto.MessageDto;
import ir.brahimi.brahimichater.shared.enums.Type;
import ir.brahimi.brahimichater.ui.model.response.MessageResponseModel;
import net.bytebuddy.utility.dispatcher.JavaDispatcher;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;

    public MessageServiceImpl(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }



    @Override
    public MessageDto sendMessage(MessageDto messageDto) {
        ModelMapper modelMapper = new ModelMapper();
        messageDto.setDate(new Date(System.currentTimeMillis()));
        if(messageDto.getReceiver() instanceof GroupDto){
            messageDto.setType(Type.GROUP);
        }else if(messageDto.getReceiver() instanceof ChannelDto){
            messageDto.setType(Type.CHANNEL);
        }else{
            messageDto.setType(Type.PV);
        }
        MessageEntity messageEntity = modelMapper.map(messageDto,MessageEntity.class);
        MessageEntity storedMessage =  messageRepository.save(messageEntity);
        return modelMapper.map(storedMessage,MessageDto.class);
    }
}
