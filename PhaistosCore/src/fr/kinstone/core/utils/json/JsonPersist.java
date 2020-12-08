package fr.kinstone.core.utils.json;

import java.io.File;

public interface JsonPersist {
	
	public File getFile();
	public void loadData();
	public void saveData(boolean sync);

}
