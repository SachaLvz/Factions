package fr.kinstone.boutique.manager;

import com.google.common.collect.Lists;
import fr.kinstone.boutique.enums.BoutiqueEnum;
import fr.kinstone.boutique.enums.BoutiqueType;
import fr.kinstone.boutique.gui.BoutiqueConfirmGui;
import fr.kinstone.boutique.profile.Profile;
import fr.kinstone.boutique.profile.ProfileManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.List;

public class BoutiqueManager {

      @Getter
      static BoutiqueManager boutiqueManager;

      @Getter
      BoutiqueConfirmGui confirmGui;

      public BoutiqueManager(){
          boutiqueManager = this;
          confirmGui = new BoutiqueConfirmGui();
      }


    public List<BoutiqueEnum> getBoutiqueEnumByType(BoutiqueType boutiqueType){

        List<BoutiqueEnum> boutiqueEnumList = Lists.newArrayList();
        BoutiqueEnum[] boutiqueArray;
        int i = (boutiqueArray = BoutiqueEnum.values()).length;

        for(int z = 0 ; z < i; z++){
            BoutiqueEnum boutiqueEnum = boutiqueArray[z];
            if(boutiqueEnum.getBoutiqueType().equals(boutiqueType)){
                boutiqueEnumList.add(boutiqueEnum);
            }
        }

        return boutiqueEnumList;

    }

    public void buyItem(Player player, BoutiqueEnum boutiqueEnum){

          Profile profile = ProfileManager.getInstance().getProfile(player.getName());

          if(boutiqueEnum == null){
              return;
          }

          if(profile.getPoints() < boutiqueEnum.getPrice()){

              player.sendMessage("§cVous n'avez pas assez de points !");
              return;

          }

          profile.setPoints(profile.getPoints() - boutiqueEnum.getPrice());

          if(boutiqueEnum.getBoutiqueType() == BoutiqueType.GRADES)
              Bukkit.getConsoleSender().sendMessage("/pex user "+ player.getName() + " " + boutiqueEnum.getCommand());
           else
              Bukkit.getConsoleSender().sendMessage("/" + boutiqueEnum.getCommand());

           String lang = boutiqueEnum.getBoutiqueType() == BoutiqueType.PERMISSIONS ? "la §c" : "le §c";
           player.sendMessage("§eVous avez bien acheté " + lang + boutiqueEnum.getBoutiqueType().name() + " " + boutiqueEnum.getName() + "§e pour le prix de §e" + boutiqueEnum.getPrice());


    }

}
