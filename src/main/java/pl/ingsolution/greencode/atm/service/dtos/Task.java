package pl.ingsolution.greencode.atm.service.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public record Task(
        @Min(1) @Max(9999) int region,
        @NotNull RequestType requestType,
        @Min(1) @Max(9999) int atmId
) implements Comparable<Task> {

    private static int compareRegion(final Integer thisRegion, final Integer otherRegion) {
        return thisRegion.compareTo(otherRegion);
    }

    private static int compareRequestType(final RequestType thisRequest, final RequestType otherRequest) {
        return Math.negateExact(thisRequest.compareTo(otherRequest));
    }

    @Override
    public int compareTo(Task o) {
        if (this == o)
            return 0;

        return Objects.equals(this.region, o.region)
                ? compareRequestType(this.requestType, o.requestType)
                : compareRegion(this.region, o.region);
    }
}
