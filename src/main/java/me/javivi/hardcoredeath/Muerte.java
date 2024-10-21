package me.javivi.hardcoredeath;

import java.util.Iterator;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;

public class Muerte implements Listener {
    public Muerte() {
    }

    @EventHandler
    public void almorir(PlayerDeathEvent e) {
        // Elimina los efectos de poción al morir (por si acaso, mitigo bugs)
        Iterator var2 = e.getEntity().getActivePotionEffects().iterator();
        while (var2.hasNext()) {
            PotionEffect effect = (PotionEffect) var2.next();
            e.getEntity().removePotionEffect(effect.getType());
        }

        // Envío mensaje en españoh (ya sé que está deprecated, callate callate)
        String mensajeMuerte = "El jugador " + e.getEntity().getName() + " ha muerto."; // Puedes cambiar este mensaje

        // Enviar mensaje a todos los jugadores online
        var2 = Bukkit.getOnlinePlayers().iterator();
        while (var2.hasNext()) {
            Player jugadores = (Player) var2.next();
            jugadores.sendMessage("§4" + mensajeMuerte);
            jugadores.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent("§4" + mensajeMuerte));
        }

        // Reinicio comida, niveles, hambre, sin un rasguño, sólo que sin xp.
        e.getEntity().setHealth(20.0);
        e.getEntity().setFoodLevel(20);
        e.getEntity().setLevel(0);
        // e.getEntity().setGameMode(GameMode.SPECTATOR);
    }

}
/*
Para lograr el efecto De Dedsafío, entre otros que hace que se pongan en espectador se pueden hacer dos cosas:
- 1. Habilito la línea 42
- 2. Hago el siguiente evento en CE:
  eventomuerte:
    type: player_death
    actions:
      default:
      - 'gamemode: SPECTATOR'
 */
