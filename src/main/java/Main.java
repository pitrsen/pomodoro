import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends Application {

    @Override
    public void start(Stage stage) {
//        addTrayIcon();
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    private void addTrayIcon() {
        TrayIcon trayIcon = null;
        Image image = null;
        if (SystemTray.isSupported()) {
            // get the SystemTray instance
            SystemTray tray = SystemTray.getSystemTray();
            // load an image
            image = Toolkit.getDefaultToolkit().getImage("path/image.gif");
            // create a action listener to listen
            ActionListener actionListener = new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // execute action of the JavaFx application
                }
            };
            // creating a popup-menuimage
            PopupMenu popupMenu = new PopupMenu();
            // creating menu item for the default action
            MenuItem menuItem = new MenuItem();
            menuItem.addActionListener(actionListener);
            popupMenu.add(menuItem);
            /// ... add others item
            trayIcon = new TrayIcon(image, "System Tray Demo", popupMenu);
            // set the Tray Icon
            trayIcon.addActionListener(actionListener);
            try {
                tray.add(trayIcon);
            } catch (AWTException exception) {
                System.err.println(exception);
            }

        } else {
            // disable System tray option in your App or
            // perform other functionality
        }
        if (trayIcon != null) {
            trayIcon.setImage(image);
        }
    }

    public static void main(String[] args) {
        launch();
    }

}