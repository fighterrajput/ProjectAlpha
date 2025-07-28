package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.PhoneDTO;

@Repository
public class PhoneDAOImpl extends BaseDAOImpl<PhoneDTO> implements PhoneDAOInt {

	@Override
	protected List<Predicate> getWhereClause(PhoneDTO dto, CriteriaBuilder builder, Root<PhoneDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (dto.getModelName() != null && !dto.getModelName().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("modelName"), dto.getModelName() + "%"));
		}

		if (dto.getOs() != null && !dto.getOs().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("os"), dto.getOs() + "%"));
		}

		if (dto.getLaunchDate() != null) {
			whereCondition.add(builder.equal(qRoot.get("launchDate"), dto.getLaunchDate()));
		}


		if (dto.getPrice() != null) {
			whereCondition.add(builder.equal(qRoot.get("price"), dto.getPrice()));
		}

		return whereCondition;
	}

	@Override
	public Class<PhoneDTO> getDTOClass() {
		return PhoneDTO.class;
	}
}