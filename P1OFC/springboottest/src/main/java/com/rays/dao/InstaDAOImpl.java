package com.rays.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.dto.InstaDTO;

@Repository
public class InstaDAOImpl extends BaseDAOImpl<InstaDTO> implements InstaDAOInt {

	@Override
	protected List<Predicate> getWhereClause(InstaDTO dto, CriteriaBuilder builder, Root<InstaDTO> qRoot) {

		List<Predicate> whereCondition = new ArrayList<>();

		if (dto.getId() != null && dto.getId() > 0) {
			whereCondition.add(builder.equal(qRoot.get("id"), dto.getId()));
		}

		if (dto.getName() != null && !dto.getName().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("name"), dto.getName() + "%"));
		}

		if (dto.getGender() != null && !dto.getGender().isEmpty()) {
			whereCondition.add(builder.like(qRoot.get("gender"), dto.getGender() + "%"));
		}

		if (dto.getAge() != null) {
			whereCondition.add(builder.equal(qRoot.get("age"), dto.getAge()));
		}


		if (dto.getNumber() != null) {
			whereCondition.add(builder.equal(qRoot.get("number"), dto.getNumber()));
		}

		return whereCondition;
	}

	@Override
	public Class<InstaDTO> getDTOClass() {
		return InstaDTO.class;
	}
}