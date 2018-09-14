package com.sasha;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class Excercise3CustomGreetUserTag extends SimpleTagSupport {
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

        outputGreeting(timeNow, out);

    }


    private void outputGreeting(int timeNow, JspWriter out) {

        if ( timeNow >= 20 && timeNow < 24 ) {

            try {

                out.println("Good Night!");

            } catch (IOException ioException) {

            }

        } else if ( timeNow >= 0 && timeNow < 12 ) {

            try {

                out.println("Good Morning!");

            } catch (IOException ioException) {

            }

        } else if ( timeNow >= 12 && timeNow < 16 ) {

            try {

                out.println("Good Day!");

            } catch (IOException ioException) {

            }

        } else if ( timeNow >= 16 && timeNow < 20 ) {

            try {

                out.println("Good Evening!");

            } catch (IOException ioException) {

            }

        }

    }

}
