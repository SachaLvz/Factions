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

import com.massivecraft.factions.Board;
import com.massivecraft.factions.FLocation;
import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Faction;
import com.massivecraft.factions.struct.TerritoryAccess;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * API additions that are specific to FactionsOne.
 *
 * @author Daniel Saukel
 */
public class FactionsOneAPI {

    /**
     * @return All of the claims of the faction.
     */
    public static Set<FLocation> getFactionClaims(Faction faction) {
        Set<FLocation> claims = new HashSet<>();
        Iterator<Map.Entry<FLocation, TerritoryAccess>> iter = Board.flocationIds.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<FLocation, TerritoryAccess> entry = iter.next();
            if (entry.getValue().getHostFactionID().equals(faction.getId())) {
                claims.add(entry.getKey());
            }
        }
        return claims;
    }

    /**
     * Unclaims all of the land of the faction.
     */
    public static void unclaimAll(Faction faction) {
        Board.unclaimAll(faction.getId());
    }

    /**
     * @param uuid
     * A player's UUID
     * @return The FPlayer that has this UUID
     */
    public static FPlayer getFPlayer(UUID uuid) {
        return FPlayers.i.get(uuid.toString());
    }

}
