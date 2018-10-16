package com.jt.text.rabbitmq;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.ConsumerCancelledException;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.ShutdownSignalException;

public class TestRabbitMQ_2_work {
	private Connection conn;
	private String queueName = "queue_work";
	/**
	 * IP:端口号
	 * 用户名：密码：虚拟主机
	 * @throws IOException 
	 */
	@Before
	public void before() throws IOException{
		ConnectionFactory factory = new ConnectionFactory();
		factory.setHost("192.168.121.136");
		factory.setPort(5672);
		factory.setVirtualHost("/jt");
		factory.setUsername("jtadmin");
		factory.setPassword("jtadmin");
		conn = factory.newConnection();
	}
	@Test
	public void provide() throws IOException{
		//定义通道对象
		Channel channel = conn.createChannel();
		//定义队列
		channel.queueDeclare(queueName, false, false, false, null);
		//定义广播的消息
		String msg= "我是工作模式";
		//发送消息
		channel.basicPublish("", queueName, false, null, msg.getBytes());
		channel.close();
		conn.close();
		System.out.println("消息队列发送成功！！！！！！");
	}
	
	//定义消费者
	@Test
	public void consumer1() throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException{
		Channel channel = conn.createChannel();
		channel.queueDeclare(queueName, false, false, false, null);
		channel.basicQos(1);
		QueueingConsumer consumer = new QueueingConsumer(channel);
		channel.basicConsume(queueName, false,consumer);
		while(true){
			QueueingConsumer.Delivery delivery  = consumer.nextDelivery();
			String msg = new String(delivery.getBody());
			System.out.println("队列A获取消息："+msg);
			//deliveryTag队列下标位置
			//multiple是否批量返回
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), true);
		}
	}

	//定义消费者
	@Test
	public void consumer2() throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException{
		//定义通道
		Channel channel = conn.createChannel();

		//定义队列
		channel.queueDeclare("queue_work", false, false, false, null);

		//定义消费数  每次只能消费一条记录.当消息执行后需要返回ack确认消息 才能执行下一条
		channel.basicQos(1);

		//定义消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);

		//将队列和消费者绑定  false表示手动返回ack
		channel.basicConsume("queue_work", false, consumer);

		while(true){
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String msg = new String(delivery.getBody());
			System.out.println("队列B获取消息:"+msg);
			//deliveryTag 队列下标位置
			//multiple是否批量返回
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), true);
		}
	}


	//定义消费者
	@Test
	public void consumer3() throws IOException, ShutdownSignalException, ConsumerCancelledException, InterruptedException{
		//定义通道
		Channel channel = conn.createChannel();

		//定义队列
		channel.queueDeclare("queue_work", false, false, false, null);

		//定义消费数  每次只能消费一条记录.当消息执行后需要返回ack确认消息 才能执行下一条
		channel.basicQos(1);

		//定义消费者
		QueueingConsumer consumer = new QueueingConsumer(channel);

		//将队列和消费者绑定  false表示手动返回ack
		channel.basicConsume("queue_work", false, consumer);

		while(true){
			QueueingConsumer.Delivery delivery = consumer.nextDelivery();
			String msg = new String(delivery.getBody());
			System.out.println("队列C获取消息:"+msg);
			//deliveryTag 队列下标位置
			//multiple是否批量返回
			channel.basicAck(delivery.getEnvelope().getDeliveryTag(), true);
		}
	}
}
