package dudek;

import dudek.commands.TopCommand;
import picocli.CommandLine;

public class JavaAlternativesMain {

    public static void main(final String[] args) {
        final CommandLine cmd = new CommandLine(new TopCommand());
        cmd.execute(args);
    }
}
