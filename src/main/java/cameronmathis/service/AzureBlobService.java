package cameronmathis.service;

import cameronmathis.enums.StorageType;

public class AzureBlobService implements StorageService {

    @Override
    public byte[] downloadFile(String path) {
        System.out.printf("Downloading \"%s\" from %s.%n", path, StorageType.AZURE_BLOB);
        return new byte[0];
    }
}
