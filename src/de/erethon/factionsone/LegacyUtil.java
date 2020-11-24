/*
 * Copyright (C) 2015-2018 Daniel Saukel.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */
package de.erethon.factionsone;

import java.util.HashSet;
import java.util.Set;
import org.bukkit.Bukkit;
import org.bukkit.Material;

/**
 * Workarounds to support API versions 1.7.10 - 1.13 and hopefully higher. For internal usage.
 *
 * @author Daniel Saukel
 */
public class LegacyUtil {

    public static String version = Bukkit.getServer().getVersion().split("\\(MC: ")[1].split("\\)")[0];

    public static boolean is1_7 = version.equals("1.7.9") || version.equals("1.7.10");
    public static boolean is1_8 = version.equals("1.8") || version.matches("1.8.*");
    public static boolean is1_13 = !version.matches("(^|.*[^\\.\\d])1\\.1[0-2]([^\\d].*|$)") && !version.matches("(^|.*[^\\.\\d])1\\.[0-9]([^\\d].*|$)");

    public static final Material COMMAND_BLOCK = Material.valueOf(is1_13 ? "COMMAND_BLOCK" : "COMMAND");
    public static final Material LAVA = Material.valueOf(is1_13 ? "LAVA" : "STATIONARY_LAVA");
    public static final Material WATER = Material.valueOf(is1_13 ? "WATER" : "STATIONARY_WATER");
    public static final Material ENCHANTING_TABLE = Material.valueOf(is1_13 ? "ENCHANTING_TABLE" : "ENCHANTMENT_TABLE");
    public static final Material OAK_TRAPDOOR = Material.valueOf(is1_13 ? "OAK_TRAPDOOR" : "TRAP_DOOR");
    public static final Material OAK_FENCE_GATE = Material.valueOf(is1_13 ? "OAK_FENCE_GATE" : "FENCE_GATE");
    public static final Material FIRE_CHARGE = Material.valueOf(is1_13 ? "FIRE_CHARGE" : "FIREBALL");
    public static final Material FARMLAND = Material.valueOf(is1_13 ? "FARMLAND" : "SOIL");
    public static final Material END_PORTAL = Material.valueOf(is1_13 ? "END_PORTAL" : "ENDER_PORTAL_FRAME");
    public static final Material END_PORTAL_FRAME = Material.valueOf(is1_13 ? "END_PORTAL_FRAME" : "ENDER_PORTAL_FRAME");
    public static final Material NETHER_PORTAL = Material.valueOf(is1_13 ? "NETHER_PORTAL" : "PORTAL");
    public static final Set<Material> DOORS = new HashSet<>();
    public static final Set<Material> MATERIALS_WITH_HIGH_BLAST_RESISTANCE = new HashSet<>();

    static {
        DOORS.add(OAK_TRAPDOOR);
        DOORS.add(OAK_FENCE_GATE);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.AIR);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.BEDROCK);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(LAVA);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(WATER);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.OBSIDIAN);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(NETHER_PORTAL);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(END_PORTAL);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(END_PORTAL_FRAME);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(ENCHANTING_TABLE);
        MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.ENDER_CHEST);
        if (!is1_7) {
            DOORS.add(Material.IRON_TRAPDOOR);
            DOORS.add(Material.BIRCH_FENCE_GATE);
            DOORS.add(Material.SPRUCE_FENCE_GATE);
            DOORS.add(Material.JUNGLE_FENCE_GATE);
            DOORS.add(Material.ACACIA_FENCE_GATE);
            DOORS.add(Material.DARK_OAK_FENCE_GATE);
            MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(COMMAND_BLOCK);
            MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.BARRIER);
           /* if (!is1_8) {
                MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.STRUCTURE_BLOCK);
                MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.END_GATEWAY);
            }*/
        }
        if (!is1_13) {
            MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.LAVA);
            MATERIALS_WITH_HIGH_BLAST_RESISTANCE.add(Material.WATER);
        }
    }

    public static boolean isFence(Material material) {
        return material.name().endsWith("FENCE") || material.name().endsWith("FENCE_GATE");
    }

    public static boolean isGlassPane(Material material) {
        String name = material.name();
        return name.endsWith("GLASS_PANE") || name.equals("THIN_GLASS") || name.equals("IRON_BARS") || name.equals("IRON_FENCE");
    }

    public static boolean isLava(Material type) {
        return type.name().equals("STATIONARY_LAVA") || type == Material.LAVA;
    }

    public static boolean isWater(Material type) {
        return type.name().equals("STATIONARY_WATER") || type == Material.WATER;
    }

    public static boolean isLiquid(Material type) {
        return isLava(type) || isWater(type);
    }

}
