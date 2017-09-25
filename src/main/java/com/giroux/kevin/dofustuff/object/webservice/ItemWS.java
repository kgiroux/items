package com.giroux.kevin.dofustuff.object.webservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.giroux.kevin.dofustuff.object.dto.Item;
import com.giroux.kevin.dofustuff.object.services.ItemService;
import com.giroux.kevin.dofustuff.object.webservice.exception.NotFoundException;

@RestController
@RequestMapping("/items")
public class ItemWS {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(name="Retrieve Item with Level",  method = RequestMethod.GET, consumes = {
			MediaType.APPLICATION_JSON_VALUE }, produces = {MediaType.APPLICATION_JSON_VALUE }, value = "/level/")
	public List<Item> retrieveListObjectByLevel(@RequestParam("level") final Integer level){
		List<Item> returnList = itemService.retrieveListObjectByLevel(level);
		if(CollectionUtils.isEmpty(returnList)) {
			throw new NotFoundException();
		}
		return returnList;
	}
}
