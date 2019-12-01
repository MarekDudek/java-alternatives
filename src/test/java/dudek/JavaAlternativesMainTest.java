package dudek;

import org.junit.jupiter.api.Test;

final class JavaAlternativesMainTest {

    private static final String JDK_1_8_0_221 = "/lib/jvm/jdk1.8.0_221/";
    private static final String JDK_11_0_5 = "/lib/jvm/jdk-11.0.5/";

    private static final String INSTALL = "install";
    private static final String JINFO = "jinfo";

    @Test
    void install_8() {
        final String[] args = {INSTALL, JDK_1_8_0_221, "200"};
        JavaAlternativesMain.main(args);
    }

    @Test
    void install_11() {
        final String[] args = {INSTALL, JDK_11_0_5, "100"};
        JavaAlternativesMain.main(args);
    }

    @Test
    void jinfo_file_8() {
        final String[] args = {JINFO, JDK_1_8_0_221, "jdk-8", "200"};
        JavaAlternativesMain.main(args);
    }

    @Test
    void jinfo_file_11() {
        final String[] args = {JINFO, JDK_11_0_5, "jdk-11", "100"};
        JavaAlternativesMain.main(args);
    }
}
