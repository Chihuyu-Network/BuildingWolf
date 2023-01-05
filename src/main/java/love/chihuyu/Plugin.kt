package love.chihuyu

import love.chihuyu.commands.CommandHideAll
import love.chihuyu.commands.CommandShowAll
import love.chihuyu.visibility.VisibilityManager
import org.bukkit.ChatColor
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class Plugin : JavaPlugin(), Listener {

    companion object {
        lateinit var plugin: JavaPlugin
        val prefix = "${ChatColor.GREEN}[建築人狼]${ChatColor.RESET}"
    }

    init {
        plugin = this
    }

    override fun onEnable() {
        CommandHideAll.main.register()
        CommandShowAll.main.register()

        server.pluginManager.registerEvents(this, this)
        server.pluginManager.registerEvents(VisibilityManager, this)
    }
}