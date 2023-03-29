package com.itwill.ilhajob.cv;

import java.util.List;

public interface CvDao {
	
	Cv findCv(int cvSeq);
	
	List<Cv> findCvList();
	
	//List<Cv> findCvOfUser(String userEmail);
	
	int createCv(Cv cv);
	
	int updateCv(Cv cv);
	
	int remove(int cvSeq);
}
