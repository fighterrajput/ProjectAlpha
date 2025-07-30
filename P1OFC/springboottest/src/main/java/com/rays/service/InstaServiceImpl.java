package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.InstaDAOImpl;
import com.rays.dto.InstaDTO;

@Service
@Transactional
public class InstaServiceImpl extends BaseServiceImpl<InstaDTO, InstaDAOImpl> implements InstaServiceInt {

}