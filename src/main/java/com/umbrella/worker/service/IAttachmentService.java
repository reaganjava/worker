package com.umbrella.worker.service;

import com.umbrella.worker.dto.AttachmentDO;
import com.umbrella.worker.result.ResultDO;

public interface IAttachmentService {

	public ResultDO create(AttachmentDO attachmentDO);
	
	public ResultDO get(Integer id);
	
	public ResultDO remove(Integer id);
}
