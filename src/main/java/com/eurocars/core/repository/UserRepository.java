package com.eurocars.core.repository;


import com.eurocars.core.model.User;
import com.eurocars.core.model.enums.UserType;
import org.springframework.data.mongodb.repository.Aggregation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

    @Aggregation(pipeline = """
        { $match: { _id: { $exists: true } } }
    """)
    List<User> findAllCustom();


    @Query(value="{email:'?0'}", fields="{'id': 1, 'firstName': 1, 'lastName': 1, 'email': 1, 'username': 1, 'userType': 1}")
    Optional<User> findByEmailCustom(String email);

    Optional<User> findByEmail(String email);

    @Query(value="{$or:[{email:'?0'}, {username:'?0'}]}")
    Optional<User> findByUsernameOrEmail(String username);

    Optional<User> findFirstByEmailLike(String emailPattern);

    List<User> findByEmailAndUserTypeOrderByCreationDateDesc(String email, UserType userType);
}

