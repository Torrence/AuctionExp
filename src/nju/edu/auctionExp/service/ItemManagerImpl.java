package nju.edu.auctionExp.service;

import nju.edu.auctionExp.dao.ItemDAO;
import nju.edu.auctionExp.model.Item;

public class ItemManagerImpl implements ItemManager {
	private ItemDAO itemDAO;

	/**
	 * save the title and imageUrl of the item, along with the id generated.
	 * 
	 
	public void saveItem(String title, String imageUrl) {
		if(this.findExample(title, imageUrl)){
			return;
		}
		
		int count = this.itemDao.findAll().size();
		
		String id = ((Integer)count).toString();
		
		this.itemDao.save(new Item(id, title, imageUrl));
	}*/
	
	public void saveItem(Item item) {
		this.itemDAO.save(item);
	}	

	public Item getItemById(String id) {
		return this.itemDAO.findById(id);
	}
	
	/**
	 * find whether the item has been in the database by checking if both of the
	 * title and imageUrl have been in the database.
	 */
	public boolean findExample(String title, String imageUrl) {
		Item item = new Item(title, imageUrl);
		return this.itemDAO.findByExample(item).size()>0;
	}
	
	public void setItemDAO(ItemDAO itemDAO) {
		this.itemDAO = itemDAO;
	}

	public ItemDAO getItemDAO() {
		return itemDAO;
	}



	

}
