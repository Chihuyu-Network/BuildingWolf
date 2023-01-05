package love.chihuyu.commands

import dev.jorel.commandapi.CommandAPICommand
import dev.jorel.commandapi.CommandPermission
import dev.jorel.commandapi.executors.CommandExecutor
import love.chihuyu.Plugin.Companion.plugin
import love.chihuyu.Plugin.Companion.prefix
import love.chihuyu.visibility.VisibilityManager
import net.kyori.adventure.text.Component

object CommandHideAll {

    val main: CommandAPICommand = CommandAPICommand("hideall")
        .withPermission(CommandPermission.OP)
        .executes(
            CommandExecutor { sender, args ->
                VisibilityManager.shown = false
                VisibilityManager.vanishAll()
                plugin.server.broadcast(Component.text("$prefix プレイヤーが全員見えなくなりました"))
            }
        )
}
