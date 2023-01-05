package love.chihuyu.visibility

import love.chihuyu.Plugin.Companion.plugin
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerJoinEvent

object VisibilityManager : Listener {

    var shown = true

    fun vanishAll() {
        plugin.server.onlinePlayers.forEach { viewer ->
            plugin.server.onlinePlayers.forEach { target ->
                viewer.hidePlayer(plugin, target)
                target.hidePlayer(plugin, viewer)
            }
        }
    }

    fun appearAll() {
        plugin.server.onlinePlayers.forEach { viewer ->
            plugin.server.onlinePlayers.forEach { target ->
                viewer.showPlayer(plugin, target)
                target.showPlayer(plugin, viewer)
            }
        }
    }

    @EventHandler
    fun onJoin(e: PlayerJoinEvent) {
        if (shown) {
            appearAll()
        } else {
            vanishAll()
        }
    }
}