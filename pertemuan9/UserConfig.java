package pertemuan9;

import java.io.Serializable;

public class UserConfig implements Serializable {
    private String username;
    private int fontSize;

    public UserConfig(String username, int fontSize) {
        this.username = username;
        this.fontSize = fontSize;
    }

    public String getUsername() {
        return username;
    }

    public int getFontSize() {
        return fontSize;
    }
}
