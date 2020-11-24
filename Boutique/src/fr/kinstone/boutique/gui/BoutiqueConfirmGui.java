package fr.kinstone.boutique.gui;

import fr.kinstone.boutique.Main;
import fr.kinstone.boutique.enums.BoutiqueEnum;
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

public class BoutiqueConfirmGui implements InventoryProvider {

    @Getter
    static BoutiqueConfirmGui confirmGui;

    @Getter @Setter
    BoutiqueEnum boutiqueEnum;

    public BoutiqueConfirmGui(){confirmGui = this;};

    public BoutiqueConfirmGui(BoutiqueEnum boutiqueEnum){this.boutiqueEnum = boutiqueEnum;}

    public static SmartInventory confirmInventory(BoutiqueEnum boutiqueEnum){
        return SmartInventory.builder()
                .id("lol")
                .provider(new BoutiqueConfirmGui(boutiqueEnum))
                .size(3, 9)
                .title("Boutique - Confirmation")
                .build();
    }

    @Override
    public void init(Player player, InventoryContents inventoryContents) {

        inventoryContents.set(1,  2, ClickableItem.of(new ItemBuilder(Material.WOOL).setWoolColor(DyeColor.GREEN).setName("§aConfirmer ?").toItemStack(), e ->{
            Main.getInstance().getBoutiqueManager().buyItem(player, boutiqueEnum);
            player.closeInventory();
        }));
        inventoryContents.set(1, 4, ClickableItem.of(new ItemBuilder(Material.PAPER).setName(boutiqueEnum == null ? "§cErreur" : "§eAchat : " + boutiqueEnum.getName()).setLore("§ePrix : §c" + boutiqueEnum.getPrice()).toItemStack(), null));
        inventoryContents.set(1, 6, ClickableItem.of(new ItemBuilder(Material.WOOL).setWoolColor(DyeColor.RED).setName("§cAnnuler ?").toItemStack(), e ->
                player.closeInventory()));


    }

    @Override
    public void update(Player player, InventoryContents inventoryContents) {

    }
}
