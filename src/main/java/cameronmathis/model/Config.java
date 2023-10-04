package cameronmathis.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Config {

    private String username;
    private String key;
    private String value;
}
