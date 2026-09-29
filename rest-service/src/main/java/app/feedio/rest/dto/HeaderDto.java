package app.feedio.rest.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class HeaderDto {

  String location;
    private String greetingMessage;// e.g., "Good evening, Alex!"
    private boolean hasUnreadNotifications;

}
