package com.iotek.shx.service;

import com.iotek.shx.entity.Position;

public interface PositionService {
	public int addPosition(Position position);
	public int deletePosition(int id);
	public int updatePosition(Position position);
	public Position findPosition(int pId);

}
