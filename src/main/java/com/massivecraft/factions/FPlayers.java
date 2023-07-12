package com.massivecraft.factions;

import com.massivecraft.factions.zcore.persist.json.JSONFPlayers;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

public abstract class FPlayers {
    protected static FPlayers instance = getFPlayersImpl();

    public static FPlayers getInstance() {
        return instance;
    }

    private static FPlayers getFPlayersImpl() {
        return new JSONFPlayers();
    }

    public abstract void clean();

    public abstract Set<FPlayer> getOnlinePlayers();

    public abstract FPlayer getByPlayer(Player player);

    public abstract Collection<FPlayer> getAllFPlayers();

    public abstract void forceSave();

    public abstract void forceSave(boolean sync);

    public abstract FPlayer getByOfflinePlayer(OfflinePlayer player);

    public abstract FPlayer getById(String string);

    public abstract CompletableFuture<Boolean> load();
}