package com.grzelak.controllers;

import com.grzelak.classes.Component;
import com.grzelak.classes.Producer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.grzelak.classes.Phone;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * Created by Kapelusznik on 21.02.2017.
 */
@Controller
public class FormController {



    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String formGet(Model m)
    {
        Phone phone = new Phone();
        m.addAttribute("phone", phone);

        List<Component> components = new ArrayList<>();
        Collections.addAll(components, Component.BLUETOOTH, Component.CAMERA, Component.CASE, Component.HEADPHONES, Component.WIFI);
        m.addAttribute("components", components);

        List<Producer> producers = new ArrayList<>();
        Collections.addAll(producers, Producer.APPLE, Producer.LG, Producer.MICROSOFT, Producer.MOTOROLA, Producer.SAMSUNG);
        m.addAttribute("producers", producers);


        return "phone";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String formPost(@Valid @ModelAttribute Phone phone1, BindingResult result, Model m, HttpServletRequest request)
    {
        if (result.hasErrors()) //tak przechwycisz czy sa bledy walidacji czyli wynikajace ze sprawdzania ktore
        //narzucila adnotacja @Valid
        {
            //wypisanie bledow
            System.out.println("================BINDING RESULTS=====================");
            List<FieldError> errors = result.getFieldErrors();
            for (FieldError error : errors ) {
                System.out.println (error.getDefaultMessage());
            }
            System.out.println("====================================================");

            Phone phone = new Phone();
            m.addAttribute("phone", phone);

            List<Component> components = new ArrayList<>();
            Collections.addAll(components, Component.BLUETOOTH, Component.CAMERA, Component.CASE, Component.HEADPHONES, Component.WIFI);
            m.addAttribute("components", components);

            List<Producer> producers = new ArrayList<>();
            Collections.addAll(producers, Producer.APPLE, Producer.LG, Producer.MICROSOFT, Producer.MOTOROLA, Producer.SAMSUNG);
            m.addAttribute("producers", producers);




            return "phone";
        }

        MultipartFile multipartFile = phone1.getMultipartFile();
        String realPath = request.getSession().getServletContext().getRealPath("/");
        System.out.println(realPath);
        String staticPath = "static/telephones/";
        String path = realPath + staticPath + multipartFile.getOriginalFilename();


        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(multipartFile.getOriginalFilename());
        System.out.println(phone1);
        return "redirect:/goodjob";
    }
}
