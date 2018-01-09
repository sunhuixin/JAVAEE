package com.iotek.shx.service;

import com.iotek.shx.entity.Resume;

public interface ResumeService {
	public int addResume(Resume resume);
	public int updateResume(Resume resume);
	public Resume findResume(int userId); 
}
