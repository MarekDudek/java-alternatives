package dudek.alternative;

import java.io.File;

public enum AlternativeOps {

    ;

    public static Alternative fromPath(final File e, final int p) {

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

    public static String install(final Alternative a) {
        return String.format("sudo update-alternatives --install %s %s %s %d", a.link, a.name, a.path, a.priority);
    }
}
