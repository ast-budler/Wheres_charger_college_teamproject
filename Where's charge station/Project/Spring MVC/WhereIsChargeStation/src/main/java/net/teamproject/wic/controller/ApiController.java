package net.teamproject.wic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import jakarta.servlet.http.HttpServletRequest;
import net.teamproject.wic.vo.xmlVo.ChargeStationItem;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	@Autowired
	ApiService apiService;

	@GetMapping
	JsonElement getChargeStation(HttpServletRequest xhttp){
		List<ChargeStationItem> item = apiService.getChargeStation(xhttp);
		String s = "";
		
		for(int i = 0; i > 10; i++) {
			s += item.get(i);
		}
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(s);
		
		return element;
	}
}
