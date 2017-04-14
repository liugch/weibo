package RoobBlogTest;

import app.liugch.dao.impl.UserDaoImpl;
import app.liugch.model.User;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import static app.liugch.util.Log.getLogger;


/**
 * 这是一个测试类
 */
public class TestAll {



    @Test
    public void ExportDB() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();
        Metadata metadata = new MetadataSources(serviceRegistry).buildMetadata();
        SchemaExport export = new SchemaExport();
        export.create(EnumSet.of(TargetType.DATABASE), metadata);
        getLogger().logger.info("是否实例化成功");
    }

    @Test
    public void page(){

    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext application = new ClassPathXmlApplicationContext("spring-root.xml");
        UserDaoImpl userDao = (UserDaoImpl) application.getBean("userDao");
        List<User> listPage = userDao.getListPage(1);
        System.out.println(listPage);
    }


    @Test
    public void testDate(){
        Date now = new Date(System.currentTimeMillis()+324323254);
        Date get = new Date(System.currentTimeMillis());
        System.out.println((now.getTime()-get.getTime())/(1000*3600*24));
        System.out.println(now.before(get));

        StringBuffer sb=new StringBuffer("点击下面链接激活账号，48小时生效，否则重新注册账号，链接只能使用一次，请尽快激活！</br>");
        sb.append("<a href=\"http://localhost:8080/upregist?action=activate&email=");
        sb.append("122@.com");
        sb.append("&validateCode=");
        sb.append("dfsdfdsf");
        sb.append(">http://localhost:8080/upregist?action=activate&email=");
        sb.append("122@.com");
        sb.append("&validateCode=");
        sb.append("dfsdfdsf");
        sb.append("</a>");
        System.out.println(sb.toString());


    }



    public void copyInputStreamToFile(InputStream inputStream, File file) {

        BufferedInputStream bin = null;
        BufferedOutputStream bout = null;
        try {
            bin = new BufferedInputStream(inputStream);
            bout = new BufferedOutputStream(new FileOutputStream(file));

            byte[] buff=new byte[1024];
            int len=0;
            while((len=bin.read(buff))!=-1){
                bout.write(buff,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                bin.close();
                bout.flush();
                bout.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }



}
