package org.alex.hw18.controller;


import org.alex.hw18.domain.Participant;
import org.alex.hw18.service.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String init(HttpServletRequest req) {
        req.setAttribute("participants", participantService.findAllParticipants());
        req.setAttribute("mode", "PARTICIPANT_VIEW");
        return "index";
    }

    @GetMapping("/new")
    public String newParticipant(HttpServletRequest req) {
        req.setAttribute("mode", "PARTICIPANT_CREATE");
        return "index";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Participant participant, HttpServletRequest req) {
        participantService.save(participant);
        req.setAttribute("participants", participantService.findAllParticipants());
        req.setAttribute("mode", "PARTICIPANT_VIEW");
        return "index";
    }

    @GetMapping("/update")
    public String update(@RequestParam int id, HttpServletRequest req) {
        req.setAttribute("participant", participantService.findOne(id));
        req.setAttribute("mode", "PARTICIPANT_EDIT");
        return "index";
    }

    @GetMapping("/delete")
    public String deleteParticipant(@RequestParam int id, HttpServletRequest req) {
        participantService.delete(id);
        req.setAttribute("participants", participantService.findAllParticipants());
        req.setAttribute("mode", "PARTICIPANT_VIEW");
        return "index";
    }

}
