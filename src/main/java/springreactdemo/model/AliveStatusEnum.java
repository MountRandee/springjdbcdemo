package springreactdemo.model;

import java.util.HashMap;

public enum AliveStatusEnum {
    YES ("yes"),
    NO  ("no");
    
    private final String name;
    
    private AliveStatusEnum(String name) {
        this.name = name;
    }
    
    public String getName() {
        return this.name;
    }
    
    private static HashMap<String, AliveStatusEnum> lookupMap = new HashMap<>();
    static {
        for (AliveStatusEnum status : AliveStatusEnum.values()) {
            lookupMap.put(status.getName(), status);
        }
    }
    
    public static AliveStatusEnum get(String aliveStatus) {
        if (aliveStatus == null || aliveStatus.trim().isEmpty()) {
            return null;
        }
        return lookupMap.get(aliveStatus.toLowerCase());
    }
    
    @Override 
    public String toString() { 
        return this.name(); 
    }
}
