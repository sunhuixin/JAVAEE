package com.iotek.shx.dao;


import com.iotek.shx.entity.Position;

public interface PositionDao {
	public int savePosition(Position position);
	public int deletePosition(int id);
	public int updatePosition(Position position);
	public Position queryPosition(int pId);

}
