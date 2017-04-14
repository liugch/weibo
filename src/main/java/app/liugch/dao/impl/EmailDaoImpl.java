package app.liugch.dao.impl;

import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 邮箱serviecs
 */
@Repository
public class EmailDaoImpl {

    @Resource
    MailSender mailSender;
    // 发件人
    private static final String FROM="liugchs@163.com";

    // 邮件标题
    private static final String SUBJECT="这是一个邮箱注册激活验证!";

    public void sendMail(String toEmail,String content) {
        SimpleMailMessage mailMsg = new SimpleMailMessage();
        mailMsg.setFrom(FROM);
        mailMsg.setTo(toEmail);
        mailMsg.setSubject(SUBJECT);
        mailMsg.setText(content);
        mailMsg.setSentDate(new Date());



        mailSender.send(mailMsg);  // 发送
    }
}
