package gibb.m183.m183project.payload.request;

public class UserRequest {
    private String role;

    public UserRequest() {
    }

    public UserRequest(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
