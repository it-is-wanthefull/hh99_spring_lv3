package com.sparta.hh99_spring_lv3.model.enumtype;

public enum StaffRoleEnum {
    STAFF(Authority.STAFF),  // 사용자 권한
    MANAGER(Authority.MANAGER);  // 관리자 권한

    private final String authority;

    StaffRoleEnum(String authority) {
        this.authority = authority;
    }

    public String getAuthority() {
        return this.authority;
    }

    public static class Authority {
        public static final String STAFF = "ROLE_STAFF";
        public static final String MANAGER = "ROLE_MANAGER";
    }
}
