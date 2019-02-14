package com.ocean.example.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author kevin.jiang
 * @create 2019-01-25
 **/
public class SubDemo2 {

    public static void main(String[] args) throws InterruptedException {
        String topic = "$share/group/test_topic";
        int qos = 1;
        String broker = "tcp://127.0.0.1:1883";
        String clientId = "C5";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            MqttClient sampleClient = new MqttClient(broker, clientId, persistence);
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Receiving message: ");
            Thread.sleep(3000L);
            new Thread() {
                @Override
                public void run() {
                    try {
                        sampleClient.subscribe(topic, qos, new IMqttMessageListener(){
                            @Override
                            public void messageArrived(String topic, MqttMessage message)
                                    throws Exception {
                                System.err.println("2=" + new String(message.getPayload()));
                            }
                        });
                    } catch (MqttException e) {
                        e.printStackTrace();
                    }
                }
            };

        } catch (MqttException me) {
            me.printStackTrace();
        }
    }

}
