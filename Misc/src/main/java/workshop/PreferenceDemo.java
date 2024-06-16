package workshop;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;

public class PreferenceDemo {

    public static void main(String[] args) throws BackingStoreException {
        Preferences root = Preferences.userRoot();
        Preferences air = root.node("air");
        air.put("hello", "duke");
        air.flush();
        System.out.println(air.get("hell", "-"));
    }
}
