package cameronmathis.model;

import cameronmathis.enums.StorageType;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserConfig {

    private String username;
    private String directory;
    private StorageType storageType;
}
