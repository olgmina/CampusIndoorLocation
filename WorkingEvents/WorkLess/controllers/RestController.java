package com.WorkLess.WorkLess.controllers;

import com.WorkLess.WorkLess.error.ScheduleValidationErrorBuffer;
import com.WorkLess.WorkLess.model.Schedule;
import com.WorkLess.WorkLess.parse.DayWrapper;
import com.WorkLess.WorkLess.parse.ParseDocFile;
import com.WorkLess.WorkLess.repository.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.time.LocalTime;
import java.util.ArrayList;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api")
@CrossOrigin(maxAge = 3600)
public class RestController {
    private ScheduleRepository scheduleRepository;

    @Autowired
    public RestController(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    @GetMapping("/schedule")
    public ResponseEntity<Iterable<Schedule>> getSchedule(){
        return ResponseEntity.ok(scheduleRepository.findAll());
    }

    @RequestMapping("/test")
    public void addTest(){
        scheduleRepository.deleteAll();
        String[] paths = {
                "/Users/aleksandrbraznikov/Desktop/Расписание/bPI_181.doc"
        };
        for (String path : paths) {
            ParseDocFile parseDocFile = new ParseDocFile(path);
            DayWrapper[] parsed = parseDocFile.parse();
            DayWrapper time = parsed[0];
            for (DayWrapper wrapper : parsed) {
                if(wrapper != time) {
                    ArrayList<String> numerator = new ArrayList<>();
                    ArrayList<String> denominator = new ArrayList<>();
                    for (int k = 1; k < 8; k++) {
                        numerator.add(wrapper.getList().get(k));
                        denominator.add(wrapper.getList().get(k + 9));
                    }
                    parseWeek(numerator, true, time, wrapper, parseDocFile);
                    parseWeek(denominator, false, time, wrapper, parseDocFile);
                }
            }
        }
    }

    private void parseWeek(ArrayList<String> arrayList, boolean numeratorOrDenominator, DayWrapper time, DayWrapper wrapper, ParseDocFile parseDocFile) {
        for (int l = 0; l < arrayList.size(); l++) {
            if(arrayList.get(l).length() > 5) {
                String[] splitted = arrayList.get(l).split(" ");
                String teacher = "";
                String location = "";
                String name = "";
                for (int i = 0; i < splitted.length; i++) {
                    if(splitted[i].startsWith("а.")) location += splitted[i];
                    else if(splitted[i].startsWith("ДОЦ.") || splitted[i].startsWith("ПРОФ.")
                            || splitted[i].startsWith("СТ.ПР.") || splitted[i].startsWith("АСС.")) {
                        teacher += splitted[i].trim();
                        teacher += " ";
                        teacher += splitted[i + 1].trim();
                        teacher += " ";
                        teacher += splitted[i + 2].trim();
                        i += 2;
                    }
                    else {
                        name += splitted[i].trim();
                        name += " ";
                    }
                }
                String tempTime = time.getList().get(l + 1);
                String[] lessonTime = tempTime.substring(0, tempTime.length() - 2).split("-");
                scheduleRepository.save(new Schedule(wrapper.getTitle(),
                        LocalTime.parse(lessonTime[0]), LocalTime.parse(lessonTime[1]),
                        parseDocFile.getGroupName().replaceAll("\\r", ""), name.trim(), teacher,
                        location.replaceAll("\\u0007", ""), numeratorOrDenominator));
            }
        }
    }

    @PutMapping("/schedule/add")
    public ResponseEntity<?> addSchedule(@Validated @RequestBody Schedule schedule, Errors errors){
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().
                    body(ScheduleValidationErrorBuffer.fromBindingErrors(errors));
        }
        Schedule result = scheduleRepository.save(schedule);
        URI locationURI = ServletUriComponentsBuilder.fromCurrentRequest().
                path("/{id}").buildAndExpand(result.getId()).toUri();
        return ResponseEntity.created(locationURI).build();
    }

    @DeleteMapping("/schedule/{id}")
    public ResponseEntity<Schedule> deleteSchedule(@PathVariable String id){
        scheduleRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
