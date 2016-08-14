package schedule.app.schedule;

import java.util.Collection;

import javax.inject.Inject;
import javax.validation.groups.Default;

import org.dozer.Mapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.terasoluna.gfw.common.exception.BusinessException;
import org.terasoluna.gfw.common.message.ResultMessage;
import org.terasoluna.gfw.common.message.ResultMessages;

import schedule.app.schedule.ScheduleForm.ScheduleDelete;
import schedule.app.schedule.ScheduleForm.ScheduleCreate;
import schedule.app.schedule.ScheduleForm.ScheduleFinish;
import schedule.domain.model.Schedule;
import schedule.domain.service.schedule.ScheduleService;

@Controller
@RequestMapping("schedule")
public class ScheduleController {
	
    private static final Logger logger = LoggerFactory
            .getLogger(ScheduleController.class);
	
    @Inject
    ScheduleService scheduleService;
    
    @Inject
    Mapper beanMapper;
    
    @ModelAttribute
    public ScheduleForm setUpForm() {
    	ScheduleForm form = new ScheduleForm();
        return form;
    }

    @RequestMapping(value = "list")
    public String list(Model model) {
        Collection<Schedule> schedules = scheduleService.findAll();
        model.addAttribute("schedules", schedules); 
        return "schedule/list"; 
    }
    
    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(
    		@Validated({ Default.class, ScheduleCreate.class }) ScheduleForm scheduleForm,
    		BindingResult bindingResult, Model model, RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return insert(model);
        }

        Schedule schedule = beanMapper.map(scheduleForm, Schedule.class);

        try {
        	scheduleService.create(schedule);
        } catch (BusinessException e) {

            model.addAttribute(e.getResultMessages());
            return list(model);
        }

        attributes.addFlashAttribute(ResultMessages.success().add(
                ResultMessage.fromText("Created successfully!")));
        return "redirect:/schedule/list";
    }
    
    @RequestMapping(value = "finish", method = RequestMethod.POST) // (2)
    public String finish(
            @Validated({ Default.class, ScheduleFinish.class }) ScheduleForm form, // (3)
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {
        if (bindingResult.hasErrors()) {
            return list(model);
        }

        try {
        	scheduleService.finish(form.getScheduleId());
        } catch (BusinessException e) {
            model.addAttribute(e.getResultMessages());
            return list(model);
        }

        attributes.addFlashAttribute(ResultMessages.success().add(
                ResultMessage.fromText("Finished successfully!")));
        return "redirect:/schedule/list";
    }
    
    @RequestMapping(value = "delete", method = RequestMethod.POST) // (1)
    public String delete(
            @Validated({ Default.class, ScheduleDelete.class }) ScheduleForm form,
            BindingResult bindingResult, Model model,
            RedirectAttributes attributes) {

        if (bindingResult.hasErrors()) {
            return list(model);
        }

        try {
        	scheduleService.delete(form.getScheduleId());
        } catch (BusinessException e) {
            model.addAttribute(e.getResultMessages());
            return list(model);
        }

        attributes.addFlashAttribute(ResultMessages.success().add(
                ResultMessage.fromText("Deleted successfully!")));
        return "redirect:/schedule/list";
    }
    
    @RequestMapping(value = "insert", method = {RequestMethod.GET})
    public String insert(Model model) {
        logger.info("Add scheduleへのリクエストがありました");

        return "schedule/insert";
    }
    
    @RequestMapping(value = "info", method = RequestMethod.POST)
    public String info(Model model, ScheduleForm form) {
        logger.info("Add scheduleへのリクエストがありました");
        
        Schedule schedule = scheduleService.findOne(form.getScheduleId());
        model.addAttribute("schedule", schedule); 

        return "schedule/info";
    }
    
}
