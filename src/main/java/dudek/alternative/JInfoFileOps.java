package dudek.alternative;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static java.lang.System.lineSeparator;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public enum JInfoFileOps {

    ;

    public static JInfoFile fromPath
            (
                    final File jdk,
                    final String alias,
                    final List<Alternative> alternatives,
                    int priority
            ) {

        final var name = jdk.getName();
        final var as = List.copyOf(alternatives);

        return JInfoFile.builder().
                name(name).
                alias(alias).
                alternatives(as).
                priority(priority).
                build();
    }

    public static String jinfoFile(final JInfoFile f) {

        final var ls = new ArrayList<String>();

        final var n = format("name=%s", f.name);
        ls.add(n);

        final var a = format("alias=%s", f.alias);
        ls.add(a);

        final var p = format("priority=%d", f.priority);
        ls.add(p);

        final var s = "section=main";
        ls.add(s);

        ls.add("");

        final var as = f.alternatives.stream().map(JInfoFileOps::alternative).collect(toList());
        ls.addAll(as);

        return ls.stream().collect(joining(lineSeparator()));
    }

    private static String alternative(final Alternative a) {

        final var n = a.name;
        final var l = a.path;
        final var j = jdkJre(a.jdkJre);

        return format("%s %s %s", j, n, l);
    }

    private static String jdkJre(final JdkJre jdkJre) {
        switch (jdkJre) {
            case JDK:
                return "jdk";
            case JRE:
                return "jre";
            default:
                return null;
        }
    }
}
