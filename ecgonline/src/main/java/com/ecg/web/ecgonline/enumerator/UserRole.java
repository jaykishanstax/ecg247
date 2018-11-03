package com.ecg.web.ecgonline.enumerator;

public enum UserRole {
	ADMIN("Ecg247 Admin"), USER("End User"), OWNER("Owner"), PICKUP_USER("Pick Up User");
    private String userRole;

    UserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserRole() {
    	return userRole;
    }
    public static UserRole valueFrom(String userRoleName) {
        for(UserRole userRole : UserRole.values())
        {
        	if(userRole.getUserRole().equals(userRoleName))
        		return userRole;
        }
        return null;
    }

    public String toString() {
        return this.userRole;
    }
}
