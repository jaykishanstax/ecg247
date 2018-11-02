package com.ecg.web.ecgonline.enumerator;

public enum UserStatus {
	ACTIVE("Active"), IN_ACTIVE("In Active"), SUSPENDED("Suspended"), INVITED("Invited");
    private String userStatus;

    public String getUserStatus() {
		return userStatus;
	}

	UserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    public static UserStatus valueFromName(String userStatusDescription) {
    	for(UserStatus userStatus : UserStatus.values())
        {
      	  if(userStatus.getUserStatus().equals(userStatusDescription))
      		  return userStatus;
        }
        return null;
    }

    public String toString() {
        return this.userStatus;
    }

}
