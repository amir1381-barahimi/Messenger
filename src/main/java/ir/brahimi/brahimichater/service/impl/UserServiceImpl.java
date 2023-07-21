package ir.brahimi.brahimichater.service.impl;

import ir.brahimi.brahimichater.io.entity.UserEntity;
import ir.brahimi.brahimichater.io.repository.UserRepository;
import ir.brahimi.brahimichater.service.UserService;
import ir.brahimi.brahimichater.shared.dto.UserDto;
import ir.brahimi.brahimichater.ui.model.request.UserLoginRequestModel;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.AuthenticationException;

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

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userEntity.setEncryptedPassword(passwordEncoder.encode(userEntity.getPassword()));

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

    @Override
    public boolean register(UserLoginRequestModel userLoginRequestModel) throws AuthenticationException {
        ModelMapper modelMapper = new ModelMapper();

        UserEntity userEntity = userRepository.findByUserName(userLoginRequestModel.getUserName());
        if (userEntity == null) {
            throw new AuthenticationException("user not exist");
        }
        UserDto findUser = modelMapper.map(userEntity, UserDto.class);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passwordEncoderLogin = passwordEncoder.encode(userLoginRequestModel.getPassword());
        boolean result = passwordEncoder.matches(findUser.getPassword(), passwordEncoderLogin);
//        if (result)
//            return findUser.getUserName() + "authenticated";
//        else
//            throw new AuthenticationException("password is not correct!");
        return result;
    }
}
