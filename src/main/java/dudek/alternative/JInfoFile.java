package dudek.alternative;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

import java.util.List;

@Builder
@EqualsAndHashCode
@ToString
public final class JInfoFile {

    @NonNull
    public final String name;

    @NonNull
    public final String alias;

    public final int priority;

    @NonNull
    public final List<Alternative> alternatives;
}
