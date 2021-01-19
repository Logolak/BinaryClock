package bin.clock;

public class CustomTime {
    private int customHod;
    private int customMin;
    private int customSec;


    public void increment() {
        if (this.customSec >= 59) {
            this.customSec = 0;
            this.customMin++;
        } else
            this.customSec++;

        if (this.customMin >= 60) {
            this.customMin = 0;
            this.customHod++;
        }
        if (this.customHod >= 24)
            this.customHod = 0;

    }



    public void setCustomHod(int newTime) {
        this.customHod = newTime;
    }

    public void setCustomMin(int newTime) {
        this.customMin = newTime;
    }

    public void setCustomSec(int newTime) {
        this.customSec = newTime;
    }



    public int getCustomHod() {
        return this.customHod;
    }

    public int getCustomMin() {
        return this.customMin;
    }

    public int getCustomSec() {
        return this.customSec;
    }
}