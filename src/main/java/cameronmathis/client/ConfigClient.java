package cameronmathis.client;

import cameronmathis.enums.StorageType;
import cameronmathis.model.Config;
import cameronmathis.model.UserConfig;

import java.util.Map;

public class ConfigClient {

    private static final String DIRECTORY_KEY = "directory";
    private static final String STORAGE_TYPE_KEY = "storageType";

    Map<String, String> directoryMap = Map.of("cameronmathis","cameronmathis/", "courtneymathis","courtneymathis_files/", "connermathis", "connermathis_directory/");
    Map<String, StorageType> storageTypeMap = Map.of("cameronmathis", StorageType.GOOGLE_CLOUD_STORAGE, "courtneymathis", StorageType.AZURE_BLOB, "connermathis", StorageType.AMAZON_S3);

    public UserConfig getUserConfig(String username) {
        String directory = getConfig(username, DIRECTORY_KEY).getValue();
        StorageType storageType = StorageType.valueOf(getConfig(username, STORAGE_TYPE_KEY).getValue());
        return UserConfig.builder().username(username).directory(directory).storageType(storageType).build();
    }

    private Config getConfig(String username, String key) {
        String value;
        if (DIRECTORY_KEY.equals(key)) {
            value = directoryMap.getOrDefault(username, username);
        } else {
            value = String.valueOf(storageTypeMap.getOrDefault(username, StorageType.GOOGLE_CLOUD_STORAGE));
        }
        return new Config(username, key, value);
    }
}
