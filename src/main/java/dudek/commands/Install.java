package dudek.commands;

import dudek.alternative.Alternative;
import dudek.alternative.AlternativeOps;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static dudek.alternative.JdkJre.JDK;
import static dudek.alternative.JdkJre.JRE;
import static java.lang.System.out;
import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toList;

@Command(name = "install", mixinStandardHelpOptions = true)
public class Install implements Runnable {

    @Parameters(index = "0")
    private File jdkHome;

    @Parameters(index = "1")
    private int priority;

    @Override
    public void run() {

        final var jdk = Paths.get(jdkHome.getPath(), "bin").toFile();
        final var jdkFiles = jdk.listFiles();
        final var jdkExecutables = Stream.of(jdkFiles).filter(File::canExecute);
        final var jdkAlternatives = jdkExecutables.map(e -> AlternativeOps.fromPath(e, priority, JDK)).collect(toList());

        final var jre = Paths.get(jdkHome.getPath(), "jre", "bin").toFile();
        final var jreFiles = nonNull(jre.listFiles()) ? jre.listFiles() : new File[]{};
        final var jreExecutables = Stream.of(jreFiles).filter(File::canExecute);
        final var jreAlternatives = jreExecutables.map(e -> AlternativeOps.fromPath(e, priority, JRE)).collect(toList());

        final List<Alternative> alternatives = new ArrayList<>();
        alternatives.addAll(jdkAlternatives);
        alternatives.addAll(jreAlternatives);

        final var commands = alternatives.stream().map(AlternativeOps::install);
        commands.sorted().forEach(a -> out.printf("%s%n", a));
    }
}
