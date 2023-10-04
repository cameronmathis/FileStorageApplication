package cameronmathis.service;

import cameronmathis.enums.StorageType;

public class AmazonS3Service implements StorageService {

    @Override
    public byte[] downloadFile(String path) {
        System.out.printf("Downloading \"%s\" from %s.%n", path, StorageType.AMAZON_S3);
        return new byte[0];
    }
}
