package com.iotek.shx.dao;

import java.util.List;

import com.iotek.shx.entity.ResumeInfo;

public interface ResumeInfoDao {

	public List<ResumeInfo> queryByAdminId(int adminId);

	public List<Integer> onlyQueryResumeId();

	public int updateCheck(int rid);

	public int updateSend(int rid);

	public ResumeInfo queryByResumeId(int resumeId);

	public int updateHire(int rid);

	public int deleteByResumeId(int rid);
}
