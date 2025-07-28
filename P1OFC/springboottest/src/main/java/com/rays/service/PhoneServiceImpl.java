package com.rays.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.dao.PhoneDAOImpl;
import com.rays.dto.PhoneDTO;

@Service
@Transactional
public class PhoneServiceImpl extends BaseServiceImpl<PhoneDTO, PhoneDAOImpl> implements PhoneServiceInt {

}