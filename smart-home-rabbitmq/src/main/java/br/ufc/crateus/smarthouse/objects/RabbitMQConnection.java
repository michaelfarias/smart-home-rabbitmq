package br.ufc.crateus.smarthouse.objects;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;

import br.ufc.crateus.smarthouse.objects.interfaces.ObjectsInterface;

public class RabbitMQConnection {
	private ConnectionFactory factory;
	private final Connection CONNECTION;
	private final Channel CHANNEL;

	public RabbitMQConnection() throws IOException, TimeoutException {
		factory = new ConnectionFactory();
		CONNECTION = factory.newConnection("localhost");
		CHANNEL = CONNECTION.createChannel();
	}

	public void toProduce(String message, String exchangeName) {

		try {
			CHANNEL.exchangeDeclare(exchangeName, "fanout");
			CHANNEL.basicPublish(exchangeName, "", null, message.getBytes());
//			System.out.println(" [x] Sent '" + message + "'");
		} catch (Exception e) {

		}
	}

	public void consume(ObjectsInterface obj, String exchangeName) throws IOException, TimeoutException {

		CHANNEL.exchangeDeclare(exchangeName, "fanout");
		String queueName = CHANNEL.queueDeclare().getQueue();

		CHANNEL.queueBind(queueName, exchangeName, "");

//		System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

		DeliverCallback deliverCallback = (consumerTag, delivery) -> {

			String message = new String(delivery.getBody(), "UTF-8");
//			System.out.println(" [x] Received '" + message + "'");
			obj.run(message);
		};

		CHANNEL.basicConsume(queueName, true, deliverCallback, consumerTag -> {

		});
	}
}
