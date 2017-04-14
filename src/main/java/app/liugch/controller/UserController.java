package app.liugch.controller;

import app.liugch.model.Posts;
import app.liugch.model.Relationship;
import app.liugch.model.User;
import app.liugch.services.PostsServiceImpl;
import app.liugch.services.RelationshipServiceImpl;
import app.liugch.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    @Resource
    private UserServiceImpl uerServices;
    @Resource
    private RelationshipServiceImpl relationshipService;

    @Resource
    private PostsServiceImpl postsService;

    /**
     * 所有用户
     *
     * @param model
     * @param page
     * @return
     */
    @GetMapping
    public String getAll(Model model, @RequestParam(defaultValue = "1", name = "page") int page) {
        List<User> list = uerServices.getListPage(page);
        model.addAttribute("users", list);
        return "users/user";
    }

    //去关注
    @GetMapping(value = "/{id}/following")
    public String following(@PathVariable int id, HttpSession session) {
        // 获取我关注的人的所有微博
        List<Relationship> relationships= relationshipService.getListByMasterId(id);
        session.setAttribute("session_following", relationships);

        return "relationship/following";
    }


    //去粉丝
    @GetMapping(value = "/{id}/followers")
    public String followers(@PathVariable int id, HttpSession session) {

        // 获取粉丝的所有微博
        List<Relationship> relationships  = relationshipService.getListByForlowedId(id);

        session.setAttribute("session_followers",relationships);

        return "relationship/followers";
    }


    @GetMapping(value = "/{masterid}")
    public String addRelationship(@PathVariable int masterid ,Model model){
        List<Posts> list = postsService.getByMasterId(masterid);
        model.addAttribute("session_bymasterid",list);

        return "users/myself";
    }


}




