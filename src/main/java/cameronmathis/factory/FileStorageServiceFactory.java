package cameronmathis.factory;

import cameronmathis.enums.StorageType;
import cameronmathis.service.AmazonS3Service;
import cameronmathis.service.AzureBlobService;
import cameronmathis.service.GoogleCloudStorageService;
import cameronmathis.service.StorageService;

public class FileStorageServiceFactory {

    public StorageService getFileStorageService(StorageType storageType) {
        if (storageType == null) {
            return null;
        }

        if (storageType.equals(StorageType.AMAZON_S3)) {
            return new AmazonS3Service();

        } else if (storageType.equals(StorageType.AZURE_BLOB)) {
            return new AzureBlobService();

        } else if (storageType.equals(StorageType.GOOGLE_CLOUD_STORAGE)) {
            return new GoogleCloudStorageService();
        }

        return null;
    }
}
