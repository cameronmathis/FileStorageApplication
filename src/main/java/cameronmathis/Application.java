package cameronmathis;

import cameronmathis.fx.FileStorageApplicationFX;

import java.awt.*;

public class Application {

    private static final String APPLICATION_NAME = "File Storage Application";
    private static final String APPLICATION_ICON = "/images/icon.png";

    public static void main(String[] args) {
        System.setProperty("apple.awt.application.name", APPLICATION_NAME);

        if (Taskbar.isTaskbarSupported()) {
            Taskbar taskbar = Taskbar.getTaskbar();

            if (taskbar.isSupported(Taskbar.Feature.ICON_IMAGE)) {
                final Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
                Image image = defaultToolkit.getImage(Application.class.getResource(APPLICATION_ICON));
                taskbar.setIconImage(image);

            }
        }

        FileStorageApplicationFX.main(args);
    }
}