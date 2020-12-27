package es.myfilter.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.myfilter.domain.ItemDto;
import es.myfilter.service.CollectionService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/collection")
public class FilterController {

    private CollectionService collectionHandlerPort;

    public FilterController(CollectionService collectionHandlerPort) {
        this.collectionHandlerPort = collectionHandlerPort;
    }

    @ApiOperation(value = "Recuperar una lista con todos los datos filtrados", response = ItemDto.class, responseContainer = "List")
	@ApiResponses(value = {
		@ApiResponse(code = 200, message = "Successfully retrieved items"),
		@ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
		@ApiResponse(code = 500, message = "Internal error")
	})
    @GetMapping("/all")
    public List<ItemDto> getCollection(@ApiParam(value = "Filtro aplicado", required = false) @RequestParam(value = "filter", required = false) String filter) {
    	return collectionHandlerPort.getCollection(filter);
    }

}
