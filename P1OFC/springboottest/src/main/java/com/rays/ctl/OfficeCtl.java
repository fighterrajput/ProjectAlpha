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
import com.rays.dto.OfficeDTO;
import com.rays.form.OfficeForm;
import com.rays.service.OfficeServiceInt;

@RestController
@RequestMapping(value = "Office")
public class OfficeCtl extends BaseCtl<OfficeForm, OfficeDTO, OfficeServiceInt> {

	@GetMapping("/preload")
	public ORSResponse preload() {
		ORSResponse res = new ORSResponse(true);

		HashMap<Integer, String> deptMap = new HashMap<>();
		deptMap.put(1, "IT");
		deptMap.put(2, "Admin");
		deptMap.put(3, "HR");
		deptMap.put(4, "Sales");

		List<Map<String, Object>> productList = new ArrayList<>();
		deptMap.forEach((key, value) -> {
			Map<String, Object> item = new HashMap<>();
			item.put("key", key);
			item.put("value", value);
			productList.add(item);
		});

		res.addResult("productList", productList);

		return res;
	}
}