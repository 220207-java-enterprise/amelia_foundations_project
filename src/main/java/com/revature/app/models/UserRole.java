package com.revature.app.models;

//creating UserRole class and encapsulating states
public class UserRole {
        private String roleId;
        private String role;

        public UserRole() {
                super();
        }
        //creating constructor for parameters
        public UserRole(String roleId, String role) {
                this.roleId = roleId;
                this.role = role;
        }

        public String getRoleId() {
                return roleId;
        }

        public void setRoleId(String roleId) {
                this.roleId = roleId;
        }

        public String getRole() {
                return role;
        }

        public void setRole(String role) {
                this.role = role;
        }

        //overriding toString method for client/user readability
        @Override
        public String toString() {
                return "UserRole{" +
                        "role_id='" + roleId + '\'' +
                        ", role='" + role + '\'' + '}';
        }
}