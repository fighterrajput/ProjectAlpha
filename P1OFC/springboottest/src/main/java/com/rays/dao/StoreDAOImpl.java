package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.StoreDTO;

@Repository
public class StoreDAOImpl extends BaseDAOImpl<StoreDTO> implements StoreDAOInt {

	@Override
	protected List<Predicate> getWhereClause(StoreDTO dto, CriteriaBuilder builder, Root<StoreDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (dto.getProduct() != null && !dto.getProduct().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("product"), dto.getProduct() + "%"));
		}

		if (dto.getMode() != null && !dto.getMode().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("mode"), dto.getMode() + "%"));
		}

		if (dto.getDate() != null) {
			whereCondition.add(builder.equal(qRoot.get("date"), dto.getDate()));
		}


		if (dto.getPrice() != null) {
			whereCondition.add(builder.equal(qRoot.get("price"), dto.getPrice()));
		}

		return whereCondition;
	}

	@Override
	public Class<StoreDTO> getDTOClass() {
		return StoreDTO.class;
	}
}