package br.com.mesttra.amsKitchen.controller;

import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mesttra.amsKitchen.amqp.KitchenRequestMessage;
import br.com.mesttra.amsKitchen.dto.KitchenStatusDto;
import br.com.mesttra.amsKitchen.service.KitchenItemService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/kitchen-orders")
public class KitchenItemController {
	
	private KitchenItemService kitchenItemService;
	
	@PatchMapping(path = "/{kitchenItemId}")
	public KitchenRequestMessage changeOredrStatus(
			@PathVariable String kitchenItemId, 
			@RequestBody KitchenStatusDto dto) {
		
		return kitchenItemService.changeStatus(kitchenItemId, dto);
		
	}

}
