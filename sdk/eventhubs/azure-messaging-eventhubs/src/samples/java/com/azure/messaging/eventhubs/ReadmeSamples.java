// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.eventhubs;

import com.azure.core.credential.TokenCredential;
import com.azure.core.util.IterableStream;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.messaging.eventhubs.models.CreateBatchOptions;
import com.azure.messaging.eventhubs.models.EventPosition;
import com.azure.messaging.eventhubs.models.PartitionEvent;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Class containing code snippets that will be injected to README.md.
 */
public class ReadmeSamples {

    /**
     * Code sample for creating a synchronous Event Hub producer.
     */
    public void createSynchronousEventHubProducer() {
        // BEGIN: readme-sample-createSynchronousEventHubProducer
        // The credential used is DefaultAzureCredential because it combines commonly used credentials
        // in deployment and development and chooses the credential to used based on its running environment.
        // More information can be found at: https://learn.microsoft.com/java/api/overview/azure/identity-readme
        TokenCredential credential = new DefaultAzureCredentialBuilder()
            .build();

        // "<<fully-qualified-namespace>>" will look similar to "{your-namespace}.servicebus.windows.net"
        // "<<event-hub-name>>" will be the name of the Event Hub instance you created inside the Event Hubs namespace.
        EventHubProducerClient producer = new EventHubClientBuilder()
            .credential("<<fully-qualified-namespace>>", "<<event-hub-name>>",
                credential)
            .buildProducerClient();
        // END: readme-sample-createSynchronousEventHubProducer
    }

    /**
     * Code sample for using AAD authorization to create a client.
     */
    public void useAadAuthorization() {
        // BEGIN: readme-sample-useAadAuthorization
        // The credential used is DefaultAzureCredential because it combines commonly used credentials
        // in deployment and development and chooses the credential to used based on its running environment.
        // More information can be found at: https://learn.microsoft.com/java/api/overview/azure/identity-readme
        TokenCredential credential = new DefaultAzureCredentialBuilder()
            .build();

        // "<<fully-qualified-namespace>>" will look similar to "{your-namespace}.servicebus.windows.net"
        // "<<event-hub-name>>" will be the name of the Event Hub instance you created inside the Event Hubs namespace.
        EventHubProducerClient client = new EventHubClientBuilder()
            .credential("<<fully-qualified-namespace>>", "<<event-hub-name>>",
                credential)
            .buildProducerClient();
        // END: readme-sample-useAadAuthorization
    }

    /**
     * Code sample for publishing events.
     * @throws IllegalArgumentException if the event data is bigger than max batch size.
     */
    public void publishEvents() {
        // BEGIN: readme-sample-publishEvents
        // The credential used is DefaultAzureCredential because it combines commonly used credentials
        // in deployment and development and chooses the credential to used based on its running environment.
        // More information can be found at: https://learn.microsoft.com/java/api/overview/azure/identity-readme
        TokenCredential credential = new DefaultAzureCredentialBuilder()
            .build();

        EventHubProducerClient producer = new EventHubClientBuilder()
            .credential("<<fully-qualified-namespace>>", "<<event-hub-name>>",
                credential)
            .buildProducerClient();

        List<EventData> allEvents = Arrays.asList(new EventData("Foo"), new EventData("Bar"));
        EventDataBatch eventDataBatch = producer.createBatch();

        for (EventData eventData : allEvents) {
            if (!eventDataBatch.tryAdd(eventData)) {
                producer.send(eventDataBatch);
                eventDataBatch = producer.createBatch();

                // Try to add that event that couldn't fit before.
                if (!eventDataBatch.tryAdd(eventData)) {
                    throw new IllegalArgumentException("Event is too large for an empty batch. Max size: "
                        + eventDataBatch.getMaxSizeInBytes());
                }
            }
        }
        // send the last batch of remaining events
        if (eventDataBatch.getCount() > 0) {
            producer.send(eventDataBatch);
        }
        // END: readme-sample-publishEvents
    }

    /**
     * Code sample for publishing events to a specific partition.
     */
    public void publishEventsToPartition() {
        // BEGIN: readme-sample-publishEventsToPartition
        // The credential used is DefaultAzureCredential because it combines commonly used credentials
        // in deployment and development and chooses the credential to used based on its running environment.
        // More information can be found at: https://learn.microsoft.com/java/api/overview/azure/identity-readme
        TokenCredential credential = new DefaultAzureCredentialBuilder()
            .build();

        EventHubProducerClient producer = new EventHubClientBuilder()
            .credential("<<fully-qualified-namespace>>", "<<event-hub-name>>",
                credential)
            .buildProducerClient();

        CreateBatchOptions options = new CreateBatchOptions().setPartitionId("0");
        EventDataBatch batch = producer.createBatch(options);

        // Add events to batch and when you want to send the batch, send it using the producer.
        producer.send(batch);
        // END: readme-sample-publishEventsToPartition
    }

