package org.example.kafka;
import org.apache.kafka.clients.producer.*;
import org.example.entity.Meeting;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ProducerExample {
    public static void sendMessageKafka(String str){
        String arg = "C:\\Users\\Pavel\\IdeaProjects\\ServerMeet\\src\\main\\java\\org\\example\\kafka\\getting-started.properties";
        Properties props = null;
        try {
            props = loadConfig(arg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        final String topic = "purchases";

        String users = "awalther";
        String items = str;
        Producer<String, String> producer = new KafkaProducer<>(props);

        final Long numMessages = 1L;
        for (Long i = 0L; i < numMessages; i++) {
            producer.send(
                    new ProducerRecord<>(topic, users, items),
                    (event, ex) -> {
                        if (ex != null)
                            ex.printStackTrace();
                        else
                            System.out.printf("Produced event to topic %s: key = %-10s value = %s%n", topic, users, items);
                    });
        }

        producer.flush();
        System.out.printf("%s events were produced to topic %s%n", numMessages, topic);
        producer.close();
    }

    /**
     * We'll reuse this function to load properties from the Consumer as well
     */
    public static Properties loadConfig(final String configFile) throws IOException {
        if (!Files.exists(Paths.get(configFile))) {
            throw new IOException(configFile + " not found.");
        }
        final Properties cfg = new Properties();
        try (InputStream inputStream = new FileInputStream(configFile)) {
            cfg.load(inputStream);
        }
        return cfg;
    }
}