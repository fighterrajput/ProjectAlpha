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
import com.rays.dto.PhoneDTO;
import com.rays.form.PhoneForm;
import com.rays.service.PhoneServiceInt;

@RestController
@RequestMapping(value = "Phone")
public class PhoneCtl extends BaseCtl<PhoneForm, PhoneDTO, PhoneServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> osMap = new HashMap<>();
		osMap.put(1, "iOS");
		osMap.put(2, "Android");
		osMap.put(3, "Windows");

		List<Map<String, Object>> osList = new ArrayList<>();
		osMap.forEach((key, value) -> {
			Map<String, Object> item = new HashMap<>();
			item.put("key", key);
			item.put("value", value);
			osList.add(item);
		});

		res.addResult("osList", osList);

		return res;
	}
}