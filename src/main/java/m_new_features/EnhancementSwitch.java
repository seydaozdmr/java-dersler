package m_new_features;

public class EnhancementSwitch {
    public static void main(String[] args) {
        int priorityLevel;
        int eventCode = 6010;
        // A traditional switch that supplies a value associated
        // with a case.
        switch(eventCode) {
            case 1000:
            case 1205:
            case 8900:
                priorityLevel = 1;
                break;
            case 2000:
            case 6010:
            case 9128:
                priorityLevel = 2;
                break;
            case 1002:
            case 7023:
            case 9300:
                priorityLevel = 3;
                break;
            default: // normal priority
                priorityLevel = 0;
        }
        System.out.println(priorityLevel);
        //1. improvement ->
        switch (eventCode){
            case 1000,1205,8900:
                priorityLevel = 1;
                break;
            case 2000, 6010, 9128:
                priorityLevel = 2;
                break;
            case 1002, 7023, 9300:
                priorityLevel = 3;
                break;
            default: // normal priority
                priorityLevel = 0;
        }
        System.out.println(priorityLevel);
        //2. yield returns a result value
        int priorityLevel2 = switch(eventCode) {
            case 1000, 1205, 8900:
                yield 1;
            case 2000, 6010, 9128:
                yield 2;
            case 1002, 7023, 9300:
                yield 3;
            default: // normal priority
                yield 0;
        };
        System.out.println(priorityLevel2);
        //3. arrow case
        int priorityLevel3 = switch(eventCode) {
            case 1000, 1205, 8900 -> 1;
            case 2000, 6010, 9128 -> 2;
            case 1002, 7023, 9300 -> 3;
            default -> 0; // normal priority
        };
        System.out.println(priorityLevel3);

        //4. arrow with code blocks

        int priorityLevel4 = switch(eventCode) {
            case 1000, 1205, 8900 -> { // use a block with an arrow
                System.out.println("Alert");
                yield 1;
            }
            case 2000, 6010, 9128 -> {
                System.out.println("Warning");
                yield 2;
            }
            case 1002, 7023, 9300 -> {
                System.out.println("Danger");
                yield 3;
            }
            default -> 0;
        };
        System.out.println(priorityLevel4);

        //Recall that switch expressions must be exhaustive, but not switch statements.

    }
}
