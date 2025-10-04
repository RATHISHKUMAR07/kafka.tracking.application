package dev.kafka.tracking.dispatch.message;


import dev.kafka.tracking.service.TrackingStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrackingStatusUpdated {
    UUID orderId;
    TrackingStatus status;
}
