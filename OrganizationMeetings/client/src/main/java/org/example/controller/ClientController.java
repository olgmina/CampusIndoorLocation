package org.example.controller;

import org.example.communicat.LocationCommunicat;
import org.example.communicat.MeetingCommunicat;
import org.example.entity.Meeting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class ClientController {
    @Autowired
    MeetingCommunicat meetingCommunicat;
    @Autowired
    LocationCommunicat locationCommunicat;

    @RequestMapping("/")
    public String showMainPage(Model model){
        model.addAttribute("meetingsList", meetingCommunicat.listMeeting());
        return "index";
    }
    @RequestMapping("/addNewMeeting")
    public String showFormAddNewEmployee(Model model){

        model.addAttribute("meeting", new Meeting());
        model.addAttribute("locationList", locationCommunicat.getListLocation());
        return "addNewMeeting";
    }
    @RequestMapping("/saveMeeting")
    public String saveMeeting(@Valid @ModelAttribute("meeting") Meeting meeting, BindingResult bindingResult, Model model){
        model.addAttribute("locationList", locationCommunicat.getListLocation());
        if(bindingResult.hasErrors()){
            return "addNewMeeting";
        }
        else{
            meetingCommunicat.addMeeting(meeting);
            return "redirect:/";
        }
    }
    @RequestMapping("/deleteMeeting")
    public String deleteMeeting(@RequestParam("meetId") int id, Model model){
        meetingCommunicat.deleteMeeting(id);
        return "redirect:/";
    }
    @RequestMapping("/updateMeeting")
    public String updateMeeting(@RequestParam("meetId") int id, Model model){
        Meeting meeting = meetingCommunicat.getMeeting(id);
        model.addAttribute("locationList", locationCommunicat.getListLocation());
        model.addAttribute("meeting", meeting);
        return "/addNewMeeting";
    }
    @RequestMapping("/style")
    public String addCss(){
        return "style";
    }

}
