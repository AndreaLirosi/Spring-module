package develhope.APIMiddleware2.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Month {
    private int monthNumber;
    private String englishName;
    private String italianName;
    private String germanName;
}
