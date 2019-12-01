package dudek.commands;

import dudek.alternative.AlternativeOps;
import dudek.alternative.JInfoFileOps;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.nio.file.Paths;
import java.util.stream.Stream;

import static java.lang.System.out;
import static java.util.stream.Collectors.toList;

@Command(name = "jinfo", mixinStandardHelpOptions = true)
public class JInfo implements Runnable {

    @Parameters(index = "0")
    private File jdk;

    @Parameters(index = "1")
    private String alias;

    @Parameters(index = "2")
    private int priority;

    @Override
    public void run() {

        final var bin = Paths.get(jdk.getPath(), "bin").toFile();
        final var files = bin.listFiles();

        final var executables = Stream.of(files).filter(File::canExecute);
        final var alternatives = executables.map(e -> AlternativeOps.fromPath(e, priority)).collect(toList());

        final var file = JInfoFileOps.fromPath(jdk, alias, alternatives, priority);
        final var string = JInfoFileOps.jinfoFile(file);

        out.println(string);
    }
}
