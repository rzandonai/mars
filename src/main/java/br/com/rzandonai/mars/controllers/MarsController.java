package br.com.rzandonai.mars.controllers;

import br.com.rzandonai.mars.services.MarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class MarsController {

	@Autowired
	private MarsService marsService;

	@PostMapping(path = "/mars/{moviment}")
	public ResponseEntity<?> getAllEmployees(@PathVariable("moviment") final String moviment) {
		return ResponseEntity.ok(marsService.calculatePosition(moviment).toString());
	}
}
