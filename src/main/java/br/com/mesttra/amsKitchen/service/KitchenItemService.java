package br.com.mesttra.amsKitchen.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mesttra.amsKitchen.amqp.KitchenRequestMessage;
import br.com.mesttra.amsKitchen.amqp.RabbitConfig;
import br.com.mesttra.amsKitchen.dto.KitchenStatusDto;
import br.com.mesttra.amsKitchen.repository.KitchenItemRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class KitchenItemService {
	
	private KitchenItemRepository kitchenItemRepository;
	private RabbitTemplate rabbitTemplate;
	
	public KitchenRequestMessage addBarItem(KitchenRequestMessage kitchen) {
		return this.kitchenItemRepository.save(kitchen);		
	}
	
	@Transactional
	public KitchenRequestMessage changeStatus(String kitchenItemId, KitchenStatusDto dto) {
		KitchenRequestMessage db = this.kitchenItemRepository.findById(kitchenItemId).
					orElseThrow(() -> new RuntimeException(
							String.format("Id %s not found.", kitchenItemId)));
		db.setBarStatus(dto.getBarStatus());
		if (dto.getBarStatus().toString().equalsIgnoreCase("done")) {
			rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_NAME, RabbitConfig.KITCHEN_ORDER_KEY, db);
		}
		return this.kitchenItemRepository.save(db);			
	}

}
