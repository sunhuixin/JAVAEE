package com.iotek.shx.service;

import org.apache.ibatis.annotations.Param;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Position;
import com.iotek.shx.entity.Resume;

public interface ResumeService {
	public int addResume(Resume resume);
	public int updateResume(Resume resume);
	public Resume findResume(int userId); 
	public Resume findByResumeId(int resumeId);
	public int updateDepartAndPosition(@Param("resume")Resume resume,
			@Param("admin") Administrator admin, 
			@Param("position")Position position);
	public boolean changeInfoCheckedById(int rid);

	public boolean changeInfoSendedById(int rid);
	
}
