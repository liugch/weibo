package app.liugch.controller;

import app.liugch.model.Posts;
import app.liugch.model.User;
import app.liugch.services.PostsServiceImpl;
import app.liugch.services.RelationshipServiceImpl;
import app.liugch.services.UserServiceImpl;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.sql.Date;

@Controller
@RequestMapping("/posts")
public class PostController {

    @Resource
    private UserServiceImpl uerServices;
    @Resource
    private RelationshipServiceImpl relationshipService;
    @Resource
    private PostsServiceImpl postsService;



    @PostMapping(value = "/{id}")
    public String post(MultipartFile picfile, HttpServletRequest request, @PathVariable int id , Posts posts, Model model, HttpSession session) {
        // 保存到数据库中
        User user = new User();
        user.setId(new Long(id));
        posts.setCrateTime(new Date(System.currentTimeMillis()));
        posts.setUser(user);

        if (picfile != null && !picfile.isEmpty()) {
            try {
                //保存的路径
                String realPath = request.getSession().getServletContext().getRealPath("/uploads");

                System.out.println("getRealPath:"+realPath);
                // 获取图片的文件名
                String fileName = picfile.getOriginalFilename();
                System.out.println("获取图片的文件名"+fileName);


                // 获取图片的扩展名
                String extensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
                // 新的图片文件名 = 获取时间戳+"."图片扩展名
                String newFileName = String.valueOf(System.currentTimeMillis()) + "." + extensionName;
                System.out.println("新的图片文件名"+newFileName);

                // 保存在数库中文件地址
                String SQLpicName = realPath+"\\"+newFileName;
                String SQLpicName2 = "/uploads/"+newFileName;



                System.out.println("保存在数库中文件地址"+SQLpicName);
                System.out.println("保存在数库中文件地址2"+SQLpicName2);


                //在服务器中创建一个 文件保存
                File file = new File(realPath, newFileName);

                //保存在服务器中
                FileUtils.copyInputStreamToFile(picfile.getInputStream(), file);

                //保存
                posts.setPic(SQLpicName2);

              /*  List<Posts> list = postsService.getByMasterId(id);

                session.setAttribute("session_bymasterid",list);*/

            } catch (Exception e) {
                model.addAttribute("info","发布失败!");
                //log.error("上传图片失败.", e);
            }
        }
        postsService.save(posts);
        model.addAttribute("info","发布微博成功!");

        return "redirect:/index";
    }
}
