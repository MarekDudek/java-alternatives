package dudek.alternative;

import java.io.File;

import static java.lang.String.format;

public enum AlternativeOps {

    ;

    public static Alternative fromPath(final File executable, final int priority, final JdkJre jdkJre) {

        final var name = executable.getName();
        final var link = format("/usr/bin/%s", name);
        final var path = executable.getPath();

        return Alternative.builder().
                link(link).
                name(name).
                path(path).
                priority(priority).
                jdkJre(jdkJre).
                build();
    }

    public static String install(final Alternative alternative) {
        return format("sudo update-alternatives --install %s %s %s %d", alternative.link, alternative.name, alternative.path, alternative.priority);
    }
}
