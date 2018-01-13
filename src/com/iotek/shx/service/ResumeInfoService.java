package com.iotek.shx.service;

import java.util.List;

import com.iotek.shx.entity.ResumeInfo;

public interface ResumeInfoService {
	public List<ResumeInfo> findByAdminId(int adminId);

	public List<Integer> onlyfindResumeId();

	public int updateCheck(int rid);

	public int updateSend(int rid);

	public ResumeInfo findByResumeId(int resumeId);

	public int updateHire(int rid);

	public int deleteByResumeId(int rid);
}
