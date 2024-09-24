public class LightController {
    public Boolean status = false;
    public int level = 0;

    public void switchLight() {
        if (status == true) {
            status = false;
            level = 0;
            System.out.println("Lights are now OFF.");
        } else {
            status = true;
            level = 1;
            System.out.println("Lights are now ON.");
        }
    }

    public void showLightStatus() {
        if (status == false) {
            System.out.println("Light Status: OFF");
        } else {
            System.out.println("Light Status: ON");
        }
        System.out.println("Brightness Level: " + level);
    }

    public void adjustBrightness(int x) {
        if (status == false) {
            System.out.println("Please turn on the light first!");
        } 
        else {
          level += x;
          if (level >= 0 && level < 11) {
             System.out.println("Brightness adjusted.");
            } 
           else {
              System.out.println("Brightness out of range. Set between 0 to 10.");
              level -= x;
          }
        }
    }

    public String resetSettings() {
        level = 1;
        return "Light settings have been reset.";
    }
}