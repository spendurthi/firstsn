package com.standone.web.manager;

import java.util.List;

import com.standone.spring.dao.DesignationsDao;
import com.standone.spring.vo.DesignationVo;

public class DesignationManager {
	private DesignationsDao dao;

	public void setDao(DesignationsDao dao) {
		this.dao = dao;
	}
	public int delete(DesignationVo vo) {
		return dao.delete(vo);
	}
	public int save(DesignationVo vo) {
		return dao.save(vo);
	}
	public List<DesignationVo> select() {
		return (List)dao.select();
	}
	public DesignationVo select(int id) {
		return (DesignationVo) dao.select(id);
	}
	public int update(DesignationVo vo) {
		return dao.update(vo);
	}
}
