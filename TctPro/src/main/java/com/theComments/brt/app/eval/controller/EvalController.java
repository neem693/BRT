package com.theComments.brt.app.eval.controller;


import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.theComments.brt.app.eval.service.EvalService;
import com.theComments.brt.constFile.FileConst;
import com.theComments.brt.jpa.theComment.model.Evaluation_item;
import com.theComments.brt.jpa.theComment.model.FileSave;
import com.theComments.brt.jpa.theComment.model.Works;

@Controller
@RequestMapping("/eval")
public class EvalController {
	
	@Autowired
	private EvalService evalService;
	
	@RequestMapping("/share/{id}")
	public String evalDetail(
			Model model,
			@PathVariable("id") Long eval_id
			) {
		
		Evaluation_item item = evalService.getEvalDetail(eval_id);
		
		if(item == null) {
			return "redirect:/home";
		}
		
		model.addAttribute("eval", item);
		Works work = item.getEvaluate().get(0).getWorks();
		model.addAttribute("work", work);
		FileSave fileSave = work.getFileSave().iterator().next();
		model.addAttribute("work_file", fileSave);
		FileSave fileSave_eval = item.getFileSave().iterator().next();
		model.addAttribute("eval_file", fileSave_eval);
		model.addAttribute("baseURL",String.format("%s%s%s/", FileConst.UPLOAD_CONST.S3_URL,FileConst.UPLOAD_CONST.UPLOAD_BASE_PATH,FileConst.UPLOAD_CONST.EVAL_IMAGE_BASE_PATH));
		
		return "/view/evalShareDetail";
	}

}
