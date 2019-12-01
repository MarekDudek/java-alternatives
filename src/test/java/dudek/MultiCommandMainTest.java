package dudek;

import dudek.commands.Install;
import dudek.commands.JInfo;
import org.junit.jupiter.api.Test;
import picocli.CommandLine;

import static org.assertj.core.api.Assertions.assertThat;

final class MultiCommandMainTest {

    @Test
    void install_11() {
        // given
        final Object command = new Install();
        final CommandLine cmd = new CommandLine(command);
        final String[] args = {"/lib/jvm/jdk-11.0.5/", "100"};
        // when
        final int code = cmd.execute(args);
        // then
        assertThat(code).isEqualTo(0);
    }

    @Test
    void jinfo_file_11() {
        // given
        final Object command = new JInfo();
        final CommandLine cmd = new CommandLine(command);
        final String[] args = {"/lib/jvm/jdk-11.0.5/", "jdk-11", "100"};
        // when
        final int code = cmd.execute(args);
        // then
        assertThat(code).isEqualTo(0);
    }
}
