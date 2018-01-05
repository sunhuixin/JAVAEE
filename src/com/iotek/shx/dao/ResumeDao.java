package com.iotek.shx.dao;

import com.iotek.shx.entity.Resume;

public interface ResumeDao {
	public int saveResume(Resume resume);
	public int updateResume(Resume resume);
	public Resume queryResume(int userId); 

}
