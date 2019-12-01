package dudek;

import org.junit.jupiter.api.Test;

final class JavaAlternativesMainTest {

    // JDKs/JREs

    private static final String JDK_8 = "/lib/jvm/jdk1.8.0_221/";
    private static final String JDK_8_PRIORITY = "200";

    private static final String JDK_11 = "/lib/jvm/jdk-11.0.5/";
    private static final String JDK_11_PRIORITY = "100";

    private static final String GRAAL_11 = "/lib/jvm/graalvm-ee-java11-19.3.0/";
    private static final String GRAAL_11_PRIORITY = "150";

    // commands

    private static final String INSTALL = "install";
    private static final String JINFO = "jinfo";

    @Test
    void install_8() {
        final String[] args = {INSTALL, JDK_8, JDK_8_PRIORITY};
        JavaAlternativesMain.main(args);
    }

    @Test
    void jinfo_file_8() {
        final String[] args = {JINFO, JDK_8, "jdk-8", JDK_8_PRIORITY};
        JavaAlternativesMain.main(args);
    }

    @Test
    void install_11() {
        final String[] args = {INSTALL, JDK_11, JDK_11_PRIORITY};
        JavaAlternativesMain.main(args);
    }

    @Test
    void jinfo_file_11() {
        final String[] args = {JINFO, JDK_11, "jdk-11", JDK_11_PRIORITY};
        JavaAlternativesMain.main(args);
    }

    @Test
    void install_graal_19_3_0() {
        final String[] args = {INSTALL, GRAAL_11, GRAAL_11_PRIORITY};
        JavaAlternativesMain.main(args);
    }

    @Test
    void jinfo_file_graal_19_3_0() {
        final String[] args = {JINFO, GRAAL_11, "graal-19_3_0", GRAAL_11_PRIORITY};
        JavaAlternativesMain.main(args);
    }
}
