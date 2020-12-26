package es.myfilter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.myfilter.domain.ItemDto;
import es.myfilter.service.CollectionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/collection")
public class FilterController {

    private CollectionService collectionHandlerPort;

    public FilterController(CollectionService collectionHandlerPort) {
        this.collectionHandlerPort = collectionHandlerPort;
    }

    @ApiOperation(value = "View List items filter", response = ItemDto.class, responseContainer = "List")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved items"),
		@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
		@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
    @GetMapping("/all")
    public List<ItemDto> getCollection(@RequestParam(value = "filter", required = false, defaultValue = "") String filter) {
    	return collectionHandlerPort.getCollection(filter);
    }

}