    /**
     * Code sample for publishing events with a partition key.
     */
    public void publishEventsWithPartitionKey() {
        // BEGIN: readme-sample-publishEventsWithPartitionKey
        // The credential used is DefaultAzureCredential because it combines commonly used credentials
        // in deployment and development and chooses the credential to used based on its running environment.
        // More information can be found at: https://learn.microsoft.com/java/api/overview/azure/identity-readme
        TokenCredential credential = new DefaultAzureCredentialBuilder()
            .build();

        EventHubProducerClient producer = new EventHubClientBuilder()
            .credential("<<fully-qualified-namespace>>", "<<event-hub-name>>",
                credential)
            .buildProducerClient();

        CreateBatchOptions batchOptions = new CreateBatchOptions().setPartitionKey("grouping-key");
        EventDataBatch eventDataBatch = producer.createBatch(batchOptions);

        // Add events to batch and when you want to send the batch, send it using the producer.
        producer.send(eventDataBatch);
        // END: readme-sample-publishEventsWithPartitionKey
    }

    /**
     * Code sample for consuming events from a specific partition.
     */
    public void consumeEventsFromPartition() {
        // BEGIN: readme-sample-consumeEventsFromPartition
        EventHubConsumerAsyncClient consumer = new EventHubClientBuilder()
            .credential("<<fully-qualified-namespace>>", "<<event-hub-name>>",
                new DefaultAzureCredentialBuilder().build())
            .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
            .buildAsyncConsumerClient();

        // Receive newly added events from partition with id "0". EventPosition specifies the position
        // within the Event Hub partition to begin consuming events.
        consumer.receiveFromPartition("0", EventPosition.latest()).subscribe(event -> {
            // Process each event as it arrives.
        });
        // add sleep or System.in.read() to receive events before exiting the process.
        // END: readme-sample-consumeEventsFromPartition
    }

    /**
     * Code sample for consuming events from synchronous client.
     */
    public void consumeEventsFromPartitionUsingSyncClient() {
        // BEGIN: readme-sample-consumeEventsFromPartitionUsingSyncClient
        // The credential used is DefaultAzureCredential because it combines commonly used credentials
        // in deployment and development and chooses the credential to used based on its running environment.
        // More information can be found at: https://learn.microsoft.com/java/api/overview/azure/identity-readme
        TokenCredential credential = new DefaultAzureCredentialBuilder()
            .build();

        EventHubConsumerClient consumer = new EventHubClientBuilder()
            .credential("<<fully-qualified-namespace>>", "<<event-hub-name>>",
                credential)
            .consumerGroup(EventHubClientBuilder.DEFAULT_CONSUMER_GROUP_NAME)
            .buildConsumerClient();

        String partitionId = "<< EVENT HUB PARTITION ID >>";

        // Get the first 15 events in the stream, or as many events as can be received within 40 seconds.
        IterableStream<PartitionEvent> events = consumer.receiveFromPartition(partitionId, 15,
            EventPosition.earliest(), Duration.ofSeconds(40));
        for (PartitionEvent event : events) {
            System.out.println("Event: " + event.getData().getBodyAsString());
        }
        // END: readme-sample-consumeEventsFromPartitionUsingSyncClient
    }

    /**
     * Code sample for using Event Processor to consume events.
     * @throws InterruptedException if the thread is interrupted.
     */
    public void consumeEventsUsingEventProcessor() throws InterruptedException {
        // BEGIN: readme-sample-consumeEventsUsingEventProcessor
        // The credential used is DefaultAzureCredential because it combines commonly used credentials
        // in deployment and development and chooses the credential to used based on its running environment.
        // More information can be found at: https://learn.microsoft.com/java/api/overview/azure/identity-readme
        TokenCredential credential = new DefaultAzureCredentialBuilder()
            .build();

        EventProcessorClient eventProcessorClient = new EventProcessorClientBuilder()
            .consumerGroup("<< CONSUMER GROUP NAME >>")
            .credential("<<fully-qualified-namespace>>", "<<event-hub-name>>",
                credential)
            .checkpointStore(new SampleCheckpointStore())
            .processEvent(eventContext -> {
                System.out.println("Partition id = " + eventContext.getPartitionContext().getPartitionId() + " and "
                    + "sequence number of event = " + eventContext.getEventData().getSequenceNumber());
            })
            .processError(errorContext -> {
                System.out
                    .println("Error occurred while processing events " + errorContext.getThrowable().getMessage());
            })
            .buildEventProcessorClient();

        // This will start the processor. It will start processing events from all partitions.
        eventProcessorClient.start();

        // (for demo purposes only - adding sleep to wait for receiving events)
        TimeUnit.SECONDS.sleep(2);

        // This will stop processing events.
        eventProcessorClient.stop();
        // END: readme-sample-consumeEventsUsingEventProcessor
    }
}

