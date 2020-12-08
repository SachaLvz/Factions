package fr.kinstone.boutique.gui;

import fr.kinstone.boutique.Main;
import fr.kinstone.boutique.enums.BoutiqueEnum;
import fr.kinstone.boutique.enums.BoutiqueType;
import fr.kinstone.boutique.manager.BoutiqueManager;
import fr.kinstone.boutique.utils.ItemBuilder;
import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class BoutiqueSelectedGui implements InventoryProvider {

    @Getter
    static BoutiqueSelectedGui boutiqueSelectedGui;

    @Setter
    private BoutiqueType boutiqueType;

    public BoutiqueSelectedGui(BoutiqueType boutiqueType){this.boutiqueType = boutiqueType;}

    static SmartInventory selectInventory(BoutiqueType boutiqueType){
        return SmartInventory.builder()
                .id("test")
                .provider(new BoutiqueSelectedGui(boutiqueType))
                .size(6, 9)
                .title("Boutique - " + boutiqueType)
                .build();
    }


    @Override
    public void init(Player player, InventoryContents inventoryContents) {

        inventoryContents.fillBorders(ClickableItem.empty(new ItemStack(Material.STAINED_GLASS_PANE)));

        int row = 2;
        int slot = 1;

        for(int i = 0; i < Main.getInstance().getBoutiqueManager().getBoutiqueEnumByType(boutiqueType).size(); i++){

            BoutiqueEnum boutiqueEnum =  Main.getInstance().getBoutiqueManager().getBoutiqueEnumByType(boutiqueType).get(i);

            if(i + 2 == 7){
                row = 3;
                slot = 1;
            }

            slot++;
                inventoryContents.set(row, slot, ClickableItem.of(new ItemBuilder(boutiqueEnum.getMaterial()).setName("§e" + boutiqueEnum.getName()).setLore("", "§ePrix : §c" + boutiqueEnum.getPrice()).hideAttribues(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS).toItemStack(), e -> {
                    BoutiqueConfirmGui.confirmInventory(boutiqueEnum).open(player);
                }));



        }

        inventoryContents.set(5, 8, ClickableItem.of(new ItemBuilder(Material.STAINED_GLASS_PANE, 1, (short) 14).setName("§cRetour").setWoolColor(DyeColor.RED).toItemStack(), e -> {
            BoutiqueGui.getInventory().open(player);
        }));

    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
