package com.server.bankgui;

import com.server.bankgui.events.GuiClick;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

public final class Bankgui extends JavaPlugin {

    public Inventory guiInventory;

    @Override
    public void onEnable() {
        // Plugin startup logic
        guiInventory = Bukkit.createInventory(null,36,"Banking");
        populateInventory();

        this.getServer().getPluginManager().registerEvents(new GuiClick(this), this);


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void populateInventory() {
        //close menu
        ItemStack close = new ItemStack(Material.BARRIER);
        ItemMeta closeMeta = close.getItemMeta();
        closeMeta.setDisplayName("Close Menu");
        close.setItemMeta(closeMeta);
        guiInventory.setItem(31, close);

        //

    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if (!label.equalsIgnoreCase("openbank")) return false;
        player.openInventory(this.guiInventory);

        return false;
    }
}
