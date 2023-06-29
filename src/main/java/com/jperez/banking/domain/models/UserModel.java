package com.jperez.banking.domain.models;

public class UserModel {

    private Long id;
    private String name;
    private String documentNumber;
    private String email;
    private String password;
    private String confirmPassword;
    private RoleModel role;

    public UserModel() {}

    public UserModel(Long id, String name, String documentNumber, String email,
                     String password, String confirmPassword, RoleModel role) {
        this.id = id;
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public RoleModel getRole() {
        return role;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }
}
