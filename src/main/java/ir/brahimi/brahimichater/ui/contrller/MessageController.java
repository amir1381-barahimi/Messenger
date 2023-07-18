package ir.brahimi.brahimichater.ui.contrller;

import ir.brahimi.brahimichater.service.MessageService;
import ir.brahimi.brahimichater.shared.dto.MessageDto;
import ir.brahimi.brahimichater.ui.model.request.MessageRequestModel;
import ir.brahimi.brahimichater.ui.model.response.MessageResponseModel;
import ir.brahimi.brahimichater.ui.model.response.UserResponseModel;
import org.modelmapper.ModelMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/messages")
public class MessageController {

    private final MessageService messageService;

    public MessageController(MessageService messageService) {
        this.messageService = messageService;
    }


    @PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE }, produces = {
            MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public MessageResponseModel sendMessage(@RequestBody MessageRequestModel messageRequestModel){
        ModelMapper modelMapper = new ModelMapper();
        MessageDto messageDto =modelMapper.map(messageRequestModel,MessageDto.class);
        MessageDto sevedMessage = messageService.sendMessage(messageDto);
        return modelMapper.map(sevedMessage, MessageResponseModel.class);
    }
}
