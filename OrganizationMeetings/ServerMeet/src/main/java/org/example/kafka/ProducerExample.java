package org.example.kafka;
import org.apache.kafka.clients.producer.*;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ProducerExample {
    public static void sendMessageKafka(String str){
        //Сделать относительный путь

        String arg = "getting-started.properties";
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

            producer.send(
                    new ProducerRecord<>(topic, users, items),
                    (event, ex) -> {
                        if (ex != null)
                            ex.printStackTrace();
                    });

        producer.flush();
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