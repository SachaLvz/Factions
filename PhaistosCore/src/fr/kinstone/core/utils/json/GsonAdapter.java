package fr.kinstone.core.utils.json;

import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Map;

public abstract class GsonAdapter<T> extends TypeAdapter<T> {

protected static Type seriType = new TypeToken<Map<String, Object>>(){}.getType();

	public abstract String getRaw(T t);

	public abstract T fromRaw(String string);
	
}
