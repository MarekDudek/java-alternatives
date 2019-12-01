package dudek;

import java.io.File;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.*;
import static java.util.Objects.isNull;

public class JavaAlternativesMain {

    public static void main(String[] args) {

        out.println("I help manage Java alternatives");

        if (args.length != 2) {
            err.println("Path to JDK's home and number required, exiting.");
            exit(1);
        }

        final var jdkPath = args[0];
        final File home = new File(jdkPath);

        if (!home.exists()) {
            err.printf("File '%s' does not exist!", jdkPath);
            exit(1);
        }
        if (!home.isDirectory()) {
            err.printf("File '%s' is not a directory", jdkPath);
            exit(1);
        }

        final var number = args[1];

        final int priority;
        try {
            priority = Integer.parseInt(number);
        } catch (final NumberFormatException e) {
            err.printf("Priority '%s' wasn't a number, %s, exiting.", number, e.getMessage());
            exit(1);
            return;
        }

        final File bin = Paths.get(home.getPath(), "bin").toFile();
        final File[] files = bin.listFiles();

        if (isNull(files)) {
            err.print("I/O error while reading 'bin' folder");
            exit(1);
        }

        final Stream<File> executables = Stream.of(files).filter(File::canExecute);
        final Stream<Alternative> alternatives = executables.map(e -> AlternativeOps.fromPath(e, priority));
        final Stream<String> commands = alternatives.map(AlternativeOps::install);

        commands.sorted().forEach(a -> out.printf("%s%n", a));
    }
}
