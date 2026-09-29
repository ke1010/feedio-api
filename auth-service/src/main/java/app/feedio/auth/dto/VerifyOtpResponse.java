package app.feedio.auth.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class VerifyOtpResponse {

    boolean success;
    String message;
    String phoneNo;
    String otp;
}
