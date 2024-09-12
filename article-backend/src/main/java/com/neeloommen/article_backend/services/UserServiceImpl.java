package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.UserCredentialEntity;
import com.neeloommen.article_backend.entity.UserEntity;
import com.neeloommen.article_backend.models.User;
import com.neeloommen.article_backend.repositories.UserCredentialsRepository;
import com.neeloommen.article_backend.repositories.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    //Data members
    private UserRepository userRepository;
    private UserCredentialsRepository userCredentialsRepository;

    public UserServiceImpl(UserRepository _userRepository, UserCredentialsRepository _userCredentialRepository) {
        this.userRepository = _userRepository;
        this.userCredentialsRepository = _userCredentialRepository;
    }



    @Override
    public User saveUser(User _user){
        UserEntity userEntity = new UserEntity(_user.getId(), _user.getUserName(), _user.getEmailId());
        //userRepository.save(userEntity);

        return _user;
    }

    @Override
    public List<User> getUserList(){
        List<UserEntity> userEntityList = userRepository.findAll();

        List<User> userList = userEntityList
                .stream()
                .map(userEntity -> new User(
                    userEntity.getId(),
                    userEntity.getUserName(),
                    userEntity.getEmailId()
        )).collect(Collectors.toList());

        //DEBUG
        //List<User> dummyList = List.of(this.dummyUser);

        return userList;

        //return dummyList;
    }

    @Override
    public ResponseEntity<User> validateUser(UserCredentialEntity user) {
        Optional<UserCredentialEntity> checkUser = Optional.ofNullable(userCredentialsRepository.findByEmail(user.getEmail()));
        if(checkUser.isPresent()){
            User userobj = userRepository.findByEmailId(checkUser.get().getEmail());
            return ResponseEntity.ok(userobj);
        }

        return (ResponseEntity<User>) ResponseEntity.notFound();
    }
}
