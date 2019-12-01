package dudek;

import java.io.File;

import static java.lang.String.format;

enum AlternativeOps {

    ;

    static Alternative fromPath(final File executable, final int priority) {

        final String name = executable.getName();
        final String link = format("/usr/bin/%s", name);
        final String path = executable.getPath();

        return Alternative.builder().
                link(link).
                name(name).
                path(path).
                priority(priority).
                build();
    }

    static String install(final Alternative a) {
        return format("sudo update-alternatives --install %s %s %s %d", a.link, a.name, a.path, a.priority);
    }
}
