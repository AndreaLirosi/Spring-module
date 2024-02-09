package develhope.API.Interceptor.Middleware1.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private long id;
    private String firstName;
    private String lastName;
    private int age;
}
