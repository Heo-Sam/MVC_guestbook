package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;
import com.ict.db.VO;

public class UpdateCommand implements Command {
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		String idx = request.getParameter("idx");
		VO vo = DAO.getInstance().getSelectOne(idx);
		
		/*
		두 가지 방법이 있다
	 	방법1) 수정, 삭제를 위해 vo를 session에 담는다.
		방법2) 수정, 삭제 시에 idx와 pw를 파라미터로 필요할 때마다 넘긴다.
		 */
		// 방법2)로
		request.setAttribute("vo", vo);

		return "MyController?cmd=update";
	}

}
