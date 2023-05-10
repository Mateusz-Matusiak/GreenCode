package pl.ingsolution.greencode.atm.service.dtos;

import java.util.Objects;

public record Task(
        Integer region,
        RequestType requestType,
        Integer atmId
) implements Comparable<Task> {

    private static int compareRegion(Integer thisRegion, Integer otherRegion) {
        return thisRegion.compareTo(otherRegion);
    }

    private static int compareRequestType(RequestType thisRequest, RequestType otherRequest) {
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
