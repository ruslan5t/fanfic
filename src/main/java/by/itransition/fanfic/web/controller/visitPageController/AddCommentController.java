package by.itransition.fanfic.web.controller.visitPageController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Comment;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.service.FanficService;

@Controller
@RequestMapping("/addComment")
public class AddCommentController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@RequestMapping(value = "/{fanficId}", method = RequestMethod.POST)
	public String addComment(@PathVariable("fanficId") int fanficId,
			HttpServletRequest request) {
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		Comment comment = new Comment();
		comment.setContent((String)request.getParameter("newComment"));
		fanfic.addComment(comment);
		fanficService.save(fanfic);
		return "redirect:/fanfic/" + fanficId;
	}
}
