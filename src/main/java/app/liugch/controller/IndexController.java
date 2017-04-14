package app.liugch.controller;

import app.liugch.model.Posts;
import app.liugch.model.User;
import app.liugch.services.PostsServiceImpl;
import app.liugch.services.RelationshipServiceImpl;
import app.liugch.services.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class IndexController {

    @Resource
    private UserServiceImpl uerServices;
    @Resource
    private RelationshipServiceImpl relationshipService;

    @Resource
    private PostsServiceImpl postsService;

    /**
     * 主页
     * @return
     */
    @GetMapping(value = "/index")
    public String postsindex(HttpSession session, @RequestParam(value = "page", defaultValue = "1") int page) {

        List<Posts> postsList2 = postsService.getListPageOrderbyTime(page);


        session.setAttribute("session_posts", postsList2);

        return "posts/index";
    }

    /**
     * 主页
     * @return
     */
    @GetMapping(value = "/")
    public String index() {
        return "index";
    }

    /**
     * 去登录页面
     * @return
     */
    @GetMapping(value = "/login")
    public String login(User user,HttpSession session) {
        return "login";
    }

    //@PostMapping(value = "/login")
    //public String login2(User user, HttpSession session, Errors errors, @RequestParam(value = "page", defaultValue = "1") int page) {
    //
    //    User use = uerServices.login(user.getMail(), user.getPwd());
    //
    //    if (use == null || errors.hasErrors()) {
    //        return "redirect:/login";
    //    } else {
    //
    //        //我关注的
    //        List<Relationship> relationshipList1 = relationshipService.getListByMasterId((int) use.getId());
    //        System.out.println("我关注的大小:" + relationshipList1.size() + "====" + relationshipList1.get(1).getId());
    //        //我的粉丝
    //        List<Relationship> relationshipList2 = relationshipService.getListByForlowedId((int) use.getId());
    //
    //        System.out.println("我的粉丝大小:" + relationshipList2.size() + "====" + relationshipList1.get(1).getId());
    //
    //        session.setAttribute("session_user", use);
    //        session.setAttribute("session_relationshipList1", relationshipList1);
    //        session.setAttribute("session_relationshipList2", relationshipList2);
    //
    //        return "redirect:/index";
    //    }
    //}

    @PostMapping(value = "/login")
    public String login2(User user, HttpSession session, Errors errors,Model model) {
        User use = uerServices.login(user.getMail(), user.getPwd());
        if (use == null || errors.hasErrors()) {

            model.addAttribute("login_fail","登录失败!请重新改登录!");
            return "redirect:/login";

        } else {

            session.setAttribute("session_user",use);

            session.setAttribute("session_relationshipList1", use.getRelationships());

            session.setAttribute("session_relationshipList2", use.getRelationships2());

          /*  System.out.println(use.getRelationships());
            System.out.println(use.getRelationships2());
*/
            return "redirect:/index";
        }
    }

    /**
     * 去用户注册
     * @return
     */
    @GetMapping(value = "/regist")
    public String regist(User user, HttpServletRequest request, HttpSession session) {
        session.removeAttribute("session_user");
        return "regist";
    }

    //@RequestMapping(value = "/upregist", method = {RequestMethod.GET, RequestMethod.POST})
    //public String regist2(User user, String repwd, HttpServletRequest request, Model model, HttpSession session, Errors errors) {
    //
    //    String action = request.getParameter("action");
    //    String email = request.getParameter("email");
    //    String validateCode = request.getParameter("validateCode");
    //
    //    //如果是激活的话,改变 数据库的转态
    //    if ("activate".equals(action)) {
    //
    //        uerServices.activateRegist(email, validateCode);
    //
    //        User use = uerServices.getUserByEamil(email);
    //        if (use == null || errors.hasErrors()) {
    //            return "redirect:/login";
    //        } else {
    //            List<Relationship> relationshipList1 = relationshipService.getListByMasterId((int) use.getId());
    //            List<Relationship> relationshipList2 = relationshipService.getListByForlowedId((int) use.getId());
    //            session.setAttribute("session_user", use);
    //            session.setAttribute("session_relationshipList1", relationshipList1);
    //            session.setAttribute("session_relationshipList2", relationshipList2);
    //            return "redirect:/index";
    //        }
    //    } else {
    //        // 注册 发送邮箱 激活
    //        uerServices.processRegist(user);
    //        model.addAttribute("activate", action);
    //        return "redirect: /";
    //    }
    //}


    @RequestMapping(value = "/upregist", method = {RequestMethod.GET, RequestMethod.POST})
    public String regist2(User user, String repwd, HttpServletRequest request, Model model, HttpSession session, Errors errors) {

        String action = request.getParameter("action");
        String email = request.getParameter("email");
        String validateCode = request.getParameter("validateCode");

        //如果是激活的话,改变 数据库的转态
        if ("activate".equals(action)) {
            uerServices.activateRegist(email, validateCode);
            User use = uerServices.getUserByEamil(email);
            if (use == null || errors.hasErrors()) {
                return "redirect:/login";
            } else {
                session.setAttribute("session_user", use);
                session.setAttribute("session_relationshipList1", use.getRelationships());
                session.setAttribute("session_relationshipList2", user.getRelationships2());

                return "redirect:/index";
            }
        } else {
            // 注册 发送邮箱 激活
            uerServices.processRegist(user);
            model.addAttribute("activate", "去你注册的邮箱进行验证!");
            return "redirect: /";
        }
    }



    @GetMapping(value = "/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("session_user");
        session.invalidate();
        return "redirect:/";
    }
}




