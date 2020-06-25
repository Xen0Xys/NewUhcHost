package fr.xen0xys.newuhchost;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.InputStream;

public class TranslateLoader {
    private final NewUhcHost plugin;

    private final File configFile;
    private FileConfiguration config = null;
    private final String filename;

    public TranslateLoader(NewUhcHost plugin)
    {
        this.plugin = plugin;
        this.filename = "languages/" + plugin.getConfig().get("language").toString() + ".yml";
        this.configFile = new File(this.plugin.getDataFolder(), filename);
        this.reload();
        this.saveDefault();
    }

    public void reload()
    {
        this.config = YamlConfiguration.loadConfiguration(this.configFile);

        InputStream defaultConfigStream = this.plugin.getResource(filename);
        if (defaultConfigStream != null)
        {
            YamlConfiguration defaultConfig = YamlConfiguration.loadConfiguration(defaultConfigStream);
            this.config.setDefaults(defaultConfig);
        }
    }

    public void saveDefault()
    {
        if (!this.configFile.exists())
        {
            this.plugin.saveResource(filename, false);
        }
    }

    public String getCaption(String name)
    {
        return this.getCaption(name, false);
    }

    public String getCaption(String name, boolean color)
    {
        String caption = this.config.getString(name);
        if (caption == null)
        {
            this.plugin.getLogger().warning("Missing caption: " + name);
            caption = "&c[missing caption]";
        }

        if (color)
        {
            caption = ChatColor.translateAlternateColorCodes('&', caption);
        }
        return caption;
    }
}