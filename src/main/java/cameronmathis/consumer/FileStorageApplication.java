package cameronmathis.consumer;

import cameronmathis.service.StorageService;

public class FileStorageApplication implements Consumer {

    private final StorageService storageService;

    public FileStorageApplication(StorageService storageService) {
        this.storageService = storageService;
    }

    @Override
    public byte[] downloadFile(String path) {
        return this.storageService.downloadFile(path);
    }
}