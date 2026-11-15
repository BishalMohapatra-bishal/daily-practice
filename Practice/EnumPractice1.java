public class EnumPractice1 {
    public static void main(String[] args) {
        Week w = Week.WEDNESDAY;
        // System.out.println(w.getDayNo());

        Week[] days = Week.values();
        
        for(Week d : days) {
            System.out.println(d + " : Day:- " + d.getDayNo());
        }
    }
}

enum Week {
    SUNDAY(1),
    MONDAY(2),
    TUESDAY(3),
    WEDNESDAY(4),
    THRUSDAY(5),
    FRIDAY(6),
    SATURDAY(7);
    
    private int dayNo;

    Week(int dayNo) {
        this.dayNo = dayNo;
    }

    public int getDayNo() {
        return this.dayNo;
    }
}