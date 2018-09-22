package com.sasha;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Exercise3CustomGreetUserTag extends SimpleTagSupport {
    @Override
    public void doTag() throws JspException, IOException {
        super.doTag();


        Calendar calendar = Calendar.getInstance();
        String groundhogDay = "02/02";
        int timeNow = calendar.get(Calendar.HOUR_OF_DAY);
        JspWriter out = getJspContext().getOut();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd");
        LocalDate localDate = LocalDate.now();
        String localDateOutput = dateTimeFormatter.format(localDate);


        if ( localDateOutput.equals(groundhogDay) ) {

            out.println("Happy groundhog day!");

        }

        if ( timeNow >= 20 && timeNow < 24 ) {

            out.println("Good Night!");


        } else if ( timeNow >= 0 && timeNow < 12 ) {

            out.println("Good Morning!");


        } else if ( timeNow >= 12 && timeNow < 16 ) {

            out.println("Good Day!");

        } else if ( timeNow >= 16 && timeNow < 20 ) {

            out.println("Good Evening!");

        }

    }


}
