package saber.kuns.service;

import java.util.Map;

import saber.kuns.common.CrudService;
import saber.kuns.entity.SysProperty;

public interface SysPropertyService extends CrudService<SysProperty> {
	
	public String genCode(Map<String, Object> params);

}
