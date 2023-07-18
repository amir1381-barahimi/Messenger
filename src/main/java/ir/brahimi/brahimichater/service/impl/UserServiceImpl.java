package ir.brahimi.brahimichater.service.impl;

import ir.brahimi.brahimichater.io.entity.UserEntity;
import ir.brahimi.brahimichater.io.repository.UserRepository;
import ir.brahimi.brahimichater.service.UserService;
import ir.brahimi.brahimichater.shared.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        UserDto returnValue=new UserDto();
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = modelMapper.map(userDto, UserEntity.class);

        userEntity.setEncryptedPassword(userEntity.getPassword());

        UserEntity storedUserDetails = userRepository.save(userEntity);

        returnValue  = modelMapper.map(storedUserDetails, UserDto.class);

        return returnValue;
    }

    @Override
    public UserDto getUserByUserName(String username) {
        UserDto returnValue = new UserDto();
        ModelMapper modelMapper = new ModelMapper();
        UserEntity userEntity = userRepository.findByUserName(username);
        returnValue  = modelMapper.map(userEntity, UserDto.class);
        return returnValue;
    }
}
