package org.testcontainers.utility;

import org.jetbrains.annotations.NotNull;

public class ComparableVersion implements Comparable<ComparableVersion> {

    private final String[] parts;

    public ComparableVersion(String version) {
        this.parts = version.split("\\.");
    }

    @Override
    public int compareTo(@NotNull ComparableVersion other) {
        for (int i=0; i<Math.min(this.parts.length, other.parts.length); i++) {
            Integer thisPart = Integer.valueOf(this.parts[i]);
            Integer otherPart = Integer.valueOf(other.parts[i]);
            if (thisPart > otherPart) {
                return 1;
            } else if (thisPart < otherPart) {
                return -1;
            }
        }

        return 0;
    }
}
