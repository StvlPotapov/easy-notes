package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.User;
import com.example.easynotes.model.UserAuthAccount;
import com.example.easynotes.repository.UserAuthAccountRepository;
import com.example.easynotes.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apiauth")
public class UserAuthAccountController {


   private final UserAuthAccountRepository userAuthAccountRepository;

    @Autowired
    public UserAuthAccountController(UserAuthAccountRepository userAuthAccountRepository) {
        this.userAuthAccountRepository=userAuthAccountRepository;
    }

    // GET all userAuthAcc
    @GetMapping(value = "/userauth", consumes = "application/json")
    public List<UserAuthAccount> getAllUserAuthAccount() {
        return userAuthAccountRepository.findAll();
    }


    //Create a new userAuthAcc
    @PostMapping("/userauth")
    public UserAuthAccount createUserAuthAccount(@Valid @RequestBody UserAuthAccount userAuthAccount) {
        return userAuthAccountRepository.save(userAuthAccount);
    }



    @GetMapping("/userauth/{id}")
    public ResponseEntity<UserAuthAccount> getNoteById(@PathVariable(value = "id") Long userId) {
        UserAuthAccount user = userAuthAccountRepository.getOne(userId);

        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(user);
    }

    //put

    @PutMapping("userauth/{id}")
    public UserAuthAccount updateUserAuthAccount(@PathVariable(value = "id") Long id,
                                                 @Valid @RequestBody UserAuthAccount userDetail) {
        UserAuthAccount userAuthAccount = userAuthAccountRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("UserAuthAcc", "id", id));

        userAuthAccount.setVkmail(userDetail.getVkmail());
        userAuthAccount.setPhoneNumber(userDetail.getPhoneNumber());
        UserAuthAccount updateUserAuth = userAuthAccountRepository.save(userAuthAccount);
        return updateUserAuth;
    }


    @DeleteMapping("/userauth/{id}")
    public ResponseEntity<?> deleteUserAuthAccount(@PathVariable(value = "id") Long userId) {
        UserAuthAccount userAuthAccount = userAuthAccountRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Note", "id", userId));

        userAuthAccountRepository.delete(userAuthAccount);

        return ResponseEntity.ok().build();
    }


}
