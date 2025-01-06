package com.leonid;

import org.apache.maven.plugin.AbstractMojo;
import org.apache.maven.plugins.annotations.Mojo;
import org.apache.maven.plugins.annotations.Parameter;

@Mojo(name = "add")
public class Adder extends AbstractMojo {

    @Parameter(property = "numberA", defaultValue = "hello")
    private String numberA;

    @Parameter(property = "numberB", required = true)
    private String numberB;

    @Override
    public void execute(){
        if (isNumber(numberA) && isNumber(numberB)) {
            int numA = Integer.parseInt(numberA);
            int numB = Integer.parseInt(numberB);
            getLog().info("Sum: " + numA + " + " + numB + " = " + (numA + numB));
        } else {
            getLog().warn("NumberA and NumberB should be integers");
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
