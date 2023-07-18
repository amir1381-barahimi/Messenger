package ir.brahimi.brahimichater.service;

import ir.brahimi.brahimichater.shared.dto.MessageDto;
import ir.brahimi.brahimichater.ui.model.response.MessageResponseModel;

public interface MessageService {
    public MessageDto sendMessage(MessageDto messageDto);
}
