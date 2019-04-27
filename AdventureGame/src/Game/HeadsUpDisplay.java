package Game;

import java.awt.image.BufferedImage;
import java.util.List;

public class HeadsUpDisplay {
	
	private Inventory inventory;
	private int health = 0;
	private static final int inventoryx_pos = 128;
	private static final int inventoryy_pos = 630;
	private static final int itemx_pos0 = 138;
	private static final int itemx_const = 96;
	private static final int itemy_pos = 642;
	private static final int heartx_pos0 = 138;
	private static final int heartx_const = 20;
	private static final int hearty_pos = 600;
	private List<BufferedImage> healthAssets;
	
	public BufferedImage getHealthAssets(int index) {
		return healthAssets.get(index);
	}

	public void setHealthAssets(List<BufferedImage> healthAssets) {
		this.healthAssets = healthAssets;
	}

	public static int getHeartxPos0() {
		return heartx_pos0;
	}

	public static int getHeartxConst() {
		return heartx_const;
	}

	public static int getHeartyPos() {
		return hearty_pos;
	}

	public static int getInventoryxPos() {
		return inventoryx_pos;
	}

	public static int getInventoryyPos() {
		return inventoryy_pos;
	}

	public static int getItemxPos0() {
		return itemx_pos0;
	}

	public static int getItemxConst() {
		return itemx_const;
	}

	public static int getItemyPos() {
		return itemy_pos;
	}

	
	public HeadsUpDisplay() {
		
	}
	
	public void setHealth(int health) {
		this.health = health;
	}
	
	public int getHealth() {
		return this.health;
	}
	
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Inventory getInventory() {
		return this.inventory;
	}
}
