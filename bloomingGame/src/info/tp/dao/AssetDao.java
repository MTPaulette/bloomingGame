package info.tp.dao;

import info.tp.model.Asset;

public interface AssetDao {
	
	Asset findAssetById(String name);
	void createAsset(Asset asset);
	//void sellAsset(Asset asset);

}
