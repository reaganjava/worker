package com.umbrella.worker.service;

import com.umbrella.worker.dto.CommentDO;
import com.umbrella.worker.query.CommentQuery;
import com.umbrella.worker.result.ResultDO;

public interface ICommentService {
	
	public ResultDO create(CommentDO commentDO);
	
	public ResultDO modifi(CommentDO commentDO);
	
	public ResultDO remove(int commentId);
	
	public ResultDO get(int commentId);

	public ResultDO list(CommentQuery commentQuery);
}
