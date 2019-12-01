package dudek;

import dudek.commands.Install;
import dudek.commands.JInfo;
import picocli.CommandLine;

import static java.lang.System.exit;

public final class MultiCommandMain {

    public static void main(final String[] args) {

        final Object command1 = new Install();
        final Object command2 = new JInfo();

        final CommandLine cmd = new CommandLine(command2);
        final int code = cmd.execute(args);
        exit(code);
    }
}
