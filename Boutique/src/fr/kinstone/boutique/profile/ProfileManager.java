package fr.kinstone.boutique.profile;

import com.google.gson.reflect.TypeToken;
import fr.kinstone.boutique.Main;
import fr.kinstone.boutique.utils.DiscUtil;
import fr.kinstone.boutique.utils.json.JsonPersist;
import lombok.Getter;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ProfileManager implements JsonPersist {

    @Getter
    public Map<String, Profile> profiles;
    @Getter public static ProfileManager instance;

    public ProfileManager() {
        this.profiles = new HashMap<>();
        instance = this;
    }

    @Override
    public File getFile() {return new File(Main.getInstance().getDataFolder(), "profiles.json");}

    @Override
    public void loadData() {

        String content = DiscUtil.readCatch(getFile());
        if (content == null) {
            return;
        }
        Map<String, Profile> profiles = (Map)Main.getInstance().getJsonFramework().getGson().fromJson(content, new TypeToken<Map<String, Profile>>(){}.getType());
        if ((profiles != null) && (!profiles.isEmpty())) {
            this.profiles.putAll(profiles);
        }

    }

    @Override
    public void saveData(boolean sync) {
        DiscUtil.writeCatch(getFile(), Main.getInstance().getJsonFramework().getGson().toJson(this.profiles), sync);
    }

    public Profile getProfile(String name) {
        return profiles.get(name);
    }
}
