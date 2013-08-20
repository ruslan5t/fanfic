package by.itransition.fanfic.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.model.FanficModel;
import by.itransition.fanfic.model.bean.Comment;
import by.itransition.fanfic.model.bean.Fanfic;

@Controller
@RequestMapping("/addComment")
public class AddCommentController extends VisitPageController {

	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public String addComment(@PathVariable("fanficId") int fanficId,
			HttpServletRequest request) {
		Fanfic fanfic = FanficModel.getInstance().getFanficById(fanficId);
		Comment comment = new Comment();
		comment.setContent((String)request.getParameter("newComment"));
		fanfic.addComment(comment);
		FanficModel.getInstance().save(fanfic);
		return "redirect:/fanfic/" + fanficId;
	}
}
