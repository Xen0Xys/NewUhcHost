package fr.xen0xys.newuhchost.enums;

import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;
import fr.xen0xys.newuhchost.Utils;
import fr.xen0xys.newuhchost.gamemodes.Host;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Collections;
import java.util.List;

public enum CustomGamemode {

    UHC(Utils.getTranslationString("uhc"), fr.xen0xys.newuhchost.gamemodes.uhc.UHC.class, new ItemStack(Material.GOLDEN_APPLE), Utils.getTranslationString("uhc_description"));

    private final String gamemode_name;
    private final Class<?> custom_host;
    private final ItemStack item;
    private final List<String> description;

    CustomGamemode(String gamemode_name, Class<? extends Host> custom_host, ItemStack item, String description){
        if(custom_host.isInstance(Host.class)){
            throw new ClassFormatException("Bad class");
        }
        this.gamemode_name = gamemode_name;
        this.custom_host = custom_host;
        this.item = item;
        this.description = Collections.singletonList(description);
    }

    public String getGamemodeName(){
        return this.gamemode_name;
    }

    public Class<?> getCustomHost() {
        return custom_host;
    }

    public ItemStack getItem() {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(this.gamemode_name);
        meta.setLore(description);
        item.setItemMeta(meta);
        return item;
    }

    public List<String> getDescription() {
        return description;
    }
}
