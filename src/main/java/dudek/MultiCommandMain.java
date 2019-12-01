package dudek;

import dudek.commands.Install;
import picocli.CommandLine;

import static java.lang.System.exit;

public final class MultiCommandMain {

    public static void main(final String[] args) {

        final CommandLine cmd = new CommandLine(new Install());
        final int code = cmd.execute(args);
        exit(code);
    }
}
