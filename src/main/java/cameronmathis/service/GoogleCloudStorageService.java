package cameronmathis.service;


import cameronmathis.enums.StorageType;

public class GoogleCloudStorageService implements StorageService {

    @Override
    public byte[] downloadFile(String path) {
        System.out.printf("Downloading \"%s\" from %s.%n", path, StorageType.GOOGLE_CLOUD_STORAGE);
        return new byte[0];
    }
}
