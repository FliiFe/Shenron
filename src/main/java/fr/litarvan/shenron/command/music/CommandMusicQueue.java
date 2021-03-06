package fr.litarvan.shenron.command.music;

import com.sedmelluq.discord.lavaplayer.track.AudioTrack;
import fr.litarvan.krobot.command.CommandContext;
import fr.litarvan.krobot.command.CommandHandler;
import fr.litarvan.krobot.command.SuppliedArgument;
import fr.litarvan.krobot.util.Dialog;
import fr.litarvan.krobot.util.Markdown;
import java.util.Map;
import javax.inject.Inject;
import fr.litarvan.shenron.Music;
import fr.litarvan.shenron.MusicPlayer;
import org.jetbrains.annotations.NotNull;

public class CommandMusicQueue implements CommandHandler
{
    @Inject
    private MusicPlayer player;

    @Override
    public void handle(@NotNull CommandContext context, @NotNull Map<String, SuppliedArgument> args) throws Exception
    {
        StringBuilder message = new StringBuilder();

        for (int i = 0; i < player.getQueue().size(); i++)
        {
            AudioTrack track = player.getQueue().get(i);
            message.append(i + 1).append(". ").append(Markdown.bold(track.getInfo().title)).append(" ").append(Music.parseTime(track.getDuration())).append("\n\n");
        }

        context.sendMessage(Dialog.info("File d'attente", message.toString()));
    }
}
