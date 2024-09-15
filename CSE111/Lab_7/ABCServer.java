public class ABCServer {
    private String serverName;
    private int capacity;
    private String[] members;
    private String[] roles;
    private int count;

    public ABCServer(){
        serverName = "Default";
        capacity = 10;
        members = new String[capacity];
        roles = new String[capacity];
        count = 0;
    }

    public ABCServer(String nm, int cp){
        serverName = nm;
        capacity = cp;
        members = new String[capacity];
        roles = new String[capacity];
        count = 0;
    }

    public void addMembers(String m){
        if (count >= capacity){
            System.out.println("Sorry, maximum capacity exceeded!");
        }
        members[count] = m;
        roles[count] = "Rising Hero";
        count++;
        System.out.println("Rising Hero is added.");
    }

    public void addMembers(String m, String r) {
        if (count >=capacity) {
            System.out.println("Sorry, maximum capacity exceeded!");
            return;
        }
        members[count] = m;
        roles[count] = r;
        count++;
        System.out.println(r + " is added.");
    }

    public void details(){
        System.out.println("Server Name: " + serverName);
        System.out.println("Member Capacity: " + capacity);
        System.out.println("Total Members: " + count);
        System.out.println("Members:");
        for (int i = 0; i < count; i++) {
            System.out.println("Name:Role --> " + members[i] + ":" + roles[i]);
        }
    }
}
