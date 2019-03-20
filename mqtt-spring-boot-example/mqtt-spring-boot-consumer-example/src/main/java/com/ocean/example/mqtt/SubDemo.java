package com.ocean.example.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.IMqttMessageListener;
import org.eclipse.paho.client.mqttv3.MqttAsyncClient;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttCallbackExtended;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * @author kevin.jiang
 * @create 2019-01-25
 **/
public class SubDemo {

    public static void main(String[] args) throws InterruptedException {
        String topic = "$share/group/test_topic";
        String broker = "tcp://127.0.0.1:1883";
        String clientId = "C4";
        MemoryPersistence persistence = new MemoryPersistence();
        int qos = 1;
        try {
            MqttAsyncClient sampleClient = new MqttAsyncClient(broker, clientId, persistence);
            sampleClient.setCallback(new MqttCallbackExtended(){

                @Override
                public void connectComplete(boolean reconnect, String serverURI) {
                    try {
                        sampleClient.subscribe(topic, qos);
                    } catch (MqttException me) {
                        System.out.println("reason " + me.getReasonCode());
                        System.out.println("msg " + me.getMessage());
                        System.out.println("loc " + me.getLocalizedMessage());
                        System.out.println("cause " + me.getCause());
                        System.out.println("excep " + me);
                        me.printStackTrace();
                    }
                }

                @Override
                public void connectionLost(Throwable cause) {

                }

                @Override
                public void messageArrived(String topic, MqttMessage message) throws Exception {
                    System.err.println("1=" + message.toString());
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {

                }
            });
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setCleanSession(true);
            System.out.println("Connecting to broker: " + broker);
            sampleClient.connect(connOpts);
            System.out.println("Connected");
            System.out.println("Receiving message: ");

        } catch (MqttException me) {

        }
    }
}
