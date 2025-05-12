package org.example.gameManagment;

import java.util.HashSet;
import java.util.Set;

public class Job {
    private String jobName;

    public void chooseJob() {
        int jobChoice = InputValidator.getIntInput("What job do you wanna start? \n" +
                "1. glovo\n" +
                "2. collecting strawberries in Germany\n" +
                "3. become parliamentary representative",
                1, 3
        );
        switch (jobChoice) {
            case 1:
                this.jobName = "glovo";
                break;
            case 2:
                this.jobName = "strawberry man";
                break;
            case 3:
                this.jobName = "parliamentary representative";
                break;
        }
    }

    public void startJob() {

    }

    public void startGlovo() {

    }

    public void startStrawberries() {

    }

    public void startParliamentaryRepresentative() {

    }

}
