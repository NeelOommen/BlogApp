package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.UserEntity;
import com.neeloommen.article_backend.models.User;
import com.neeloommen.article_backend.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    //Data members
    //private UserRepository userRepository;

    //DEBUG
    private User dummyUser;

    //methods
    //constructors
//    public UserServiceImpl(UserRepository _userRepository) {
//        this.userRepository = _userRepository;
//
//        //DEBUG
//        this.dummyUser = new User(
//                1,
//                "username1",
//                "emailid@email.com"
//        );
//    }

    public UserServiceImpl() {
        //this.userRepository = _userRepository;

        //DEBUG
        this.dummyUser = new User(
                1,
                "username1",
                "emailid@email.com"
        );
    }

    @Override
    public User saveUser(User _user){
        UserEntity userEntity = new UserEntity(_user.getId(), _user.getUserName(), _user.getEmailId());
        //userRepository.save(userEntity);

        return _user;
    }

    @Override
    public List<User> getUserList(){
//        List<UserEntity> userEntityList = userRepository.findAll();
//
//        List<User> userList = userEntityList
//                .stream()
//                .map(userEntity -> new User(
//                    userEntity.getId(),
//                    userEntity.getUserName(),
//                    userEntity.getEmailId()
//        )).collect(Collectors.toList());

        //DEBUG
        List<User> dummyList = List.of(this.dummyUser);

//        return userList;

        return dummyList;
    }
}
