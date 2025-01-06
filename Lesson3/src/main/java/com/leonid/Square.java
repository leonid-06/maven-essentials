package com.leonid;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;


@Mojo(name = "square")
public class Square extends AbstractMojo {

    @Parameter(property = "number", required = true)
    private String number;

    @Override
    public void execute(){

        if (isNumber(number)) {
            int _int = Integer.parseInt(number);
            getLog().info("The square of " + number + " is " + (_int*_int));
        } else {
            getLog().warn("Value must be an integer");
        }
    }

    private boolean isNumber(String value) {
        try {
            Integer.parseInt(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}