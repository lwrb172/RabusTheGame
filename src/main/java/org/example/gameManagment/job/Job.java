package org.example.gameManagment.job;

import org.example.gameManagment.InputValidator;

public class Job {
    private String jobName;

    public Job() {
        this.jobName = "jobless";
    }

    public void chooseJob() {
        int jobChoice = InputValidator.getIntInput("What job do you wanna start? \n" +
                "1. glovo (snake)\n" +
                "2. collecting strawberries in Germany (tic-tac-toe)\n" +
                "3. become parliamentary representative (typing game)",
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

    public void startJob(String job) {
        switch (job) {
            case "glovo":
                new Memory().start();
                break;
            case "strawberry man":
                //todo
                break;
            case "parliamentary representative":
                //todo
                break;
            default:
                System.out.println("Choose your job first!\n");
        }
    }

    public String getJobName() { return jobName; }
}
