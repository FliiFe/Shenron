package fr.litarvan.shenron.command;

import fr.litarvan.krobot.command.CommandContext;
import fr.litarvan.krobot.command.CommandHandler;
import fr.litarvan.krobot.command.SuppliedArgument;
import java.util.Map;
import fr.litarvan.shenron.MessageSudo;
import org.jetbrains.annotations.NotNull;

public class CommandSimpleLink implements CommandHandler
{
    private String link;

    public CommandSimpleLink(String link)
    {
        this.link = link;
    }

    @Override
    public void handle(@NotNull CommandContext context, @NotNull Map<String, SuppliedArgument> args) throws Exception
    {
        MessageSudo.send(context.getUser(), context.getChannel(), link);
    }

    public String getLink()
    {
        return link;
    }
}
