package dudek.commands;

import dudek.alternative.AlternativeOps;
import dudek.alternative.JdkJre;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static dudek.alternative.JdkJre.JDK;
import static java.lang.System.out;

@Command(name = "install", mixinStandardHelpOptions = true)
public class Install implements Runnable {

    @Parameters(index = "0")
    private File jdk;

    @Parameters(index = "1")
    private int priority;

    @Override
    public void run() {

        final var bin = Paths.get(jdk.getPath(), "bin").toFile();
        final var files = bin.listFiles();

        final var executables = Stream.of(files).filter(File::canExecute);
        final var alternatives = executables.map(e -> AlternativeOps.fromPath(e, priority, JDK));
        final var commands = alternatives.map(AlternativeOps::install);

        commands.sorted().forEach(a -> out.printf("%s%n", a));
    }
}
