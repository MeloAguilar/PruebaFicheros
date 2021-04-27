package Clases.LecuraDeArchivos;

public class CharCounter {
    private String pattern;
    private boolean ignoreIfUpper;
    private static int timesOf = 0;

    public CharCounter(String pattern, boolean end) {
        this.pattern = pattern;
        this.ignoreIfUpper = end;
        if(!ignoreIfUpper){
            this.pattern = this.pattern + this.pattern.toUpperCase ();
        }
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean isIgnoreIfUpper() {
        return ignoreIfUpper;
    }

    public void setIgnoreIfUpper(boolean ignoreIfUpper) {
        this.ignoreIfUpper = ignoreIfUpper;
    }


    
    public int countIfTargeted(char character){
        boolean exit = false;
    for(int i = 0; i < this.pattern.toCharArray ().length && !exit; i++){
        if(this.pattern.toCharArray ()[i] == character){
            timesOf++;
            exit = true;
        }
    }
    return timesOf;
    }


    @Override
    public String toString() {
        return "CharCounter{" +
                "\npattern: " + pattern + '\'' +
                "\nVeces que aparece el patrón: " + timesOf +
                "\n}";
    }
}
