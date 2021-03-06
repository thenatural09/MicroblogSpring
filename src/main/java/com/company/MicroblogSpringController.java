package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Troy on 10/23/16.
 */
@Controller
public class MicroblogSpringController {
    @Autowired
    MessageRepository microblog;

    @RequestMapping(path = "/",method = RequestMethod.GET)
    public String home(Model model) {
        Iterable<Message> mlist = microblog.findAll();
        model.addAttribute("messages",mlist);
        return "home";
    }

    @RequestMapping(path = "/message",method = RequestMethod.POST)
    public String addMessage(String text,String author) {
        Message message = new Message(text,author);
        microblog.save(message);
        return "redirect:/";
    }

    @RequestMapping(path = "/delete-message",method = RequestMethod.POST)
    public String deleteMessage(int id) {
        Message message = microblog.findOne(id);
        microblog.delete(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/edit-message",method = RequestMethod.POST)
    public String editMessage(int id,String text,String author) {
        Message message = new Message(id,text,author);
        microblog.save(message);
        return "redirect:/";
    }
}
