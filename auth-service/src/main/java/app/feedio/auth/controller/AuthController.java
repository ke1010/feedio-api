package app.feedio.auth.controller;

import app.feedio.auth.dto.SendOtpResponse;
import app.feedio.auth.dto.VerifyOtpRequest;
import app.feedio.auth.dto.VerifyOtpResponse;
import app.feedio.auth.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1-auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/send-otp/{phoneNo}")
    public ResponseEntity<SendOtpResponse> getOtpSent(@PathVariable String phoneNo){
        return new ResponseEntity<>(authService.sendOtp(phoneNo), HttpStatus.OK);
    }

    @PostMapping("/verify-otp")
    public ResponseEntity<VerifyOtpResponse> getOtpSent(@RequestBody VerifyOtpRequest verifyOtpRequest){
        return new ResponseEntity<>(authService.verifyOtp(verifyOtpRequest), HttpStatus.OK);
    }


}
