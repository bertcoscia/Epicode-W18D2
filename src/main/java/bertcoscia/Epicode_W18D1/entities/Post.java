package bertcoscia.Epicode_W18D1.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Post {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String body;
    private int readingTime;
}
