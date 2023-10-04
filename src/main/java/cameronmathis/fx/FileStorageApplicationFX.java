package cameronmathis.fx;

import cameronmathis.client.ConfigClient;
import cameronmathis.consumer.Consumer;
import cameronmathis.consumer.FileStorageApplication;
import cameronmathis.factory.FileStorageServiceFactory;
import cameronmathis.model.UserConfig;
import cameronmathis.service.StorageService;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class FileStorageApplicationFX extends Application {

    private static final int DEFAULT_WIDTH = 1280;
    private static final int DEFAULT_HEIGHT = 720;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Pane(), DEFAULT_WIDTH, DEFAULT_HEIGHT);
        stage.setTitle("File Storage Application");
        stage.setScene(scene);

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(40, 40, 40, 40));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        columnOneConstraints.setHalignment(HPos.RIGHT);
        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200, 200, Double.MAX_VALUE);
        columnTwoConstrains.setHgrow(Priority.ALWAYS);
        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);

        Label headerLabel = new Label("File Storage Application");
        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        gridPane.add(headerLabel, 0, 0, 2, 1);
        GridPane.setHalignment(headerLabel, HPos.CENTER);
        GridPane.setMargin(headerLabel, new Insets(20, 0, 20, 0));

        Label usernameLabel = new Label("Username: ");
        gridPane.add(usernameLabel, 0, 1);
        TextField usernameField = new TextField("cameronmathis");
        usernameField.setPrefHeight(40);
        gridPane.add(usernameField, 1, 1);

        Label filenameLabel = new Label("Filename: ");
        gridPane.add(filenameLabel, 0, 2);
        TextField filenameField = new TextField("text.txt");
        filenameField.setPrefHeight(40);
        gridPane.add(filenameField, 1, 2);

        Button download = new Button("Download");
        download.setPrefHeight(40);
        download.setDefaultButton(true);
        download.setPrefWidth(100);
        gridPane.add(download, 0, 3, 2, 1);
        GridPane.setHalignment(download, HPos.CENTER);
        GridPane.setMargin(download, new Insets(20, 0, 20, 0));

        download.setOnAction(e -> {
            String username = usernameField.getText();
            String filename = filenameField.getText();
            ConfigClient configClient = new ConfigClient();
            UserConfig userConfig = configClient.getUserConfig(username);
            FileStorageServiceFactory fileStorageServiceFactory = new FileStorageServiceFactory();
            StorageService storageService = fileStorageServiceFactory.getFileStorageService(userConfig.getStorageType());
            Consumer fileStorageApplication = new FileStorageApplication(storageService);
            fileStorageApplication.downloadFile(userConfig.getDirectory() + filename);
        });

        gridPane.prefHeightProperty().bind(stage.getScene().heightProperty());
        gridPane.prefWidthProperty().bind(stage.getScene().widthProperty());
        VBox viewBox = new VBox(gridPane);
        stage.getScene().setRoot(viewBox);
        stage.show();
    }
}