package com.naver.b1.notice;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.naver.b1.util.FilePathGenerator;
import com.naver.b1.util.FileSaver;
import com.naver.b1.util.Pager;

@Service
public class NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Autowired
	private NoticeFilesMapper noticeFilesMapper;
	
	@Autowired
	private FilePathGenerator filePathGenerator;
	
	@Autowired
	private FileSaver fileSaver;
	
	
	public List<NoticeVO> noticeList(Pager pager) throws Exception{
		pager.makeRow();
		pager.makePager(noticeMapper.noticeCount(pager));
		
		return noticeMapper.noticeList(pager);
	}
	
	
	public int noticeWrite(NoticeVO noticeVO, MultipartFile[] files) throws Exception{
		File file = filePathGenerator.getUseClassPathResource("upload");
		int fresult = 0;
		int nresult = noticeMapper.noticeWrite(noticeVO);
		
		List<NoticeFilesVO> noticeFilesVOs = new ArrayList<>();
		
		for(int i=1;i<files.length;i++) {
		String fileName= fileSaver.save(file, files[i]);
		NoticeFilesVO noticeFilesVO = new NoticeFilesVO();
		noticeFilesVO.setNum(noticeVO.getNum());
		noticeFilesVO.setFname(fileName);
		noticeFilesVO.setOname(files[i].getOriginalFilename());
		
		noticeFilesVOs.add(noticeFilesVO);
		
		if(nresult > 0 ) {
			fresult = noticeFilesMapper.noticeFilesInsert(noticeFilesVOs);
		}
		
		}
		
		
		return fresult;
	}
	
}
