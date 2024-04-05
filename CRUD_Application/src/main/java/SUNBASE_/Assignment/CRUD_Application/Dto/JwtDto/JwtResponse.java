package SUNBASE_.Assignment.CRUD_Application.Dto.JwtDto;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtResponse {

    String jwtToken;

    String username;
}