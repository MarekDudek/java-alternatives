package dudek;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.ToString;

@Builder
@ToString
@EqualsAndHashCode
final class Alternative {

    @NonNull
    public final String link;

    @NonNull
    public final String name;

    @NonNull
    public final String path;

    @NonNull
    public final int priority;

}
