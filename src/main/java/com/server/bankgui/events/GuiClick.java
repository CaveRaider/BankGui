package com.server.bankgui.events;

import com.server.bankgui.Bankgui;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GuiClick implements Listener {

    public Bankgui plugin;

    public GuiClick(Bankgui plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void invClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        Inventory inv = e.getInventory();
        if (!inv.equals(plugin.guiInventory)) return;
        e.setCancelled(true);
        if (e.getCurrentItem() == null) return;
        ItemStack clickedItem = e.getCurrentItem();
        if (clickedItem.getType().equals(Material.BARRIER)) {
            player.closeInventory();
            return;
        }



    }

}
