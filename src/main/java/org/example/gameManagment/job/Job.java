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
                startGlovo();
                break;
            case "strawberry man":
                startStrawberries();
                break;
            case "parliamentary representative":
                startParliamentaryRepresentative();
                break;
            default:
                System.out.println("Choose your job first!\n");
        }
    }

    public void startGlovo() { // snake
        // gracz zbiera zamowienia, im wiecej zbierze tym wiecej zarobi, odejmowanie energii
        Snake snake = new Snake();
        snake.start();
    }

    public void startStrawberries() { // tic tac toe
        // kolko krzyzyk z komputerem, gracz gra truskawkami, gra do 3 winow, kasa, odejmowanie energii
    }

    public void startParliamentaryRepresentative() { // fast typing
        // odliczanie 3 2 1, na górze wyświetla sie fragment konstytucji, podspodem go piszesz, odmierzanie czasu, im szybciej napiszesz tym wiecej kasy, odejmowanie energii
    }

    public String getJobName() { return jobName; }
}
