package com.WorkLess.WorkLess.parse;


import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;

import java.io.FileInputStream;

public class ParseDocFile {
    private String fileName = null;
    private String groupName = null;

    public ParseDocFile(String fileName) {
        this.fileName = fileName;
    }

    public DayWrapper[] parse() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            HWPFDocument doc = new HWPFDocument(fis);
            WordExtractor docExtractor = new WordExtractor(doc);
            int switcher = 0;
            DayWrapper[] wrappers = {
                    new DayWrapper("Время"),
                    new DayWrapper("Понедельник"),
                    new DayWrapper("Вторник"),
                    new DayWrapper("Среда"),
                    new DayWrapper("Четверг"),
                    new DayWrapper("Пятница"),
                    new DayWrapper("Суббота")
            };
            groupName = docExtractor.getParagraphText()[0].replaceAll("Расписание занятий учебной группы: ", "");
            groupName = groupName.substring(0, groupName.length() - 1);
            for (String paragraph : docExtractor.getParagraphText()) {
                switch (paragraph.substring(0, paragraph.length() - 1)) {
                    case "Время":
                        switcher = 1;
                        break;
                    case "Пнд":
                        switcher = 2;
                        break;
                    case "Втр":
                        switcher = 3;
                        break;
                    case "Срд":
                        switcher = 4;
                        break;
                    case "Чтв":
                        switcher = 5;
                        break;
                    case "Птн":
                        switcher = 6;
                        break;
                    case "Сбт":
                        switcher = 7;
                        break;
                    case "Пары":
                        switcher = 0;
                        break;
                    default:
                        break;
                }
                if(switcher != 0) wrappers[switcher - 1].addToList(paragraph);
            }
            return wrappers;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getGroupName() {
        return groupName;
    }
}
