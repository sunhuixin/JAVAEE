package com.iotek.shx.service.impl;

import org.springframework.stereotype.Service;

import com.iotek.shx.dao.PositionDao;
import com.iotek.shx.entity.Position;
import com.iotek.shx.service.PositionService;
@Service("positionService")
public class PositionServiceImpl implements PositionService {
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
	public int updatePosition(Position position) {
		return positionDao.updatePosition(position);
	}

}
