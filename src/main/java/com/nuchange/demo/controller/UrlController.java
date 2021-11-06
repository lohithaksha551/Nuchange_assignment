package com.nuchange.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nuchange.demo.service.UrlService;

@RestController
public class UrlController {

	@Autowired
	private UrlService service;

	@PostMapping(path = "/storeurl")
	public ResponseEntity<?> storeUrl(@RequestParam String url) {
		service.storeUrl(url);
		return new ResponseEntity(HttpStatus.CREATED);

	}

	@GetMapping(path = "/get")
	public ResponseEntity<?> getUrlShortKey(@RequestParam String url) {
		return ResponseEntity.ok(service.getShortUrl(url));

	}

	@GetMapping(path = "/count")
	public ResponseEntity<?> getUrlCount(@RequestParam String url) {
		return ResponseEntity.ok(service.getCount(url));

	}

	@GetMapping(path = "/list")
	public ResponseEntity<?> getList(@RequestParam int page, @RequestParam int size) {
		return ResponseEntity.ok(service.fetchList(page, size));

	}
}
