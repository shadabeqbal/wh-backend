package com.example.wh_backend.email;

import com.example.wh_backend.models.request.UserRegisterInput;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.validation.support.BindingAwareModelMap;

import java.io.IOException;

@Component
public class EmailTemplate {

    @Autowired
    private Configuration freeMarkerConfig;

    public String composeUserRegisterTemplate(UserRegisterInput userRegisterInput) throws IOException, TemplateException{
        freeMarkerConfig.setClassForTemplateLoading(this.getClass(), "/templates");
        Template t;
        Model model = new BindingAwareModelMap();
        model.addAttribute("userRegisterInput", userRegisterInput);

        t = freeMarkerConfig.getTemplate("testing.ftl");

        return FreeMarkerTemplateUtils.processTemplateIntoString(t,model);
    }
}
