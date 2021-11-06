package com.nuchange.demo.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuchange.Entity.UrlEntity;
import com.nuchange.Repo.UrlRepository;
import com.nuchange.demo.util.URLShortener;

@Service
public class UrlService {

	public static TreeMap<String, Map<String, Integer>> urlMap = new TreeMap<>();

	private static URLShortener u;
	static {
		u = new URLShortener(5, "www.nuchange.com/");
	}

	public String storeUrl(String url) {
		if (!urlMap.containsKey(url)) {
			String shortenURL = u.shortenURL(url);
			Map<String, Integer> map = new HashMap<>();
			map.put(shortenURL, 0);
			urlMap.put(url, map);
			return shortenURL;
		} else {
			Map<String, Integer> map = urlMap.get(url);
			Set<String> keySet = map.keySet();
			return (String) (keySet.toArray())[0];
		}
	}

	public String getShortUrl(String url) {
		if (!urlMap.containsKey(url)) {
			return "URL Not found";
		} else {
			Map<String, Integer> map = urlMap.get(url);
			Set<String> keySet = map.keySet();
			String key = (String) (keySet.toArray())[0];
			map.put(key, map.get(key) + 1);
			urlMap.put(url, map);
			return (String) (keySet.toArray())[0];
		}
	}

	public Object getCount(String url) {
		if (!urlMap.containsKey(url)) {
			return "URL Not found";
		} else {
			Map<String, Integer> map = urlMap.get(url);
			Set<String> keySet = map.keySet();
			String key = (String) (keySet.toArray())[0];
			return map.get(key);
		}
	}

	public Map<String, Map<String, Integer>> fetchList(int page, int size) {
		int starting = (page - 1) * size + 1;
		int count = 1;
		Map<String, Map<String, Integer>> result = new HashMap<>();
		for (String key : urlMap.keySet()) {
			if (count >= starting && count <= starting + size) {
				result.put(key, urlMap.get(key));
			}
			count++;
		}
		return result;
	}
}
