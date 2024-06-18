package web_bookbay;

public class AppSettings {
    private static AppSettings instance;
    private boolean darkMode = false;

    private AppSettings() {}

    public static AppSettings getInstance() {
        if (instance == null) {
            instance = new AppSettings();
        }
        return instance;
    }

    public boolean isDarkMode() {
        return darkMode;
    }

    public void setDarkMode(boolean darkMode) {
        this.darkMode = darkMode;
    }
}
