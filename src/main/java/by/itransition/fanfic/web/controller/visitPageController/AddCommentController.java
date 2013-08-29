package by.itransition.fanfic.web.controller.visitPageController;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import by.itransition.fanfic.domain.Comment;
import by.itransition.fanfic.domain.Fanfic;
import by.itransition.fanfic.domain.User;
import by.itransition.fanfic.service.FanficService;
import by.itransition.fanfic.service.UserService;

@Controller
@RequestMapping("/addComment")
public class AddCommentController extends VisitPageController {

	@Autowired
	private FanficService fanficService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/{fanficId}/{authorId}", method = RequestMethod.POST)
	public String addComment(@PathVariable("fanficId") int fanficId,
			@PathVariable("authorId") int authorId,
			HttpServletRequest request) {
		Fanfic fanfic = fanficService.getFanficById(fanficId);
		Comment comment = new Comment();
		User user = userService.getUserById(authorId);
		user.addComment(comment);
		comment.setAuthor(user);
		comment.setContent((String)request.getParameter("newComment"));
		fanfic.addComment(comment);
		comment.setFanfic(fanfic);
		fanficService.save(fanfic);
		userService.save(user);
		return "redirect:/fanfic/" + fanficId;
	}
}
