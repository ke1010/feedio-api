package app.feedio.auth.service;

import app.feedio.auth.dto.SendOtpResponse;
import app.feedio.auth.dto.VerifyOtpRequest;
import app.feedio.auth.dto.VerifyOtpResponse;
import app.feedio.auth.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class AuthService {


    private final Map<String, String> hMap = new ConcurrentHashMap<>();
    public SendOtpResponse sendOtp(String phoneNo) {
        String otp = Util.generateOtp();
        hMap.put(phoneNo, otp);
        return new SendOtpResponse(true, "Otp sent successfully", otp);
    }


    public VerifyOtpResponse verifyOtp(VerifyOtpRequest verifyOtpRequest) {
        String storedOtp = hMap.get(verifyOtpRequest.getPhoneNo());

        if (storedOtp != null && storedOtp.equals(verifyOtpRequest.getOtp())) {
            hMap.remove(verifyOtpRequest.getPhoneNo());
            return new VerifyOtpResponse(true, "Otp verified", verifyOtpRequest.getPhoneNo(), verifyOtpRequest.getOtp());
        }
        return new VerifyOtpResponse(false, "Otp verification failed", "", verifyOtpRequest.getOtp());
    }
}
