package com.revature.app.models;
import java.util.Objects;

//creating UserRole class and encapsulating states
public class UserRole {
        private String id;
        private String roleName;

        public UserRole() {
                super();
        }
        //creating constructor for parameters
        public UserRole(String id, String roleName) {
                this.id = id;
                this.roleName = roleName;
        }

        public String getId() {
                return id;
        }

        public void setId(String id) {
                this.id = id;
        }

        public String getRoleName() {
                return roleName;
        }

        public void setRoleName(String roleName) {
                this.roleName = roleName;
        }

        @Override
        public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                UserRole userRole = (UserRole) o;
                return Objects.equals(id, userRole.id) && Objects.equals(roleName, userRole.roleName);
        }

        @Override
        public int hashCode() {
                return Objects.hash(id, roleName);
        }

        //overriding toString method for client/user readability
        @Override
        public String toString() {
                return "UserRole{" +
                        "id='" + id + '\'' +
                        ", role_name='" + roleName + '\'' + '}';
        }
}