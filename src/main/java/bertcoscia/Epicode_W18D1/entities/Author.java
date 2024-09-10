package bertcoscia.Epicode_W18D1.entities;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Author {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String birthDate;
    private String avatar;
}
