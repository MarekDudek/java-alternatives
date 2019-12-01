package dudek.commands;

import picocli.CommandLine.Command;

@Command(subcommands = {Install.class, JInfo.class})
public class TopCommand implements Runnable {

    @Override
    public void run() {
        // intentionally left blank
    }
}
