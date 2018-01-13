package com.iotek.shx.service;

import java.util.List;

import com.iotek.shx.entity.Administrator;
import com.iotek.shx.entity.Interview;
import com.iotek.shx.entity.ResumeInfo;

public interface AdministratorService {
	
	public Administrator findByNameAndPassword(Administrator admin);

	public List<Administrator> findByDepartId(int departId);

	public Administrator findById(int adminId);
	
	public List<ResumeInfo> getResumeInfoByAdminId(int adminId);
	
	public List<Interview> receiveReply(int aid);
	
	public boolean sendInterview(Interview interview);

}
