package com.rays.ctl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.ORSResponse;
import com.rays.dto.StoreDTO;
import com.rays.form.StoreForm;
import com.rays.service.StoreServiceInt;

@RestController
@RequestMapping(value = "Store")
public class StoreCtl extends BaseCtl<StoreForm, StoreDTO, StoreServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> modeMap = new HashMap<>();
		modeMap.put(1, "Online");
		modeMap.put(2, "Offline");

		List<Map<String, Object>> modeList = new ArrayList<>();
		modeMap.forEach((key, value) -> {
			Map<String, Object> item = new HashMap<>();
			item.put("key", key);
			item.put("value", value);
			modeList.add(item);
		});

		res.addResult("modeList", modeList);

		return res;
	}
}