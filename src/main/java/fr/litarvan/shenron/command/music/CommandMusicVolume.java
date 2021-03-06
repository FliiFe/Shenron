package fr.litarvan.shenron.command.music;

import fr.litarvan.krobot.command.CommandContext;
import fr.litarvan.krobot.command.CommandHandler;
import fr.litarvan.krobot.command.SuppliedArgument;
import fr.litarvan.krobot.util.Dialog;
import fr.litarvan.shenron.MusicPlayer;
import java.util.Map;
import javax.inject.Inject;
import org.jetbrains.annotations.NotNull;

public class CommandMusicVolume implements CommandHandler
{
    @Inject
    private MusicPlayer player;

    @Override
    public void handle(@NotNull CommandContext context, @NotNull Map<String, SuppliedArgument> args) throws Exception
    {
        if (args.containsKey("value"))
        {
           player.setVolume(args.get("value").getAsNumber());
        }

        context.sendMessage(Dialog.info("Volume", player.getVolume() + "%"));
    }
}
