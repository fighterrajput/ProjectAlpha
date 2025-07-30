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
import com.rays.dto.InstaDTO;
import com.rays.form.InstaForm;
import com.rays.service.InstaServiceInt;

@RestController
@RequestMapping(value = "Insta")
public class InstaCtl extends BaseCtl<InstaForm, InstaDTO, InstaServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> genderMap = new HashMap<>();
		genderMap.put(1, "Male");
		genderMap.put(2, "Female");
		genderMap.put(3, "Other");

		List<Map<String, Object>> genderList = new ArrayList<>();
		genderMap.forEach((key, value) -> {
			Map<String, Object> item = new HashMap<>();
			item.put("key", key);
			item.put("value", value);
			genderList.add(item);
		});

		res.addResult("genderList", genderList);

		return res;
	}
}