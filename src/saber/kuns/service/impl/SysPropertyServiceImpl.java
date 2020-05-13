package saber.kuns.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import saber.kuns.common.AbstractService;
import saber.kuns.dao.SysPropertyMapper;
import saber.kuns.entity.SysProperty;
import saber.kuns.service.SysPropertyService;

@Service
public class SysPropertyServiceImpl extends AbstractService<SysProperty, SysPropertyMapper>
		implements SysPropertyService {

	@Autowired
	SysPropertyMapper sysPropertyMapper;

	@Override
	public String genCode(Map<String, Object> params) {
		sysPropertyMapper.genCode(params);
		return params.get("code").toString();
	}

}
