package com.iotek.shx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotek.shx.dao.PositionDao;
import com.iotek.shx.entity.Position;
import com.iotek.shx.service.PositionService;
@Service("positionService")
public class PositionServiceImpl implements PositionService {
	@Autowired
	private PositionDao positionDao;
	@Override
	public int addPosition(Position position) {
		return positionDao.savePosition(position);
	}

	@Override
	public int deletePosition(int id) {
		return positionDao.deletePosition(id);
	}

	@Override
	public int updatePosition(int pid,String pname,int departId) {
		List<Position> positions = positionDao.queryPositionsByDepartId(departId);
		int flag=0;
		for (Position position : positions) {
			if(position.getPname().equals(pname)) {
				 flag = positionDao.updatePosition(pid, pname);
			}
		}
		return flag;
	}

	@Override
	public Position findPosition(int pId) {
		return positionDao.queryPosition(pId);
	}

	@Override
	public List<Position> findPositionsByDepartId(int id) {
		return positionDao.queryPositionsByDepartId(id);
	}

}
