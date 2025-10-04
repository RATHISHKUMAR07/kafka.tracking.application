package dev.kafka.tracking.handler;


import dev.kafka.tracking.dispatch.message.DispatchPreparing;
import dev.kafka.tracking.service.TrackingService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@RequiredArgsConstructor
public class DispatchTrackingHandler {

    @Autowired
    private final TrackingService trackingService;

    @KafkaListener(
            id = "dispatchTrackingConsumerClient",
            topics = "dispatch.tracking",
            groupId = "tracking.dispatch.tracking",
            containerFactory = "kafkaListenerContainerFactory"
    )
    public void listen(DispatchPreparing dispatchPreparing) throws Exception {
        try{
            trackingService.process(dispatchPreparing);
        }catch (Exception e){
            log.error("Process failure", e);
        }
    }


}
