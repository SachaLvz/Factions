package fr.kinstone.core.utils.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;

import java.util.ArrayList;
import java.util.List;

public class JsonFramework {
	
	private List<JsonPersist> persist = new ArrayList<>();
	@Getter private Gson gson;
	
	public JsonFramework(JavaPlugin plugin) {
		this.gson = getGsonBuilder().create();
	}
	
	public void addPersist(JsonPersist persist) {
		this.persist.add(persist);
	}
	
	public void loadAllData() {
		for(JsonPersist persist : persist) {
			persist.loadData();
		}
	}
	
	public void saveAllData(boolean sync) {
		for(JsonPersist persist : persist) {
			persist.saveData(sync);
		}
	}
	
	  public GsonBuilder getGsonBuilder()
	  {
	    return new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().serializeNulls().excludeFieldsWithModifiers(new int[] { 128, 64 }).registerTypeAdapterFactory(EnumTypeAdapter.ENUM_FACTORY).registerTypeHierarchyAdapter(ItemStack.class, new ItemStackAdapter()).registerTypeAdapter(PotionEffect.class, new PotionEffectAdapter()).registerTypeAdapter(Location.class, new LocationAdapter());
	  }

}
