//package com.example.about.bookstore.service;
//
//import com.example.about.bookstore.dao.entity.User;
//import com.example.about.bookstore.dao.repository.UserRepository;
//import com.example.about.bookstore.mapper.ContactMapper;
//import com.example.about.bookstore.mapper.UserMapper;
//import com.example.about.bookstore.model.dto.ContactDto;
//import com.example.about.bookstore.model.dto.UserDto;
//import org.springframework.stereotype.Service;
//
//import javax.transaction.Transactional;
//import java.util.Optional;
//
//
//@Service
//public class UserService {
//    private final UserRepository userRepository;
//    private final UserMapper userMapper;
//
//
//    public UserService(UserRepository userRepository, UserMapper userMapper) {
//        this.userRepository = userRepository;
//        this.userMapper = userMapper;
//
//    }
//
//    @Transactional
//    public Optional<User> findUserByEmail(String email) {
//        return userRepository.findUserByEmail(email);
//    }
//
//    public boolean userExists(String email) {
//        return findUserByEmail(email).isPresent();
//    }
//
//    public boolean saveUser(UserDto userDto) {
//        userRepository.save(userMapper.mapDtoToEntity(userDto));
//        return true;
//    }
//}
