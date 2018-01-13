package com.iotek.shx.dao;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;

public interface ResumeDao {
	public int saveResume(Resume resume);
	public int updateResume(Resume resume);
	public Resume queryResume(int userId); 
	public Resume queryByResumeId(int resumeId);
	public int updateDepartAndPosition(@Param("resume")Resume resume,
			@Param("admin") Administrator admin, 
			@Param("position")Position position);
	

}
