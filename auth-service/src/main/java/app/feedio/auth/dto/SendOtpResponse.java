package app.feedio.auth.dto;


import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SendOtpResponse {

    boolean success;
    String message;
    String otp;


}
