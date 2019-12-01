package dudek;

import java.io.File;

enum AlternativeOps {

    ;

    static Alternative fromPath(final File e, final int p) {

        final var n = e.getName();
        final var l = String.format("/usr/bin/%s", n);
        final var a = e.getPath();

        return Alternative.builder().
                link(l).
                name(n).
                path(a).
                priority(p).
                build();
    }

    static String install(final Alternative a) {
        return String.format("sudo update-alternatives --install %s %s %s %d", a.link, a.name, a.path, a.priority);
    }
}
