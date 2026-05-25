package com.curd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.curd.model.User;
import com.curd.repository.UserRepository;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.List;
import java.util.Random;

@Service
public class UserService {

	@Autowired
    private UserRepository userRepository;

    // Step 1: Signup → generate OTP
    public String signup(User user) {
        try {
            User existing = userRepository.findByPhone(user.getPhone());
            String otp = String.format("%04d", new Random().nextInt(9000) + 1000);

            if (existing != null) {
                // Resend OTP
                existing.setOtp(otp);
                userRepository.save(existing);
                System.out.println("Demo OTP: " + otp); // demo OTP console
                return "OTP resent to your phone (demo)";
            }

            // New user
            user.setOtp(otp);
            userRepository.save(user);
            System.out.println("Demo OTP: " + otp); // demo OTP console
            return "OTP sent to your phone ";
        } catch (Exception e) {
            e.printStackTrace();
            return "Failed to send OTP: " + e.getMessage();
        }
    }

    // Step 2: Verify OTP → save name/email/password
    public String verifyOtp(User user){
        User existing = userRepository.findByPhone(user.getPhone());
        if(existing != null && existing.getOtp() != null && existing.getOtp().equals(user.getOtp())){
            existing.setOtp(null); // clear OTP
            existing.setName(user.getName());
            existing.setEmail(user.getEmail());
            existing.setPassword(user.getPassword());
            userRepository.save(existing);
            return "Signup Successful";
        }
        return "Invalid OTP";
    }

    // Login
    public String login(User user){
        User existing = userRepository.findByEmail(user.getEmail());
        if(existing != null && existing.getPassword().equals(user.getPassword())){
            return "Login Successful";
        }
        return "Invalid Email or Password";
    }
    
    // Get All Users
    public List<User> getUsers(){

        return userRepository.findAll();
    }
}
	
    

