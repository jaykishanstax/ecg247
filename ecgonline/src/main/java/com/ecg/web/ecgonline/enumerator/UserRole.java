package com.ecg.web.ecgonline.enumerator;

public enum UserRole {
	SUPERADMIN("Superadmin"), ADMIN("Admin"), SUPERVISOR("Supervisor"), SALESMAN("Salesman");
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
