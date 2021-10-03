package br.com.mesttra.amsKitchen.amqp;

import static br.com.mesttra.amsKitchen.amqp.RabbitConfig.ORDER_KITCHEN_QUEUE;
import static br.com.mesttra.amsKitchen.enums.OrderStatus.PREPARING;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import br.com.mesttra.amsKitchen.service.KitchenItemService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class FromOrderConsumer {

	private KitchenItemService kitchenItemService;
	
	@RabbitListener(queues = ORDER_KITCHEN_QUEUE)
    public void consumer(@Payload KitchenRequestMessage kitchen) {
		kitchen.setBarStatus(PREPARING);
		kitchenItemService.addBarItem(kitchen);  
		
    }

}
