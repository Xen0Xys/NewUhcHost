package fr.xen0xys.newuhchost.guis;

import fr.xen0xys.newuhchost.enums.CustomGamemode;
import fr.xen0xys.newuhchost.enums.Language;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

public class GamemodeChoiceGUI extends GUI implements InventoryHolder {

    public GamemodeChoiceGUI(){
        super(9, Language.GAMEMODE_CHOICE.getText());
        this.fillInventory();
        setGamemodes();
    }

    private void setGamemodes(){
        for(int i = 0; i < CustomGamemode.values().length; i++){
            CustomGamemode[] gamemodes = CustomGamemode.values();
            this.getInventory().setItem(i, CustomGamemode.values()[i].getItem());
        }
    }

    public static void onClick(ItemStack item, Player player) {

    }
}
