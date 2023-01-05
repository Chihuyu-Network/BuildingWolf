package love.chihuyu.commands

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.CommandPermission
import dev.jorel.commandapi.executors.CommandExecutor
import love.chihuyu.Plugin
import love.chihuyu.Plugin.Companion.prefix
import love.chihuyu.visibility.VisibilityManager
import net.kyori.adventure.text.Component

object CommandShowAll {

    val main: CommandAPICommand = CommandAPICommand("showall")
        .withPermission(CommandPermission.OP)
        .executes(
            CommandExecutor { sender, args ->
                VisibilityManager.shown = true
                VisibilityManager.appearAll()
                Plugin.plugin.server.broadcast(Component.text("$prefix プレイヤーが全員見えるようになりました"))
            }
        )
}