package fr.kinstone.boutique.gui;

import fr.kinstone.boutique.Main;
import fr.kinstone.boutique.enums.BoutiqueType;
import fr.kinstone.boutique.profile.ProfileManager;
import fr.kinstone.boutique.utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.Getter;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class BoutiqueGui implements InventoryProvider {

    @Getter static SmartInventory inventory = SmartInventory.builder()
            .id("")
            .provider(new BoutiqueGui())
            .size(6, 9)
            .title("Boutique")
            .build();


    @Override
    public void init(Player player, InventoryContents contents) {

        contents.fillBorders(ClickableItem.empty(new ItemStack(Material.STAINED_GLASS_PANE)));

        int row = 2;
        int slot = 1;

        for(int i = 0; i < BoutiqueType.values().length; i++){

            BoutiqueType[] boutiqueType = BoutiqueType.values();
            BoutiqueType type = boutiqueType[i];

                contents.set(1, 4, ClickableItem.empty(new ItemBuilder(Material.SKULL_ITEM, 1, (short) 3).setName("§eInformations - §c" + player.getName()).setLore("", "§ePoint(s) : §c" + ProfileManager.getInstance().getProfile(player.getName()).getPoints()).toItemStack()));


            if(i + 2 == 6){
                row = 3;
                slot = 2;
            }

            slot++;

            if(slot == 4 && row == 2)
                slot++;
            contents.set(row, slot, ClickableItem.of(new ItemBuilder(type.getMaterial()).setName("§e" + type.getName()).toItemStack(), e -> {
                BoutiqueSelectedGui.selectInventory(type).open(player);
            }));


        }

        contents.set(5, 8, ClickableItem.of(new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 14).setName("§cFermer").setWoolColor(DyeColor.RED).toItemStack(), e -> {
           player.closeInventory();
        }));


     /*   contents.set(2, 3, ClickableItem.of(new ItemBuilder(Material.DIAMOND_PICKAXE).setName("§cKits").toItemStack(), null));
        contents.set(2, 4, ClickableItem.of(new ItemBuilder(Material.GOLD_BLOCK).setName("§eInformations - §c" + player.getName()).setLore("", "§ePoint(s) : §c" + ProfileManager.getInstance().getProfile(player.getName()).getPoints()).toItemStack(), null));
        contents.set(2, 5, ClickableItem.of(new ItemBuilder(Material.BLAZE_ROD).setName("§4Clés").toItemStack(), null));
        contents.set(2, 6, ClickableItem.of(new ItemBuilder(Material.MOB_SPAWNER).setName("§aSpawners").toItemStack(), null));
        contents.set(3, 3, ClickableItem.of(new ItemBuilder(Material.NETHER_STAR).setName("§1Booots").toItemStack(), null));
        contents.set(3, 4, ClickableItem.of(new ItemBuilder(Material.POTION).setName("§1Atouts").toItemStack(), null));
        contents.set(3, 5, ClickableItem.of(new ItemBuilder(Material.ENCHANTMENT_TABLE).setName("§3Commandes").toItemStack(), null));*/


    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
