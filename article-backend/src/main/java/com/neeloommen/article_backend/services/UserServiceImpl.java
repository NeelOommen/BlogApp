package com.neeloommen.article_backend.services;

import com.neeloommen.article_backend.entity.UserCredentialEntity;
import com.neeloommen.article_backend.entity.UserEntity;
import com.neeloommen.article_backend.models.User;
import com.neeloommen.article_backend.models.UserSignUp;
import com.neeloommen.article_backend.repositories.UserCredentialsRepository;
import com.neeloommen.article_backend.repositories.UserRepository;
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
    public UserEntity saveUser(UserSignUp _user){
        //make user
        UserEntity newUser = new UserEntity(
                _user.getUsername(),
                _user.getEmail()
        );
        userRepository.save(newUser);
        //make user cred
        UserCredentialEntity newUserCred = new UserCredentialEntity(
                _user.getEmail(),
                _user.getPassword()
        );
        userCredentialsRepository.save(newUserCred);

        return newUser;
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
    public User validateUser(UserCredentialEntity user) {
        Optional<UserCredentialEntity> checkUser = Optional.ofNullable(userCredentialsRepository.findByEmail(user.getEmail()));
        if(checkUser.isPresent()){
            UserCredentialEntity pwordCheck = checkUser.get();
            //check if the passwords match
            if(pwordCheck.getPassword().equals(user.getPassword())){
                //user validated return user data
                UserCredentialEntity userEntity = checkUser.get();
                UserEntity userobj = userRepository.findByEmailId(userEntity.getEmail());
                User resultUser = new User(
                        userobj.getId(),
                        userobj.getUserName(),
                        userobj.getEmailId()
                );
                return resultUser;
            }
        }
        //some validation has failed return null

        return null;
    }
}
